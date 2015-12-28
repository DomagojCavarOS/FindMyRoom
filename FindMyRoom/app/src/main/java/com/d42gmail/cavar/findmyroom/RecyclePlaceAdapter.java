package com.d42gmail.cavar.findmyroom;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Enigma on 28.12.2015..
 */
public class RecyclePlaceAdapter extends RecyclerView.Adapter <RecyclePlaceAdapter.MyViewHolder>  implements Communicator {
    ArrayList<Place> arrayAdapterList;
    LayoutInflater inflater;
    Context ctx;
    Communicator comm;
    public ImageView image_item;
    public TextView name_item;
    public TextView adress_item;
    public View view;
    Activity activity;
    RecyclerView recyclerView;


    public RecyclePlaceAdapter(Context ctx, ArrayList<Place> arrayAdapterList, RecyclerView recyclerView){

        inflater=LayoutInflater.from(ctx);
        this.arrayAdapterList = arrayAdapterList;
        this.ctx=ctx;
        this.recyclerView=recyclerView;
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        view = inflater.inflate(R.layout.list_item,parent,false);
        view.setOnClickListener(new MyOnClickListener());
        comm= (Communicator) ctx;
        MyViewHolder holder= new MyViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        Boolean isTablet=MainActivity.tabletTest(ctx);
        if(isTablet==true)
        {
            itemLayoutChange(view);
        }

        Place currentPlace=arrayAdapterList.get(position);

        image_item.setImageResource(currentPlace.getImgTbn());
        name_item.setText("" + currentPlace.getPlaceName());
        adress_item.setText(String.format("%s \n %s", currentPlace.getPlaceAdress(), currentPlace.getPlaceCity()));

    }

    @Override
    public int getItemCount() {
        return arrayAdapterList.size();
    }

    @Override
    public void respond(Place place) {

    }

    class MyViewHolder extends  RecyclerView.ViewHolder{

        public MyViewHolder(View itemView) {
            super(itemView);


            image_item= (ImageView) itemView.findViewById(R.id.idImage_item);
            name_item= (TextView) itemView.findViewById(R.id.idName_item);
            adress_item= (TextView) itemView.findViewById(R.id.idDescription_item);
        }
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


    public class MyOnClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            int itemPosition = recyclerView.getChildPosition(v);
            Log.i("vidi", "idemo" + arrayAdapterList.get(itemPosition).getPlaceCity());
            comm.respond(arrayAdapterList.get(itemPosition));

        }
    }
}
