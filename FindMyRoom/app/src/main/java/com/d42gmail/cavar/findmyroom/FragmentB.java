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
public class FragmentB extends android.app.Fragment implements Communicator {
    ImageView mainImage;
    ImageButton imageOne, imageTwo, imageThree;
    RatingBar ratingBar;
    TextView Name, Adress, Description;
    Place place=new Place();

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
        drawable.setColorFilter(Color.parseColor("#E58F65"), PorterDuff.Mode.SRC_ATOP);

        mainImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showImage(convertToBitmap(getResources().getDrawable(place.getImageMain()),700,430));
            }
        });

        imageOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showImage(convertToBitmap(getResources().getDrawable(place.getImgOne()),700,430));
            }
        });

        imageTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showImage(convertToBitmap(getResources().getDrawable(place.getImgTwo()),700,430));
            }
        });

        imageThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showImage(convertToBitmap(getResources().getDrawable(place.getImgThree()),700,430));
            }
        });


        return view;
    }



    @Override
    public void respond(final Place place) {

        this.place=place;
        setClicble();
        setContent();

    }

    private void setClicble() {

            mainImage.setClickable(true);
            imageOne.setClickable(true);
            imageTwo.setClickable(true);
            imageThree.setClickable(true);


    }

    private void setContent() {

        mainImage.setImageBitmap(convertToBitmap(getResources().getDrawable(place.getImageMain()), 700, 430));
        imageOne.setImageBitmap(convertToBitmap(getResources().getDrawable(place.getImgOne()), 330, 200));
        imageTwo.setImageBitmap(convertToBitmap(getResources().getDrawable(place.getImgTwo()), 330, 200));
        imageThree.setImageBitmap(convertToBitmap(getResources().getDrawable(place.getImgThree()),330,200));
        Name.setText(place.getPlaceName());
        Description.setText(place.getPlaceDescription());
        Adress.setText(String.format("%s\n%s",place.getPlaceAdress(),place.getPlaceCity()));
        ratingBar.setRating(place.getPlaceRate());

    }

    public void showImage(Bitmap imgdraw) {

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

        imageView.setImageBitmap(imgdraw);

        builder.addContentView(imageView, new RelativeLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT));
        builder.show();
    }

    public Bitmap convertToBitmap(Drawable drawable, int widith, int height) {

        Log.i("tablet", "convertToBitmap");
        Bitmap mutableBitmap = Bitmap.createBitmap(widith, height, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(mutableBitmap);
        drawable.setBounds(0, 0, widith, height);
        drawable.draw(canvas);

        return mutableBitmap;
    }

}