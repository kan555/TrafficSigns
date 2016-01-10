package com.donedream.sillapajarn.chawametha.trafficsigns;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    //explicit
    private TextView titleTextView, detailTextView;
    private ImageView trafficImageView;
    private Object view;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        //bind widget
        bindWidget();

        //show view
        showView();

        //show detail
        int intIndex = getIntent().getIntExtra("Index", 0);
        String[] detailStrings = getResources().getStringArray(R.array.detail_long);
        detailTextView.setText(detailStrings[intIndex]);

    }   //main method

    private void showView() {

        //show title
        String strTitle = getIntent().getStringExtra("Title");
        titleTextView.setText(strTitle);

        //show image
        int intIcon = getIntent().getIntExtra("Image", R.drawable.traffic_01);
        trafficImageView.setImageResource(intIcon);

    }   //showview

    private void bindWidget() {
        titleTextView = (TextView) findViewById(R.id.txtShowTitle);
        detailTextView = (TextView) findViewById(R.id.txtShowDetail);
        trafficImageView = (ImageView) findViewById(R.id.imvShowImage);
    }



}   //main class
