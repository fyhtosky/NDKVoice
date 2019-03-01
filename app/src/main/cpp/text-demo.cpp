//
// Created by 范远华 on 18/12/12.
//
#include "com_example_fanyuanhua_ndkdemo_tool_FmodUtils.h"
#include "inc/fmod.hpp"
#include <jni.h>
#include <stdlib.h>
#include <unistd.h>

   //变声类型
#define MODE_NORMAL 0          //原声
#define MODE_LUOLI 1           //萝莉
#define MODE_DASHU 2           //大叔
#define MODE_JINGSONG 3        //恐怖

#define MODE_GAOGUAI 4         //搞怪
#define MODE_KONGLING 5        //空灵
#define MODE_VALLEY 6          //山谷
#define MODE_HALL 7            //礼堂

#define MODE_CLASSROOM 8       //教室
#define MODE_NVSHENG 9         //女声
#define MODE_LIVEPERFORMANCE 10//现场演出
#define MODE_MINIONS 11        //小黄人

#define MODE_SLOWLY 12         //慢吞吞
#define MODE_CHORUS 13         //合唱
#define MODE_DISTORTION 14     //强电流
#define MODE_MACHINE 15        //外国人
#define MODE_BOY 16    //男声
#define MODE_CUSTOM 17      //自定义

 //日志库
#include <android/log.h>
#define LOGI(FORMAT,...) __android_log_print(ANDROID_LOG_INFO,"zph",FORMAT,##__VA_ARGS__);
#define LOGE(FORMAT,...) __android_log_print(ANDROID_LOG_ERROR,"zph",FORMAT,##__VA_ARGS__);

