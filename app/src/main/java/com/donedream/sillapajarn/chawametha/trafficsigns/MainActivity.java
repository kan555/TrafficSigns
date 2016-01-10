package com.donedream.sillapajarn.chawametha.trafficsigns;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    //explicit การประกาศตัวแปล
    //access type    name
    private ListView trafficListView;
    private Button aboutmeButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Bind widget ผูกตัวแปลกับ widget ใน
        bindWidget();

        //button controller
        buttonController();

    }   //Main Method [start operation use onCreate always]

    private void buttonController() {

        //class object = new class();
        aboutmeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //sound effect
                MediaPlayer buttomMediaPlayer = MediaPlayer.create(getBaseContext(),
                        R.raw.end_game);
                buttomMediaPlayer.start();

                //intent to actionview ส่งไปหน้าใหม่
                Intent objIntent = new Intent(Intent.ACTION_VIEW); //ถามbrowerไหนtoเปิดweb
                objIntent.setData(Uri.parse("https://youtu.be/plWnm7UpsXk"));
                startActivity (objIntent);

            }   // event
        });

    }   //buttonController

    private void bindWidget() {
        trafficListView = (ListView) findViewById(R.id.listView); //alt+enter => cast to data type listview
        aboutmeButton = (Button) findViewById(R.id.button);
    }
}   //Main Class
