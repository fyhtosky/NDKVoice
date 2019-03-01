package com.example.fanyuanhua.ndkdemo;

import android.os.Bundle;
import android.util.Log;

import com.example.fanyuanhua.ndkdemo.adapter.VoiceAdapter;
import com.example.fanyuanhua.ndkdemo.bean.VoiceBean;
import com.example.fanyuanhua.ndkdemo.tool.FFmpegCmd;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/**
 * 实现将多种声音混合成一种音效
 */
public class MixedVoiceActivity extends AppCompatActivity implements VoiceAdapter.OnItemOnClick {
    List<VoiceBean> voiceBeanList = new ArrayList();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mixed_voice);
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

    }

    private void initData() {
        voiceBeanList.add(new VoiceBean(R.mipmap.img_bgvoice_clapping, "鼓掌"));
        voiceBeanList.add(new VoiceBean(R.mipmap.img_bgvoice_drum, "鼓"));
        voiceBeanList.add(new VoiceBean(R.mipmap.img_bgvoice_horrible, "恐怖"));
        voiceBeanList.add(new VoiceBean(R.mipmap.img_bgvoice_jungle, "丛林"));
        voiceBeanList.add(new VoiceBean(R.mipmap.img_bgvoice_policecar, "警笛"));
        voiceBeanList.add(new VoiceBean(R.mipmap.img_bgvoice_rhythm, "节奏"));
        voiceBeanList.add(new VoiceBean(R.mipmap.img_bgvoice_seawave, "海边"));
        voiceBeanList.add(new VoiceBean(R.mipmap.img_bgvoice_surprised, "惊喜"));
    }

    @Override
    public void onClick(int position) {
       Log.d("MixedVoiceActivity","执行NDK返回值："+FFmpegCmd.stringFormJni()) ;
    }
}
