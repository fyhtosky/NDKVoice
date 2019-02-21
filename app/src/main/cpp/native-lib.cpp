#include <jni.h>
#include <string>




extern "C"
{
JNIEXPORT jstring JNICALL
Java_com_example_fanyuanhua_ndkdemo_MainActivity_stringFromJNI(
        JNIEnv *env,
        jobject /* this */) {
    std::string hello = "Hello from C++";
    return env->NewStringUTF(hello.c_str());
}

JNIEXPORT jstring JNICALL
Java_com_example_fanyuanhua_ndkdemo_MainActivity_getStringText(JNIEnv *env, jobject instance) {

    // TODO


    return env->NewStringUTF("VanHua is developer");
}
}