using namespace FMOD;
bool shouldPause = false;
bool shouldPlaying = false;
extern "C"
JNIEXPORT void JNICALL
Java_com_example_fanyuanhua_ndkdemo_tool_FmodUtils_fix(JNIEnv *env, jclass type_, jstring path_,
                                                       jint type) {
    //声音引擎
    System *system;
    //声音
    Sound *sound;
    //数字处理（音效）
    DSP *dsp;
    //正在播放
    bool playing = true;
    //音乐轨道
    Channel *channel;
    //播放速度
    float frequency = 0;
    //音频地址
    const char* path_cstr = env->GetStringUTFChars(path_, 0);

    System_Create(&system);
    system->init(32, FMOD_INIT_NORMAL, NULL);
    shouldPause = false;
    shouldPlaying = false;
    try {
        //创建声音
        system->createSound(path_cstr, FMOD_DEFAULT, NULL, &sound);
        switch (type) {
            case MODE_NORMAL:
                LOGI("%s", "正常");
                //原生播放
                system->playSound(sound, 0, false, &channel);
                break;
            case MODE_LUOLI:
                LOGI("%s", "萝莉")
                //提升或者降低音调的一种音效
                system->createDSPByType(FMOD_DSP_TYPE_PITCHSHIFT, &dsp);
                //设置音调的参数
                dsp->setParameterFloat(FMOD_DSP_PITCHSHIFT_PITCH, 1.8);
                //添加进到channel，添加进轨道
                system->playSound(sound, 0, false, &channel);
                channel->addDSP(0, dsp);
                break;
            case MODE_DASHU :
                LOGI("%s", "大叔");
                system->createDSPByType(FMOD_DSP_TYPE_PITCHSHIFT, &dsp);
                dsp->setParameterFloat(FMOD_DSP_PITCHSHIFT_PITCH, 0.8);
                system->playSound(sound, 0, false, &channel);
                channel->addDSP(0, dsp);
                break;
            case MODE_JINGSONG:
                LOGI("%s", "惊悚");
                system->createDSPByType(FMOD_DSP_TYPE_TREMOLO, &dsp);
                dsp->setParameterFloat(FMOD_DSP_TREMOLO_SKEW, 0.8);
                system->playSound(sound, 0, false, &channel);
                channel->addDSP(0, dsp);
                break;
            case MODE_GAOGUAI:
                //提高说话的速度
                LOGI("%s", "搞怪");
                system->playSound(sound, 0, false, &channel);
                channel->getFrequency(&frequency);
                frequency = frequency * 2;
                channel->setFrequency(frequency);
                break;
            case MODE_KONGLING:
                LOGI("%s", "空灵");
                system->createDSPByType(FMOD_DSP_TYPE_ECHO, &dsp);
                dsp->setParameterFloat(FMOD_DSP_ECHO_DELAY, 300);
                dsp->setParameterFloat(FMOD_DSP_ECHO_FEEDBACK, 20);
                system->playSound(sound, 0, false, &channel);
                channel->addDSP(0, dsp);
                break;


            case MODE_VALLEY:
                LOGI("%s", "山谷");
                system->createDSPByType(FMOD_DSP_TYPE_ECHO, &dsp);
                dsp->setParameterFloat(FMOD_DSP_ECHO_DELAY, 500);
                dsp->setParameterFloat(FMOD_DSP_ECHO_FEEDBACK, 22);
                dsp->setParameterFloat(FMOD_DSP_ECHO_WETLEVEL, -15);
                system->playSound(sound, 0, false, &channel);
                channel->addDSP(0, dsp);
                break;
            case MODE_HALL:
                LOGI("%s", "大堂");
                system->createDSPByType(FMOD_DSP_TYPE_SFXREVERB, &dsp);
//                setSFXArguments(dsp,4300, 20, 30, 5000, 59, 100, 100, 250, 0, 5850, 64, -11.7f);

                dsp->setParameterFloat(FMOD_DSP_SFXREVERB_DECAYTIME, 4300);
                dsp->setParameterFloat(FMOD_DSP_SFXREVERB_EARLYDELAY, 20);
                dsp->setParameterFloat(FMOD_DSP_SFXREVERB_LATEDELAY, 30);
                dsp->setParameterFloat(FMOD_DSP_SFXREVERB_HFREFERENCE, 5000);
                dsp->setParameterFloat(FMOD_DSP_SFXREVERB_HFDECAYRATIO, 59);
                dsp->setParameterFloat(FMOD_DSP_SFXREVERB_DIFFUSION, 100);
                dsp->setParameterFloat(FMOD_DSP_SFXREVERB_DENSITY, 100);
                dsp->setParameterFloat(FMOD_DSP_SFXREVERB_LOWSHELFFREQUENCY, 250);
                dsp->setParameterFloat(FMOD_DSP_SFXREVERB_LOWSHELFGAIN, 0);
                dsp->setParameterFloat(FMOD_DSP_SFXREVERB_HIGHCUT, 5850);
                dsp->setParameterFloat(FMOD_DSP_SFXREVERB_EARLYLATEMIX, 64);
                dsp->setParameterFloat(FMOD_DSP_SFXREVERB_WETLEVEL, -11.7);
                system->playSound(sound, 0, false, &channel);
                channel->addDSP(0, dsp);
                break;
            case MODE_CLASSROOM:
                LOGI("%s", "教室");
                system->createDSPByType(FMOD_DSP_TYPE_SFXREVERB, &dsp);
                dsp->setParameterFloat(FMOD_DSP_SFXREVERB_DECAYTIME, 400);
                dsp->setParameterFloat(FMOD_DSP_SFXREVERB_EARLYDELAY, 2);
                dsp->setParameterFloat(FMOD_DSP_SFXREVERB_LATEDELAY, 3);
                dsp->setParameterFloat(FMOD_DSP_SFXREVERB_HFREFERENCE, 5000);
                dsp->setParameterFloat(FMOD_DSP_SFXREVERB_HFDECAYRATIO, 83);
                dsp->setParameterFloat(FMOD_DSP_SFXREVERB_DIFFUSION, 100);
                dsp->setParameterFloat(FMOD_DSP_SFXREVERB_DENSITY, 100);
                dsp->setParameterFloat(FMOD_DSP_SFXREVERB_LOWSHELFFREQUENCY, 250);
                dsp->setParameterFloat(FMOD_DSP_SFXREVERB_LOWSHELFGAIN, 0);
                dsp->setParameterFloat(FMOD_DSP_SFXREVERB_HIGHCUT, 6050);
                dsp->setParameterFloat(FMOD_DSP_SFXREVERB_EARLYLATEMIX, 88);
                dsp->setParameterFloat(FMOD_DSP_SFXREVERB_WETLEVEL, -9.4);
                system->playSound(sound, 0, false, &channel);
                channel->addDSP(0, dsp);
                break;
            case MODE_NVSHENG:
                LOGI("%s", "女声");
                //提升或者降低音调的一种音效 女声
                system->createDSPByType(FMOD_DSP_TYPE_PITCHSHIFT, &dsp);
                //设置音调的参数
                dsp->setParameterFloat(FMOD_DSP_PITCHSHIFT_PITCH, 1.6);
                //添加进到channel，添加进轨道
                system->playSound(sound, 0, false, &channel);
                channel->addDSP(0, dsp);
                break;
            case MODE_LIVEPERFORMANCE:
                LOGI("%s", "现场演出");
                system->createDSPByType(FMOD_DSP_TYPE_SFXREVERB, &dsp);
                dsp->setParameterFloat(FMOD_DSP_SFXREVERB_DECAYTIME, 3900);
                dsp->setParameterFloat(FMOD_DSP_SFXREVERB_EARLYDELAY, 20);
                dsp->setParameterFloat(FMOD_DSP_SFXREVERB_LATEDELAY, 29);
                dsp->setParameterFloat(FMOD_DSP_SFXREVERB_HFREFERENCE, 5000);
                dsp->setParameterFloat(FMOD_DSP_SFXREVERB_HFDECAYRATIO, 70);
                dsp->setParameterFloat(FMOD_DSP_SFXREVERB_DIFFUSION, 100);
                dsp->setParameterFloat(FMOD_DSP_SFXREVERB_DENSITY, 100);
                dsp->setParameterFloat(FMOD_DSP_SFXREVERB_LOWSHELFFREQUENCY, 250);
                dsp->setParameterFloat(FMOD_DSP_SFXREVERB_LOWSHELFGAIN, 0);
                dsp->setParameterFloat(FMOD_DSP_SFXREVERB_HIGHCUT, 5650);
                dsp->setParameterFloat(FMOD_DSP_SFXREVERB_EARLYLATEMIX, 80);
                dsp->setParameterFloat(FMOD_DSP_SFXREVERB_WETLEVEL, -9.8);
                system->playSound(sound, 0, false, &channel);
                channel->addDSP(0, dsp);
                break;
            case MODE_MINIONS:
                LOGI("%s", "小黄人");
                system->createDSPByType(FMOD_DSP_TYPE_PITCHSHIFT, &dsp);
                //设置音调的参数
                dsp->setParameterFloat(FMOD_DSP_PITCHSHIFT_PITCH, 1.8);
                system->playSound(sound, 0, false, &channel);
                channel->getFrequency(&frequency);
                frequency = frequency * 1.2;
                channel->setFrequency(frequency);
                break;

            case MODE_SLOWLY: //慢吞吞
                LOGI("%s", "慢吞吞");
                system->playSound(sound, 0, false, &channel);
                channel->getFrequency(&frequency);
                frequency = frequency * 0.5;
                channel->setFrequency(frequency);
                break;
            case MODE_CHORUS://合唱
                LOGI("%s", "合唱");
                system->createDSPByType(FMOD_DSP_TYPE_CHORUS, &dsp);
                system->playSound(sound, 0, false, &channel);
                dsp->setParameterFloat(FMOD_DSP_CHORUS_DEPTH, 20);
                dsp->setParameterFloat(FMOD_DSP_CHORUS_RATE, 10);
                channel->addDSP(0, dsp);
                break;
            case MODE_DISTORTION: //强电流
                LOGI("%s", "强电流");
                system->createDSPByType(FMOD_DSP_TYPE_TREMOLO, &dsp);
                dsp->setParameterFloat(FMOD_DSP_TREMOLO_FREQUENCY, 20);
                dsp->setParameterFloat(FMOD_DSP_TREMOLO_SKEW, 0.9);
                system->playSound(sound, 0, false, &channel);
                channel->addDSP(0, dsp);
                break;
            case MODE_MACHINE: //外国人
                LOGI("%s", "外国人");
                system->createDSPByType(FMOD_DSP_TYPE_FLANGE,&dsp);
                dsp->setParameterFloat(FMOD_DSP_FLANGE_MIX,100);
                dsp->setParameterFloat(FMOD_DSP_FLANGE_DEPTH,1.0);
                dsp->setParameterFloat(FMOD_DSP_FLANGE_RATE,4);
                system->playSound(sound, 0, false, &channel);
                channel->addDSP(0, dsp);
                break;
            case MODE_BOY: //男生
                LOGI("%s", "男生");
                //提升或者降低音调的一种音效
                system->createDSPByType(FMOD_DSP_TYPE_PITCHSHIFT, &dsp);
                //设置音调的参数
                dsp->setParameterFloat(FMOD_DSP_PITCHSHIFT_PITCH, 0.9);
                //添加进到channel，添加进轨道
                system->playSound(sound, 0, false, &channel);
                channel->addDSP(0, dsp);
                break;
//            case MODE_CUSTOM: //自定义
//                LOGI("%s", "自定义");
//                system->createDSPByType(FMOD_DSP_TYPE_FLANGE,&dsp);
//                dsp->setParameterFloat(FMOD_DSP_FLANGE_MIX,100);
//                dsp->setParameterFloat(FMOD_DSP_FLANGE_DEPTH,1.0);
//                dsp->setParameterFloat(FMOD_DSP_FLANGE_RATE,4);
//                system->playSound(sound, 0, false, &channel);
//                channel->getFrequency(&frequency);
//                frequency = frequency * 0.5;
//                channel->addDSP(0, dsp);
//                break;

            case MODE_CUSTOM: //自定义
                LOGI("%s", "自定义");
//
                //颤音/斩波效果
                system->createDSPByType(FMOD_DSP_TYPE_TREMOLO, &dsp);
                dsp->setParameterFloat(FMOD_DSP_TREMOLO_FREQUENCY, 20);
                dsp->setParameterFloat(FMOD_DSP_TREMOLO_DEPTH, 0.9);

//                dsp->setParameterFloat(FMOD_DSP_TREMOLO_SHAPE, 1) ;
                dsp->setParameterFloat(FMOD_DSP_TREMOLO_SKEW, 0.9) ;
//                dsp->setParameterFloat(FMOD_DSP_TREMOLO_DUTY, 0) ;
//                dsp->setParameterFloat(FMOD_DSP_TREMOLO_SQUARE, 1) ;
//                dsp->setParameterFloat(FMOD_DSP_TREMOLO_PHASE, 1) ;
//                dsp->setParameterFloat(FMOD_DSP_TREMOLO_SPREAD, 1) ;

                system->playSound(sound, 0, false, &channel);
                channel->addDSP(0, dsp);

                //设置声音的音高的参数
                system->createDSPByType(FMOD_DSP_TYPE_PITCHSHIFT, &dsp);
                dsp->setParameterFloat(FMOD_DSP_PITCHSHIFT_PITCH, 1.4);
                system->playSound(sound, 0, false, &channel);
                channel->addDSP(0, dsp);
                //设置语速
                channel->getFrequency(&frequency);
                frequency = frequency * 1.5;
                channel->setFrequency(frequency);

                break;
        }
    } catch (...) {
        LOGE("%s", "发生异常");
        goto end;
    }
    system->update();

    //单位是微妙
    //每秒钟判断下是否是播放
    while (playing &&!shouldPause) {
        channel->isPlaying(&playing);
        usleep(1000);
    }
    shouldPlaying = true;
    goto end;

    //释放资源
    end: env->ReleaseStringUTFChars(path_, path_cstr);
    sound->release();
    system->close();
    system->release();
}


