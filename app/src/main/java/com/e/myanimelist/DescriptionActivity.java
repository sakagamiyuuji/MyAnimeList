package com.e.myanimelist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class DescriptionActivity extends AppCompatActivity {
    TextView titleDes, contentDes;
    ImageView imageView;
    Button btnChar;
    AnimeListData animeListData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);

        titleDes = findViewById(R.id.tv_title_des);
        contentDes = findViewById(R.id.tv_content_des);
        imageView = findViewById(R.id.image_content);
        btnChar = findViewById(R.id.btn_character);

        animeListData = getIntent().getParcelableExtra("anime_content");
        titleDes.setText(animeListData.getJudul());
        contentDes.setText(animeListData.getDeskripsi());
        imageView.setImageResource(animeListData.getImages());

        btnCharacter();

    }

    public void btnCharacter(){
        btnChar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), CharacterActivity.class);
                intent.putParcelableArrayListExtra("char", animeListData.getCharacter());
                startActivity(intent);
                //Toast.makeText(getApplicationContext(), "Character in Progress", Toast.LENGTH_SHORT).show();
                Toast.makeText(getApplicationContext(), animeListData.getCharacter().get(0).getNama(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
