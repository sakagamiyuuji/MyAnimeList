package com.e.myanimelist;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AlertDialogLayout;
import androidx.fragment.app.FragmentTransaction;

import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ArrayList<AnimeListData> animeList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        generateAnimeList();

        AnimeListFragment animeListFragment = new AnimeListFragment();
        /*AnimeListFragment animeListFragment = AnimeListFragment.newInstance();*/

        animeListFragment.getData(animeList);

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.add(R.id.frame_listview, animeListFragment);

        ft.commit();

    }



    private void generateAnimeList(){
       ArrayList<CharacterData> charSao = new ArrayList<>();
        charSao.add(new CharacterData("Kirigaya Kazuto", R.drawable.kirigaya_kazuto,"gw kirigaya"));
        charSao.add(new CharacterData("Yuuki Asuna", R.drawable.yuuki_asuna, "gw asuna"));
        charSao.add(new CharacterData("Alice Zuberg", R.drawable.alice_zuberg, "gw alice"));
        charSao.add(new CharacterData("Kirigaya Kazuto", R.drawable.kirigaya_kazuto,"gw kirigaya"));
        charSao.add(new CharacterData("Yuuki Asuna", R.drawable.yuuki_asuna, "gw asuna"));
        charSao.add(new CharacterData("Alice Zuberg", R.drawable.alice_zuberg, "gw alice"));
        charSao.add(new CharacterData("Kirigaya Kazuto", R.drawable.kirigaya_kazuto,"gw kirigaya"));
        charSao.add(new CharacterData("Yuuki Asuna", R.drawable.yuuki_asuna, "gw asuna"));
        charSao.add(new CharacterData("Alice Zuberg", R.drawable.alice_zuberg, "gw alice"));
        charSao.add(new CharacterData("Kirigaya Kazuto", R.drawable.kirigaya_kazuto,"gw kirigaya"));
        charSao.add(new CharacterData("Yuuki Asuna", R.drawable.yuuki_asuna, "gw asuna"));
        charSao.add(new CharacterData("Alice Zuberg", R.drawable.alice_zuberg, "gw alice"));
        charSao.add(new CharacterData("Kirigaya Kazuto", R.drawable.kirigaya_kazuto,"gw kirigaya"));
        charSao.add(new CharacterData("Yuuki Asuna", R.drawable.yuuki_asuna, "gw asuna"));
        charSao.add(new CharacterData("Alice Zuberg", R.drawable.alice_zuberg, "gw alice"));
        charSao.add(new CharacterData("Kirigaya Kazuto", R.drawable.kirigaya_kazuto,"gw kirigaya"));
        charSao.add(new CharacterData("Yuuki Asuna", R.drawable.yuuki_asuna, "gw asuna"));
        charSao.add(new CharacterData("Alice Zuberg", R.drawable.alice_zuberg, "gw alice"));

        ArrayList<CharacterData> charIrregular = new ArrayList<>();
        charIrregular.add(new CharacterData("Shiba Miyuki", R.drawable.shiba_miyuki, "gw miyuki"));
        charIrregular.add(new CharacterData("Shiba Tatsuya", R.drawable.shiba_tatsuya, "gw tatsuya"));


        animeList.add(new AnimeListData("Kimetsu No Yaiba", "Action, Demons, Historical, Shounen, Supernatural", getString(R.string.kimetsu_sinopsis), R.drawable.kimetsu, charIrregular));
        animeList.add(new AnimeListData("SAO : War of underworld", "Action, Game, Adventure, Romance, Fantasy", getString(R.string.sao_wou_sinopsis), R.drawable.sao_wou,charSao ));
        animeList.add(new AnimeListData("Boku no Hero Academia 4th", "Action, Comedy, School, Shounen, Super Power", getString(R.string.boku_nohero_sinopsis), R.drawable.boku_no_hero,charSao));
        animeList.add(new AnimeListData("Dr.Stone", "Adventure, Sci-Fi, Shounen",getString(R.string.dr_stone_sinopsis), R.drawable.drstone, charSao));
        animeList.add(new AnimeListData("Vinland Saga" , "Action, Adventure, Drama, Historical, Seinen", getString(R.string.vinland_saga_sinopsis), R.drawable.vinland_saga, charSao));
        animeList.add(new AnimeListData("Enen no Shouboutai", "Action, Supernatural, Shounen", getString(R.string.enen_no_shouboutai), R.drawable.enen_no_shouboutai, charSao));
        animeList.add(new AnimeListData("One Punch Man 2th", "Action, Supernatural, Shounen",getString(R.string.opm2_sinopsis), R.drawable.opm4, charSao));
        animeList.add(new AnimeListData("Attack on Titan 3th Part 2", "Action, Drama, Fantasy, Military, Mystery, Shounen, Super Power", getString(R.string.aot4_sinops), R.drawable.aot4, charSao));
        animeList.add(new AnimeListData("Tate no Yuusha", "Action, Adventure, Drama, Fantasy", getString(R.string.tate_sinopsis), R.drawable.tate_no_yuusha, charSao));
        animeList.add(new AnimeListData("Yakusoku no Neverland", "Sci-Fi, Mystery, Horror, Psychological, Thriller, Shounen", getString(R.string.yakusoku_no_neverlend_sinopsis),R.drawable.yakusoku_no_neverland, charSao));
    }

    public boolean doubleTapParam = false;

    @Override
    public void onBackPressed() {
        if(doubleTapParam){
            AlertDialog.Builder alert = new AlertDialog.Builder(this);
            alert.setTitle("KELUAR");
            alert.setMessage("Are you sure?");
            alert.setCancelable(true);
            alert.setNegativeButton("NO", null);
            alert.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    finish();
                }
            });

            alert.create().show();
        }
        else{
            this.doubleTapParam = true;
            Toast toast = new Toast(getApplicationContext());
            View view = LayoutInflater.from(this).inflate(R.layout.toast_layout, null);
            TextView tvToast = view.findViewById(R.id.tv_toast);
            tvToast.setText("TEKAN SEKALI LAGI COKKKK!!!");
            toast.setView(view);
            toast.setDuration(Toast.LENGTH_SHORT);
            toast.show();
            //Toast.makeText(this, "Tap sekali lagi untuk keluar", Toast.LENGTH_SHORT).show();
        }

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                doubleTapParam = false;
            }
        }, 2000 );
    }
}