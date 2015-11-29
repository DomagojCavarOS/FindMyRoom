package com.d42gmail.cavar.findmyroom;

import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.DragEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by Enigma on 27.11.2015..
 */
public class FragmentB extends android.app.Fragment {
    ImageView mainImage;
    ImageButton imageOne, imageTwo, imageThree;
    RatingBar ratingBar;
    TextView Name, Adress, Description;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragmentb, container, false);

        mainImage = (ImageView) view.findViewById(R.id.idImageMain);
        imageOne = (ImageButton) view.findViewById(R.id.idImageOne);
        imageTwo = (ImageButton) view.findViewById(R.id.idImageTwo);
        imageThree = (ImageButton) view.findViewById(R.id.idImageThree);
        ratingBar = (RatingBar) view.findViewById(R.id.ratingBar);
        Name = (TextView) view.findViewById(R.id.idName);
        Adress = (TextView) view.findViewById(R.id.idAdress);
        Description = (TextView) view.findViewById(R.id.idDescription);
        Drawable drawable = ratingBar.getProgressDrawable();
        final Boolean isTablet=MainActivity.tabletTest(getActivity());
        Log.i("tablet","jesam li tablet? "+MainActivity.tabletTest(getActivity()));

        drawable.setColorFilter(Color.parseColor("#E58F65"), PorterDuff.Mode.SRC_ATOP);


        Description.setOnDragListener(new View.OnDragListener() {
            @Override
            public boolean onDrag(View v, DragEvent event) {
                Description.setMovementMethod(new ScrollingMovementMethod());
                return false;
            }
        });

        mainImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isTablet==true) {
                    showImage(convertToBitmap(mainImage.getDrawable()),mainImage.getDrawable(),true);
                    Log.i("tablet", "da");
                }
                else
                {
                    showImage(null,mainImage.getDrawable(),false);
                    Log.i("tablet","ne");
                }

            }
        });

        imageOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isTablet==true) {
                    Drawable imgdraw1=imageOne.getDrawable();
                    showImage(convertToBitmap(imgdraw1), imageOne.getDrawable(), true);
                }
                else
                {

                    showImage(null, imageOne.getDrawable(), false);
                }
            }
        });
        imageTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isTablet==true) {
                    showImage(convertToBitmap(imageTwo.getDrawable()), imageTwo.getDrawable(), true);
                }
                else
                {
                    showImage(null, imageTwo.getDrawable(), false);
                }
            }
        });
        imageThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isTablet==true) {
                    showImage(convertToBitmap(imageThree.getDrawable()), imageThree.getDrawable(), true);
                }
                else
                {
                    showImage(null, imageThree.getDrawable(), false);
                }
            }
        });

        return view;
    }
    public void showImage(Bitmap img,Drawable imgdraw,boolean tablet) {

        Dialog builder = new Dialog(getActivity());
        builder.requestWindowFeature(Window.FEATURE_NO_TITLE);
        builder.getWindow().setBackgroundDrawable(
                new ColorDrawable(android.graphics.Color.TRANSPARENT));
        builder.setOnDismissListener(new DialogInterface.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialogInterface) {
                //nothing;
            }
        });

        ImageView imageView = new ImageView(getActivity());

        if(tablet==true)
        {
            imageView.setImageBitmap(img);
        }
        else
        {
            imageView.setImageDrawable(imgdraw);
        }
        builder.addContentView(imageView, new RelativeLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT));
        builder.show();
    }


    public Bitmap convertToBitmap(Drawable drawable) {

        Log.i("tablet","convertToBitmap");
        Bitmap mutableBitmap = Bitmap.createBitmap(640, 420, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(mutableBitmap);
        drawable.setBounds(0, 0, 640, 420);
        drawable.draw(canvas);

        return mutableBitmap;
    }

}
