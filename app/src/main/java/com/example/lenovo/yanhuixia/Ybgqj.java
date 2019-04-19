package com.example.lenovo.yanhuixia;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

public class Ybgqj implements Serializable {
    private int id;
    private String chejian;
    private String gongqu;
    private String shijian;
    private String mingcheng;
    private String changjia;
    private String danwei;
    private int shuliang;
    private String gongneng;
    private String laiyuan;
    private String fafangren;
    private String jieshouren;
    private String shouhuodanhao;
    private String fafangdanhao;
    private String chukuqingkuang;
    private String chukushijian;
    private String chukushiyongren;
    private String beizhu;
    public Ybgqj(int id,String chejian,String gongqu,String shijian,String mingcheng,String changjia,String danwei,int shuliang,
                 String gongneng,String laiyuan,String fafangren,String jieshouren,String shouhuodanhao,String fafangdanhao,
                 String chukuqingkuang,String chukushijian,String chukushiyongren,String beizhu) {
        this.id = id;
        this.chejian = chejian;
        this.gongqu = gongqu;
        this.shijian = shijian;
        this.mingcheng = mingcheng;
        this.changjia = changjia;
        this.danwei = danwei;
        this.shuliang = shuliang;
        this.gongneng = gongneng;
        this.laiyuan = laiyuan;
        this.fafangren = fafangren;
        this.jieshouren = jieshouren;
        this.shouhuodanhao = shouhuodanhao;
        this.fafangdanhao = fafangdanhao;
        this.chukuqingkuang = chukuqingkuang;
        this.chukushijian = chukushijian;
        this.chukushiyongren = chukushiyongren;
        this.beizhu = beizhu;
    }

    protected Ybgqj(Parcel in) {
        id = in.readInt();
        chejian = in.readString();
        gongqu = in.readString();
        shijian = in.readString();
        mingcheng = in.readString();
        changjia = in.readString();
        danwei = in.readString();
        shuliang = in.readInt();
        gongneng = in.readString();
        laiyuan = in.readString();
        fafangren = in.readString();
        jieshouren = in.readString();
        shouhuodanhao = in.readString();
        fafangdanhao = in.readString();
        chukuqingkuang = in.readString();
        chukushijian = in.readString();
        chukushiyongren = in.readString();
        beizhu = in.readString();
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getChejian() {
        return chejian;
    }

    public void setChejian(String chejian) {
        this.chejian = chejian;
    }

    public String getGongqu() {
        return gongqu;
    }

    public void setGongqu(String gongqu) {
        this.gongqu = gongqu;
    }

    public String getShijian() {
        return shijian;
    }

    public void setShijian(String shijian) {
        this.shijian = shijian;
    }

    public String getMingcheng() {
        return mingcheng;
    }

    public void setMingcheng(String mingcheng) {
        this.mingcheng = mingcheng;
    }

    public String getChangjia() {
        return changjia;
    }

    public void setChangjia(String changjia) {
        this.changjia = changjia;
    }

    public String getDanwei() {
        return danwei;
    }

    public void setDanwei(String danwei) {
        this.danwei = danwei;
    }

    public int getShuliang() {
        return shuliang;
    }

    public void setShuliang(int shuliang) {
        this.shuliang = shuliang;
    }

    public String getGongneng() {
        return gongneng;
    }

    public void setGongneng(String gongneng) {
        this.gongneng = gongneng;
    }

    public String getLaiyuan() {
        return laiyuan;
    }

    public void setLaiyuan(String laiyuan) {
        this.laiyuan = laiyuan;
    }

    public String getFafangren() {
        return fafangren;
    }

    public void setFafangren(String fafangren) {
        this.fafangren = fafangren;
    }

    public String getJieshouren() {
        return jieshouren;
    }

    public void setJieshouren(String jieshouren) {
        this.jieshouren = jieshouren;
    }

    public String getShouhuodanhao() {
        return shouhuodanhao;
    }

    public void setShouhuodanhao(String shouhuodanhao) {
        this.shouhuodanhao = shouhuodanhao;
    }

    public String getFafangdanhao() {
        return fafangdanhao;
    }

    public void setFafangdanhao(String fafangdanhao) {
        this.fafangdanhao = fafangdanhao;
    }

    public String getChukuqingkuang() {
        return chukuqingkuang;
    }

    public void setChukuqingkuang(String chukuqingkuang) {
        this.chukuqingkuang = chukuqingkuang;
    }

    public String getChukushijian() {
        return chukushijian;
    }

    public void setChukushijian(String chukushijian) {
        this.chukushijian = chukushijian;
    }

    public String getChukushiyongren() {
        return chukushiyongren;
    }

    public void setChukushiyongren(String chukushiyongren) {
        this.chukushiyongren = chukushiyongren;
    }

    public String getBeizhu() {
        return beizhu;
    }

    public void setBeizhu(String beizhu) {
        this.beizhu = beizhu;
    }
/*
    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(chejian);
        dest.writeString(gongqu);
        dest.writeString(shijian);
        dest.writeString(mingcheng);
        dest.writeString(changjia);
        dest.writeString(danwei);
        dest.writeInt(shuliang);
        dest.writeString(gongneng);
        dest.writeString(laiyuan);
        dest.writeString(fafangren);
        dest.writeString(jieshouren);
        dest.writeString(shouhuodanhao);
        dest.writeString(fafangdanhao);
        dest.writeString(chukuqingkuang);
        dest.writeString(chukushijian);
        dest.writeString(chukushiyongren);
        dest.writeString(beizhu);
    }

    public static final Creator<Ybgqj> CREATOR = new Creator<Ybgqj>() {
        @Override
        public Ybgqj createFromParcel(Parcel in) {
           Ybgqj ybgqj = new Ybgqj();
        }

        @Override
        public Ybgqj[] newArray(int size) {
            return new Ybgqj[size];
        }
    };
    */

}
