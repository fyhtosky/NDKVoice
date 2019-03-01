package com.example.fanyuanhua.ndkdemo;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.fanyuanhua.ndkdemo.adapter.VoiceAdapter;
import com.example.fanyuanhua.ndkdemo.bean.VoiceBean;
import com.example.fanyuanhua.ndkdemo.tool.FmodUtils;
import com.example.fanyuanhua.ndkdemo.tool.ObservableModel;

import org.fmod.FMOD;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/**
 * 实现变声的效果
 */
public class VoiceChangeActivity extends AppCompatActivity implements VoiceAdapter.OnItemOnClick {
    List<VoiceBean> voiceBeanList = new ArrayList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_voice_change);
        FMOD.init(this);

        initView();
    }

    private void initView() {
        initData();
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        GridLayoutManager manager = new GridLayoutManager(this, 4, RecyclerView.VERTICAL, false);
        recyclerView.setLayoutManager(manager);

        VoiceAdapter voiceAdapter = new VoiceAdapter(this, voiceBeanList);
        voiceAdapter.setOnItemOnClick(this);
        recyclerView.setAdapter(voiceAdapter);
        findViewById(R.id.bt_mixed_voiced).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(VoiceChangeActivity.this, MixedVoiceActivity.class));
            }
        });

    }


    private void initData() {
        voiceBeanList.add(new VoiceBean(R.mipmap.img_voice_default, "原声"));
        voiceBeanList.add(new VoiceBean(R.mipmap.img_voice_loli, "萝莉"));
        voiceBeanList.add(new VoiceBean(R.mipmap.img_voice_man, "大叔"));
        voiceBeanList.add(new VoiceBean(R.mipmap.img_voice_thriller, "惊悚"));
        voiceBeanList.add(new VoiceBean(R.mipmap.img_voice_funny, "搞怪"));
        voiceBeanList.add(new VoiceBean(R.mipmap.img_voice_ghost, "空灵"));
        voiceBeanList.add(new VoiceBean(R.mipmap.img_voice_vally, "山谷"));
        voiceBeanList.add(new VoiceBean(R.mipmap.img_voice_hall, "大堂"));

        voiceBeanList.add(new VoiceBean(R.mipmap.img_voice_classroom, "教室"));
        voiceBeanList.add(new VoiceBean(R.mipmap.img_voice_girl, "女声"));
        voiceBeanList.add(new VoiceBean(R.mipmap.img_voice_live, "现场演出"));
        voiceBeanList.add(new VoiceBean(R.mipmap.img_voice_yellow, "小黄人"));
        voiceBeanList.add(new VoiceBean(R.mipmap.img_voice_snail, "慢吞吞"));
        voiceBeanList.add(new VoiceBean(R.mipmap.img_voice_chorus, "合唱"));
        voiceBeanList.add(new VoiceBean(R.mipmap.img_bgvoice_electricity, "强电流"));
        voiceBeanList.add(new VoiceBean(R.mipmap.img_bgvoice_foreigners, "歪果仁"));

        voiceBeanList.add(new VoiceBean(R.mipmap.img_bgvoice_electricity, "男神"));
        voiceBeanList.add(new VoiceBean(R.mipmap.img_bgvoice_foreigners, "自定义"));


    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        FMOD.close();
    }

    String path = "file:///android_asset/yixue.mp3";

    @Override
    public void onClick(final int position) {
        Log.i("onClick", "点击的位置：" + position);
        ObservableModel.doWorkThread(new ObservableModel.ModelCallBack() {
            @Override
            public void doWorkThreadFunction() {
                switch (position) {
                    case FmodUtils.MODE_NORMAL:
                        FmodUtils.fix(path, FmodUtils.MODE_NORMAL);
                        break;
                    case FmodUtils.MODE_LUOLI:
                        FmodUtils.fix(path, FmodUtils.MODE_LUOLI);
                        break;
                    case FmodUtils.MODE_DASHU:
                        FmodUtils.fix(path, FmodUtils.MODE_DASHU);
                        break;
                    case FmodUtils.MODE_JINGSONG:
                        FmodUtils.fix(path, FmodUtils.MODE_JINGSONG);
                        break;
                    case FmodUtils.MODE_GAOGUAI:
                        FmodUtils.fix(path, FmodUtils.MODE_GAOGUAI);
                        break;
                    case FmodUtils.MODE_KONGLING:
                        FmodUtils.fix(path, FmodUtils.MODE_KONGLING);
                        break;
                    case FmodUtils.MODE_VALLEY:
                        FmodUtils.fix(path, FmodUtils.MODE_VALLEY);
                        break;
                    case FmodUtils.MODE_HALL:
                        FmodUtils.fix(path, FmodUtils.MODE_HALL);
                        break;
                    case FmodUtils.MODE_CLASSROOM:
                        FmodUtils.fix(path, FmodUtils.MODE_CLASSROOM);
                        break;
                    case FmodUtils.MODE_NVSHENG:
                        FmodUtils.fix(path, FmodUtils.MODE_NVSHENG);
                        break;
                    case FmodUtils.MODE_LIVEPERFORMANCE:
                        FmodUtils.fix(path, FmodUtils.MODE_LIVEPERFORMANCE);
                        break;
                    case FmodUtils.MODE_MINIONS:
                        FmodUtils.fix(path, FmodUtils.MODE_MINIONS);
                        break;
                    case FmodUtils.MODE_SLOWLY:
                        FmodUtils.fix(path, FmodUtils.MODE_SLOWLY);
                        break;
                    case FmodUtils.MODE_CHORUS:
                        FmodUtils.fix(path, FmodUtils.MODE_CHORUS);
                        break;
                    case FmodUtils.MODE_DISTORTION:
                        FmodUtils.fix(path, FmodUtils.MODE_DISTORTION);
                        break;
                    case FmodUtils.MODE_MACHINE:
                        FmodUtils.fix(path, FmodUtils.MODE_MACHINE);
                        break;
                    case FmodUtils.MODE_BOY:
                        FmodUtils.fix(path, FmodUtils.MODE_BOY);
                        break;
                    case FmodUtils.MODE_CUSTOM:
//                        FmodUtils.fix(path, FmodUtils.MODE_CUSTOM);
                        FmodUtils.playSoundWithParameter(path,2,10,10);
                        break;
                }
            }

        });
    }
}
