package com.cc.qbq;

import android.util.Log;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: NativeAuth.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u0011\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0086 ¨\u0006\t"}, d2 = {"Lcom/cc/qbq/NativeAuth;", "", "<init>", "()V", "aaa", "", "input", "", "verifyPassword", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class NativeAuth {
    public static final int $stable = 0;
    public static final NativeAuth INSTANCE = new NativeAuth();

    public final native boolean verifyPassword(String input);

    private NativeAuth() {
    }

    static {
        System.loadLibrary("password_checker");
    }

    public final boolean aaa(String input) {
        Intrinsics.checkNotNullParameter(input, "input");
        Log.i("LALALA", "输入：" + input);
        return verifyPassword(input);
    }
}
