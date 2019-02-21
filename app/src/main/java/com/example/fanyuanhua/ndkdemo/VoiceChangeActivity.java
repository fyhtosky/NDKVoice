package com.example.fanyuanhua.ndkdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.fanyuanhua.ndkdemo.adapter.VoiceAdapter;
import com.example.fanyuanhua.ndkdemo.bean.VoiceBean;
import com.example.fanyuanhua.ndkdemo.tool.FmodUtils;
import com.example.fanyuanhua.ndkdemo.tool.ObservableModel;

import org.fmod.FMOD;

import java.util.ArrayList;
import java.util.List;

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
        GridLayoutManager manager = new GridLayoutManager(this, 4, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(manager);

        VoiceAdapter voiceAdapter = new VoiceAdapter(this, voiceBeanList);
        voiceAdapter.setOnItemOnClick(this);
        recyclerView.setAdapter(voiceAdapter);

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

//        voiceBeanList.add(new VoiceBean(R.drawable.img_bgvoice_clapping, "鼓掌", false));
//        voiceBeanList.add(new VoiceBean(R.drawable.img_bgvoice_drum, "鼓", false));
//        voiceBeanList.add(new VoiceBean(R.drawable.img_bgvoice_horrible, "恐怖", false));
//        voiceBeanList.add(new VoiceBean(R.drawable.img_bgvoice_jungle, "丛林", false));
//        voiceBeanList.add(new VoiceBean(R.drawable.img_bgvoice_policecar, "警笛", false));
//        voiceBeanList.add(new VoiceBean(R.drawable.img_bgvoice_rhythm, "节奏", false));
//        voiceBeanList.add(new VoiceBean(R.drawable.img_bgvoice_seawave, "海边", false));
//        voiceBeanList.add(new VoiceBean(R.drawable.img_bgvoice_surprised, "惊喜", false));


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
                }
            }

        });
    }
}
