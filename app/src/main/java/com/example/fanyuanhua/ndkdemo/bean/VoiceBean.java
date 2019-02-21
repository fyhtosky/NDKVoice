package com.example.fanyuanhua.ndkdemo.bean;

public class VoiceBean {
    private int iId;
    private String iName;


    public VoiceBean() {
    }

    public VoiceBean(int iId, String iName) {
        this.iId = iId;
        this.iName = iName;

    }

    public int getiId() {
        return iId;
    }

    public void setiId(int iId) {
        this.iId = iId;
    }

    public String getiName() {
        return iName;
    }

    public void setiName(String iName) {
        this.iName = iName;
    }

}
