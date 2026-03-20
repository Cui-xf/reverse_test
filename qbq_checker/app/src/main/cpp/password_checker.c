#include <jni.h>
#include <string.h>

/* 密码仅存在于 native 层，供逆向/演示对比 */
static const char *const kSecretPassword = "123qwe";

JNIEXPORT jboolean JNICALL
Java_com_cc_qbq_NativeAuth_verifyPassword(JNIEnv *env, jobject thiz, jstring input) {
    if (input == NULL) {
        return JNI_FALSE;
    }

    const char *input_utf = (*env)->GetStringUTFChars(env, input, NULL);
    if (input_utf == NULL) {
        return JNI_FALSE;
    }

    int match = (strcmp(input_utf, kSecretPassword) == 0);
    (*env)->ReleaseStringUTFChars(env, input, input_utf);

    return match ? JNI_TRUE : JNI_FALSE;
}
