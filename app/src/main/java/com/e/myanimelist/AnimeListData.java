package com.e.myanimelist;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

public class AnimeListData implements Parcelable {

    private String judul, genre, deskripsi;
    private ArrayList<CharacterData> character;

    public ArrayList<CharacterData> getCharacter() {
        return character;
    }

    private int images;

    public String getJudul() {
        return judul;
    }

    public String getGenre() {
        return genre;
    }

    public String getDeskripsi(){
        return deskripsi;
    }

    public int getImages(){
        return images;
    }

    public AnimeListData(String judul, String genre){
        this.judul = judul;
        this.genre = genre;
    }

    public AnimeListData(String judul, String genre, String deskripsi){
        this.judul = judul;
        this.genre = genre;
        this.deskripsi = deskripsi;
    }

    public AnimeListData(String judul, String genre, String deskripsi, int images){
        this.judul = judul;
        this.genre = genre;
        this.deskripsi = deskripsi;
        this.images = images;
    }

    public AnimeListData(String judul, String genre, String deskripsi, int images, ArrayList<CharacterData> character){
        this.judul = judul;
        this.genre = genre;
        this.deskripsi = deskripsi;
        this.images = images;
        this.character = character;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.judul);
        dest.writeString(this.genre);
        dest.writeString(this.deskripsi);
        dest.writeTypedList(this.character);
        dest.writeInt(this.images);
    }

    protected AnimeListData(Parcel in) {
        this.judul = in.readString();
        this.genre = in.readString();
        this.deskripsi = in.readString();
        this.character = in.createTypedArrayList(CharacterData.CREATOR);
        this.images = in.readInt();
    }

    public static final Parcelable.Creator<AnimeListData> CREATOR = new Parcelable.Creator<AnimeListData>() {
        @Override
        public AnimeListData createFromParcel(Parcel source) {
            return new AnimeListData(source);
        }

        @Override
        public AnimeListData[] newArray(int size) {
            return new AnimeListData[size];
        }
    };
}
