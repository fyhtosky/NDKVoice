# For more information about using CMake with Android Studio, read the
# documentation: https://d.android.com/studio/projects/add-native-code.html

# Sets the minimum version of CMake required to build the native library.
#设置构建本机库文件所需的 CMake的最小版本
cmake_minimum_required(VERSION 3.4.1)



# Creates and names a library, sets it as either STATIC
# or SHARED, and provides the relative paths to its source code.
# You can define multiple libraries, and CMake builds them for you.
# Gradle automatically packages shared libraries with your APK.
#把系统的log库导入进来
find_library( # Sets the name of the path variable.
        log-lib

        # Specifies the name of the NDK library that
        # you want CMake to locate.
        log )

set(distribution_DIR ${CMAKE_SOURCE_DIR}/libs)

#添加fmod 动态库
add_library( fmod
        SHARED
        IMPORTED )
set_target_properties( fmod
        PROPERTIES IMPORTED_LOCATION
        ${distribution_DIR}/${ANDROID_ABI}/libfmod.so )

#把libfmodL.so预加载进来
add_library( fmodL
        SHARED
        IMPORTED )
set_target_properties( fmodL
        PROPERTIES IMPORTED_LOCATION
        ${distribution_DIR}/${ANDROID_ABI}/libfmodL.so )

#导入路径，为了让编译时能够寻找到这个文件夹
include_directories(src/main/cpp/inc)

# Searches for a specified prebuilt library and stores the path as a
# variable. Because CMake includes system libraries in the search path by
# default, you only need to specify the name of the public NDK library
# you want to add. CMake verifies that the library exists before
# completing its build.

#添加自己写的 C/C++源文件
add_library( # Sets the name of the library.
        native-lib

        # Sets the library as a shared library.
        SHARED

        # Provides a relative path to your source file(s).
        src/main/cpp/native-lib.cpp )

add_library(# Sets the name of the library.
        text-demo

        # Sets the library as a shared library.
        SHARED

        # Provides a relative path to your source file(s).
        src/main/cpp/text-demo.cpp

        )





# Specifies libraries CMake should link to your target library. You
# can link multiple libraries, such as libraries you define in this
# build script, prebuilt third-party libraries, or system libraries.
#将目标库与 NDK中的库进行连接
target_link_libraries( # Specifies the target library.
                       native-lib

                       # Links the target library to the log library
                       # included in the NDK.
                       ${log-lib} )
#将目标库与 NDK中的库进行连接
target_link_libraries( # Specifies the target library.
                       text-demo
                       fmod
                       fmodL
                       # Links the target library to the log library
                       # included in the NDK.
                       ${log-lib} )