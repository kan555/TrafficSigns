package com.donedream.sillapajarn.chawametha.trafficsigns;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SlashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slash_screen);

        //sound effect
        MediaPlayer introMediaPlayer = MediaPlayer.create(getBaseContext(), R.raw.end_game);
        introMediaPlayer.start();

        //auto run
        final Handler objHandler = new Handler();
        objHandler.postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent objIntent = new Intent(SlashScreen.this, MainActivity.class);
                startActivity(objIntent);
                finish();

            } //event
        }, 8000);

    }   //main method
}   //main class
