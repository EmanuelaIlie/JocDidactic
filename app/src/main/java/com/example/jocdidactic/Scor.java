package com.example.jocdidactic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

public class Scor extends AppCompatActivity {

    ImageView imageViewBG;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scor);

        String punctaj="animale";
        punctaj+=getIntent().getStringExtra("punctaj");

        Log.d("EMA",punctaj);

        imageViewBG=findViewById(R.id.imageViewBG);
        Resources res = getResources();
        int resIDIntr = res.getIdentifier(punctaj, "drawable", getPackageName());
        imageViewBG.setImageResource(resIDIntr);
    }
}