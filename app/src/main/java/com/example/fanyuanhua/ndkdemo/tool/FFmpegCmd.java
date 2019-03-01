package com.example.fanyuanhua.ndkdemo.tool;

public class FFmpegCmd {
    public native static String stringFormJni();

    static {
        System.loadLibrary("avcodec-57");
        System.loadLibrary("avdevice-57");
        System.loadLibrary("avfilter-6");
        System.loadLibrary("avformat-57");
        System.loadLibrary("avutil-55");
        System.loadLibrary("swresample-2");
        System.loadLibrary("swscale-4");
        System.loadLibrary("mixed-voice");
    }
}