JNIEXPORT void JNICALL Java_com_example_fanyuanhua_ndkdemo_tool_FmodUtils_playSoundWithParameter
        (JNIEnv * env, jclass, jstring path_jstr, jfloat one, jfloat two, jfloat three){
    //声音引擎
    System *system;
    //声音
    Sound *sound;
    //数字处理（音效）
    DSP *dsp;
    //正在播放
    bool playing = true;
    //音乐轨道
    Channel *channel;
    //播放速度
    float frequency = 0;
    //音频地址
    const char *path_cstr = env->GetStringUTFChars(path_jstr, NULL);

    System_Create(&system);
    system->init(32, FMOD_INIT_NORMAL, NULL);


    shouldPause = false;

    try {
        //创建声音
        system->createSound(path_cstr, FMOD_DEFAULT, NULL, &sound);

        //提升或者降低音调的一种音效
        system->createDSPByType(FMOD_DSP_TYPE_PITCHSHIFT, &dsp);
        //设置音调的参数 0.5 to 2.0    16个
        dsp->setParameterFloat(FMOD_DSP_PITCHSHIFT_PITCH, two);

        system->createDSPByType(FMOD_DSP_TYPE_TREMOLO, &dsp);
        //设置频率的参数0.1 to 20    200 个
        dsp->setParameterFloat(FMOD_DSP_TREMOLO_FREQUENCY, three);

        //添加进到channel，添加进轨道
        system->playSound(sound, 0, false, &channel);

        //设置速度  这个多少都行  8倍以内吧
        channel->getFrequency(&frequency);
        frequency = frequency * one;
        channel->setFrequency(frequency);

        channel->addDSP(0, dsp);


    }
    catch (...) {
        LOGE("%s", "发生异常");
        goto end;
    }

    system->update();

    //单位是微妙
    //每秒钟判断下是否是播放
    while (playing && !shouldPause) {
        channel->isPlaying(&playing);
        usleep(1000);
    }
    shouldPlaying = playing;
    goto end;

    //释放资源
    end:
    env->ReleaseStringUTFChars(path_jstr, path_cstr);
    sound->release();
    system->close();
    system->release();
}

