package com.e.myanimelist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class AnimeListAdapter extends ArrayAdapter<AnimeListData> {
    private Context context;
    private ArrayList<AnimeListData> animeList;


    public AnimeListAdapter(Context context, ArrayList<AnimeListData> animeList){
        super(context, 0, animeList);
        this.context = context;
        this.animeList = animeList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null){
            convertView = LayoutInflater.from(context).
                    inflate(R.layout.design_listanime, parent, false);
        }

        AnimeListData currentItem = animeList.get(position);
        TextView nama= convertView.findViewById(R.id.tv_title);
        TextView genre= convertView.findViewById(R.id.tv_genre);
        ImageView thumbImg = convertView.findViewById(R.id.thumbImg);

        nama.setText(currentItem.getJudul());
        genre.setText(currentItem.getGenre());
        thumbImg.setImageResource(currentItem.getImages());


        return convertView;
    }

    @Nullable
    @Override
    public AnimeListData getItem(int position) {
        AnimeListData animeListData = animeList.get(position);
        return animeListData;
    }
}