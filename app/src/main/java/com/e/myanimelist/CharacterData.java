package com.e.myanimelist;

import android.os.Parcel;
import android.os.Parcelable;

public class CharacterData implements Parcelable {

    private String nama;
    private int images;
    private String deskripsi;

    public String getNama() {
        return nama;
    }

    public int getImages() {
        return images;
    }

    public String getDeskripsi() {
        return deskripsi;
    }


    public CharacterData(String nama, int images) {
        this.nama = nama;
        this.images = images;
    }

    public CharacterData(String nama, int images, String deskripsi) {
        this.nama = nama;
        this.images = images;
        this.deskripsi = deskripsi;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.nama);
        dest.writeInt(this.images);
        dest.writeString(this.deskripsi);
    }

    protected CharacterData(Parcel in) {
        this.nama = in.readString();
        this.images = in.readInt();
        this.deskripsi = in.readString();
    }

    public static final Parcelable.Creator<CharacterData> CREATOR = new Parcelable.Creator<CharacterData>() {
        @Override
        public CharacterData createFromParcel(Parcel source) {
            return new CharacterData(source);
        }

        @Override
        public CharacterData[] newArray(int size) {
            return new CharacterData[size];
        }
    };
}