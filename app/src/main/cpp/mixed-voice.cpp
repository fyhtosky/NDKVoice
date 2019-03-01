//
// Created by 范远华 on 19/2/28.
//

#include "com_example_fanyuanhua_ndkdemo_tool_FFmpegCmd.h"
#include <string>
#include <android/log.h>//android的日志库

JNIEXPORT jstring JNICALL Java_com_example_fanyuanhua_ndkdemo_tool_FFmpegCmd_stringFormJni
        (JNIEnv * env, jclass ){
    std::string hello = "Hello from C++";
    return env->NewStringUTF(hello.c_str());
}