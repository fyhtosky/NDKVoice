package com.example.fanyuanhua.ndkdemo.tool;

public class FmodUtils {
    //音效类型
    //音效类型
    public static final int MODE_NORMAL = 0;//原声
    public static final int MODE_LUOLI = 1;//萝莉
    public static final int MODE_DASHU = 2;//大叔
    public static final int MODE_JINGSONG = 3;//惊悚
    public static final int MODE_GAOGUAI = 4;//搞怪
    public static final int MODE_KONGLING = 5; //空灵
    public static final int MODE_VALLEY = 6;//山谷
    public static final int MODE_HALL = 7;//大堂
    public static final int MODE_CLASSROOM = 8;//教室
    public static final int MODE_NVSHENG = 9;//女声
    public static final int MODE_LIVEPERFORMANCE = 10;//现场演出
    public static final int MODE_MINIONS = 11; //小黄人
    public static final int MODE_SLOWLY = 12; //慢吞吞
    public static final int MODE_CHORUS= 13; //合唱
    public static final int MODE_DISTORTION= 14; //破音
    public static final int MODE_MACHINE = 15;//机器人
    public static final int MODE_BOY = 16;//男生
    public static final int MODE_CUSTOM = 17;//自定义


    /**
     * 音效处理传2个值
     *
     * @param path 音频文件路径
     * @param type 音频文件类型
     */
    public native static void fix(String path, int type);

    public native static  void playSoundWithParameter(String filepath, float speed, float pitch, float rate);

    static {
        System.loadLibrary("fmodL");
        System.loadLibrary("fmod");
        System.loadLibrary("text-demo");
    }
}
