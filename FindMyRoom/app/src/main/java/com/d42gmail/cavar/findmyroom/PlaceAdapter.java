package com.d42gmail.cavar.findmyroom;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v4.app.Fragment;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Enigma on 27.11.2015..
 */
public class PlaceAdapter extends BaseAdapter {
    Context ctx;
    ArrayList<Place> arrayAdapterList;
    ImageView image_item;
    TextView  name_item;
    TextView  adress_item;

    public PlaceAdapter(Context ctx, ArrayList<Place> arrayAdapterList) {
        this.ctx = ctx;
        this.arrayAdapterList = arrayAdapterList;

    }

    @Override
    public int getCount() {
        return arrayAdapterList.size();
    }

    @Override
    public Place getItem(int position) {
        return arrayAdapterList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView==null)
        {
           convertView=View.inflate(ctx,R.layout.list_item,null);
        }

        image_item= (ImageView) convertView.findViewById(R.id.idImage_item);
        name_item= (TextView) convertView.findViewById(R.id.idName_item);
        adress_item= (TextView) convertView.findViewById(R.id.idDescription_item);

        Boolean isTablet=MainActivity.tabletTest(ctx);
        if(isTablet==true)
        {
        itemLayoutChange(convertView);
        }

        Place currentPlace=arrayAdapterList.get(position);

        image_item.setImageResource(currentPlace.getImgTbn());
        name_item.setText("" + currentPlace.getPlaceName());
        adress_item.setText(String.format("%s \n %s",currentPlace.getPlaceAdress(),currentPlace.getPlaceCity()));


        return convertView;
    }

    private void itemLayoutChange(View convertView) {
        image_item.requestLayout();
        image_item.getLayoutParams().height=120;
        image_item.getLayoutParams().width=120;

        convertView.setPadding(10,10,10,10);

        name_item.requestLayout();
        name_item.setTextSize(25);
        adress_item.setTextSize(20);

    }

}
