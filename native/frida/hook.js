/**
 * Frida Hook 脚本 - qbq_checker 密码逆向
 *
 * Hook 点 1 (Java 层): com.cc.qbq.NativeAuth.aaa()
 *   - 打印用户输入的密码
 *   - 打印校验结果
 *
 * Hook 点 2 (Native 层): libc 的 strcmp
 *   - 在 password_checker.so 的调用范围内捕获比较参数
 *   - 打印正确密码
 */

"use strict";

// ── 工具函数 ──────────────────────────────────────────────────────────────────

function log(tag, msg) {
    console.log("[" + tag + "] " + msg);
}

// 与 adb 对照：adb shell "grep password_checker /proc/<PID>/maps"
log("PROC", "PID: " + Process.id + " | adb: adb shell \"grep -i password_checker /proc/" + Process.id + "/maps\"");

// ── Hook 1: Java 层 NativeAuth.aaa() ─────────────────────────────────────────

Java.perform(function () {
    var NativeAuth = Java.use("com.cc.qbq.NativeAuth");

    NativeAuth.aaa.implementation = function (input) {
        log("JAVA", "用户输入: " + input);

        var result = this.aaa(input);

        log("JAVA", "校验结果: " + (result ? "通过" : "失败"));
        return result;
    };

    log("JAVA", "NativeAuth.aaa hook 已挂载");
});

// ── Hook 2: Native 层 strcmp，定位 password_checker.so 内的调用 ───────────────

// 等待 so 加载完成后再挂载 native hook
function hookStrcmpInPasswordChecker() {
    var soName = "libpassword_checker.so";

    // 获取 so 的内存范围，用于判断调用方是否来自该 so
    var soBase = Module.findBaseAddress(soName);
    if (soBase === null) {
        log("NATIVE", soName + " 尚未加载，等待中...");
        return false;
    }

    var soSize = Process.findModuleByName(soName).size;
    var soEnd = soBase.add(soSize);
    log("NATIVE", soName + " 加载地址: " + soBase + " ~ " + soEnd);

    // 找到 libc strcmp 地址
    var strcmpPtr = Module.findExportByName("libc.so", "strcmp");
    if (strcmpPtr === null) {
        log("NATIVE", "未找到 strcmp，尝试 libc.so...");
        // 部分设备符号在其他库
        strcmpPtr = Module.findExportByName(null, "strcmp");
    }
    if (strcmpPtr === null) {
        log("NATIVE", "无法定位 strcmp");
        return false;
    }
    log("NATIVE", "strcmp 地址: " + strcmpPtr);

    Interceptor.attach(strcmpPtr, {
        onEnter: function (args) {
            // 过滤：只关注来自 libpassword_checker.so 的调用
            var retAddr = this.returnAddress;
            if (retAddr.compare(soBase) < 0 || retAddr.compare(soEnd) >= 0) {
                return;
            }

            // 安全地读取两个 C 字符串
            try {
                var s1 = args[0].readCString();
                var s2 = args[1].readCString();
                log("NATIVE", "strcmp 拦截 (来自 " + soName + ")");
                log("NATIVE", "  arg1 = " + s1);
                log("NATIVE", "  arg2 = " + s2);
                log("NATIVE", ">>> 正确密码很可能是上面两个字符串之一 <<<");
            } catch (e) {
                log("NATIVE", "读取参数失败: " + e);
            }
        }
    });

    log("NATIVE", "strcmp hook 已挂载，仅过滤来自 " + soName + " 的调用");
    return true;
}

// 先尝试直接挂载（so 可能已经加载）
if (!hookStrcmpInPasswordChecker()) {
    // 监听模块加载事件，so 加载后自动挂载
    var listener = Process.setExceptionHandler(function () {
        return false;
    }); // 占位，防止未使用变量警告

    var interval = setInterval(function () {
        if (hookStrcmpInPasswordChecker()) {
            clearInterval(interval);
        }
    }, 500);
}

//
// 等待 so 加载完成后再挂载 native hook
function myNativeHook() {
    var soName = "libpassword_checker.so";

    // 获取 so 的内存范围，用于判断调用方是否来自该 so
    var soBase = Module.findBaseAddress(soName);
    if (soBase === null) {
        log("NATIVE", soName + " 尚未加载，等待中...");
        return false;
    }

    var soSize = Process.findModuleByName(soName).size;
    var soEnd = soBase.add(soSize);
    log("NATIVE", soName + " 加载地址: " + soBase + " ~ " + soEnd);

    // 找到 libc strcmp 地址
    var verifyPassword = Module.findExportByName(soName, "Java_com_cc_qbq_NativeAuth_verifyPassword");
    if (verifyPassword === null) {
        log("NATIVE", "未找到 Java_com_cc_qbq_NativeAuth_verifyPassword，尝试其他so...");
        // 部分设备符号在其他库
        verifyPassword = Module.findExportByName(null, "Java_com_cc_qbq_NativeAuth_verifyPassword");
    }
    if (verifyPassword === null) {
        log("NATIVE", "无法定位 Java_com_cc_qbq_NativeAuth_verifyPassword");
        return false;
    }
    log("NATIVE", "Java_com_cc_qbq_NativeAuth_verifyPassword 地址: " + verifyPassword);

    Interceptor.attach(verifyPassword, {
        onEnter: function (args) {
            // 安全地读取两个 C 字符串
            try {
                log("NATIVE", "Java_com_cc_qbq_NativeAuth_verifyPassword 拦截 (来自 " + soName + ")");
                var env = Java.vm.getEnv();
                var inputStr = env.getStringUtfChars(args[2], null).readCString();
                log("NATIVE", "  input = " + inputStr);
            } catch (e) {
                log("NATIVE", "读取参数失败: " + e);
            }
        }
    });

    log("NATIVE", "Java_com_cc_qbq_NativeAuth_verifyPassword hook 已挂载");
    return true;
}

// 先尝试直接挂载（so 可能已经加载）
if (!myNativeHook()) {
    // 监听模块加载事件，so 加载后自动挂载
    var listener2 = Process.setExceptionHandler(function () {
        return false;
    }); // 占位，防止未使用变量警告

    var interval2 = setInterval(function () {
        if (myNativeHook()) {
            clearInterval(interval2);
        }
    }, 500);
}
