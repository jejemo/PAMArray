package com.maho.upi.pamarray.Model;

import com.google.gson.annotations.SerializedName;

@SuppressWarnings("ALL")
public class ModelListData {
    @SerializedName("ikon")
    private String ikon;
    @SerializedName("profile")
    private String  profile;
    @SerializedName("nama")
    private String nama;
    @SerializedName("nomor")
    private String nomor;
    @SerializedName("posisi")
    private String posisi;
    @SerializedName("negara")
    private String negara;
    @SerializedName("team")
    private String tim;

    public ModelListData(String ikon, String profile, String nama, String nomor, String posisi, String negara, String tim) {
        this.ikon = ikon;
        this.profile = profile;
        this.nama = nama;
        this.nomor = nomor;
        this.posisi = posisi;
        this.negara = negara;
        this.tim = tim;
    }

    public String getIkon() {
        return ikon;
    }

    public void setIkon(String ikon) {
        this.ikon = ikon;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNomor() {
        return nomor;
    }

    public void setNomor(String nomor) {
        this.nomor = nomor;
    }

    public String getPosisi() {
        return posisi;
    }

    public void setPosisi(String posisi) {
        this.posisi = posisi;
    }

    public String getNegara() {
        return negara;
    }

    public void setNegara(String negara) {
        this.negara = negara;
    }

    public String getTim() {
        return tim;
    }

    public void setTim(String tim) {
        this.tim = tim;
    }
}
