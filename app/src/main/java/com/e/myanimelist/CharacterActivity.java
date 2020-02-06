package com.e.myanimelist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.google.android.material.appbar.CollapsingToolbarLayout;

import java.util.ArrayList;
import java.util.List;

public class CharacterActivity extends AppCompatActivity {

    List<CharacterData> charSao, charIrregular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character);


        charGenerate();

    }

    public void charGenerate(){

        Intent intent = getIntent();
        ArrayList<CharacterData> characterData = intent.getParcelableArrayListExtra("char");

        if(characterData != null){

            RecyclerView rvChar = findViewById(R.id.rv_character);
            RvCharAdapter myAdapter = new RvCharAdapter(this, characterData);
            rvChar.setLayoutManager(new GridLayoutManager(this, 3));
            rvChar.setAdapter(myAdapter);
        }
        else{

            Toast.makeText(this, "Kosong", Toast.LENGTH_SHORT).show();
        }



    }
}
