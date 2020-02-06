package com.e.myanimelist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;

import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.appbar.CollapsingToolbarLayout;

public class CharacterDeskripsiActivity extends AppCompatActivity {

    ImageView charImg;
    TextView tvCharTitle, tvCharDes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character_deskripsi);

        Toolbar toolbar = findViewById(R.id.toolbarChar);
        setSupportActionBar(toolbar);

        CollapsingToolbarLayout collapsingToolbarLayout = findViewById(R.id.colapsingtoolbar);
        collapsingToolbarLayout.setExpandedTitleColor(ContextCompat.getColor(this, R.color.putih));
        collapsingToolbarLayout.setCollapsedTitleTextColor(ContextCompat.getColor(this, R.color.colorPrimaryDark));

        charImg = findViewById(R.id.img_char_des);
        tvCharTitle = findViewById(R.id.tv_char_name);
        tvCharDes = findViewById(R.id.tv_char_des);

        CharacterData data = getIntent().getParcelableExtra("obj");
        charImg.setImageResource(data.getImages());
        tvCharTitle.setText(data.getNama());
        tvCharDes.setText(data.getDeskripsi());


    }
}
