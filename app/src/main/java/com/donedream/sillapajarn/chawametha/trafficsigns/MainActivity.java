package com.donedream.sillapajarn.chawametha.trafficsigns;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
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

        //ListView Controller
        listViewController();

    }   //Main Method [start operation use onCreate always]

    private void listViewController() {

        //setup array
        //for icon
        final int[] iconInts = {R.drawable.traffic_01, R.drawable.traffic_02, R.drawable.traffic_03,
                R.drawable.traffic_04, R.drawable.traffic_05, R.drawable.traffic_06,
                R.drawable.traffic_07, R.drawable.traffic_08, R.drawable.traffic_09,
                R.drawable.traffic_10, R.drawable.traffic_11, R.drawable.traffic_12,
                R.drawable.traffic_13, R.drawable.traffic_14, R.drawable.traffic_15,
                R.drawable.traffic_16, R.drawable.traffic_17, R.drawable.traffic_18,
                R.drawable.traffic_19, R.drawable.traffic_20};
        //for title
        final String[] titleStrings = new String[20]; //จองram for string 20 ตัว
        titleStrings[0] = "หัวข้อที่1";
        titleStrings[1] = "หัวข้อที่2";
        titleStrings[2] = "หัวข้อที่3";
        titleStrings[3] = "หัวข้อที่4";
        titleStrings[4] = "หัวข้อที่5";
        titleStrings[5] = "หัวข้อที่6";
        titleStrings[6] = "หัวข้อที่7";
        titleStrings[7] = "หัวข้อที่8";
        titleStrings[8] = "หัวข้อที่9";
        titleStrings[9] = "หัวข้อที่10";
        titleStrings[10] = "หัวข้อที่11";
        titleStrings[11] = "หัวข้อที่12";
        titleStrings[12] = "หัวข้อที่13";
        titleStrings[13] = "หัวข้อที่14";
        titleStrings[14] = "หัวข้อที่15";
        titleStrings[15] = "หัวข้อที่16";
        titleStrings[16] = "หัวข้อที่17";
        titleStrings[17] = "หัวข้อที่18";
        titleStrings[18] = "หัวข้อที่19";
        titleStrings[19] = "หัวข้อที่20";

        //for detail เอาdataมาจาก my_data.xmlในvalue file
        final String[] detailStrings = getResources().getStringArray(R.array.data_short);

        //create listview
        MyAdapter objMyAdapter = new MyAdapter(MainActivity.this, iconInts, titleStrings, detailStrings);
        trafficListView.setAdapter(objMyAdapter);

        //active when click listview
        trafficListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                //intent detailActivity
                Intent objIntent = new Intent(MainActivity.this, DetailActivity.class);

                //put extra
                objIntent.putExtra("Title", titleStrings[position]);
                objIntent.putExtra("Image", iconInts[position]);
                objIntent.putExtra("Index", position);

                startActivity(objIntent);

                }   //event
        }); //event

    }   //listviewcontroller

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
                startActivity(objIntent);

            }   // event
        });

    }   //buttonController

    private void bindWidget() {
        trafficListView = (ListView) findViewById(R.id.listView); //alt+enter => cast to data type listview
        aboutmeButton = (Button) findViewById(R.id.button);
    }
}   //Main Class
