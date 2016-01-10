package com.donedream.sillapajarn.chawametha.trafficsigns;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by WINDOWS7 on 10/1/2559.
 */
//adapter ที่จะเอาข้อมูลไปใส่ในlistview
public class MyAdapter extends BaseAdapter{ //for extends have to alt+enter create the require methods

    //explicit ประกาศตัวแปล
    private Context objContext; //ส่งต่อข้อมมูลให้class or db
    private int[] iconInts; //for imv
    private String[] titleStrings, detailStrings; //for title and detail

    //create constructor (main method) by alt+insert > create constructor > select all values
    public MyAdapter(Context objContext, int[] iconInts, String[] titleStrings, String[] detailStrings) {
        this.objContext = objContext;
        this.iconInts = iconInts;
        this.titleStrings = titleStrings;
        this.detailStrings = detailStrings;
    }   //Constructor

    @Override
    public int getCount() {
        return titleStrings.length; //create listview = titles created
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        //open service ขออนุญาติใช้บริการ กล้อง gps layoutinflater
        LayoutInflater objLayoutInflater = (LayoutInflater) objContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);// cast to Alt+enter
        View objView = objLayoutInflater.inflate(R.layout.traffic_listview, parent, false);//เอาข้อมูลไปshow

        //show icon
        ImageView iconImageView = (ImageView) objView.findViewById(R.id.imvIcon);
        iconImageView.setImageResource(iconInts[position]);

        //show title
        TextView titleTextView = (TextView) objView.findViewById(R.id.txtListTitle);
        titleTextView.setText(titleStrings[position]);

        //show detail
        TextView detailTextView = (TextView) objView.findViewById(R.id.txtListDetail);
        detailTextView.setText(detailStrings[position]);

        return objView;
    }
}   //main class
