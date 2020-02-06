package com.e.myanimelist;


import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class AnimeListFragment extends Fragment {
    private ArrayList<AnimeListData> dataSet;
    private ListView listView;
    AnimeListAdapter adapter;

    public AnimeListFragment() {
        // Required empty public constructor
    }

/*    public static AnimeListFragment newInstance(ArrayList<AnimeListData> data){
        AnimeListFragment animeListFragment = new An
        this.dataSet = data;
        return new AnimeListFragment();
    }*/

//    public AnimeListFragment newInstance(ArrayList<AnimeListData> dataSett){
//        AnimeListFragment animeListFragment = new AnimeListFragment();
//        dataSet = dataSett;
//        return animeListFragment;
//    }

    public void getData(ArrayList<AnimeListData> data){
        this.dataSet = data;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_anime_list, container, false);
        adapter = new AnimeListAdapter(getActivity(), dataSet);

        listView = rootView.findViewById(R.id.anime_listview);
        listView.setAdapter(adapter);
        onClickLV();
        return rootView;
    }

    public void onClickLV(){
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getActivity(), DescriptionActivity.class);
                intent.putExtra("anime_content", adapter.getItem(position));
                startActivity(intent);

            }
        });
    }

}
