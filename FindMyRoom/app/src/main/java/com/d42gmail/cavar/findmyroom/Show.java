package com.d42gmail.cavar.findmyroom;

import android.app.ActionBar;
import android.app.FragmentManager;
import android.content.pm.ActivityInfo;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ActionMenuView;
import android.widget.ImageView;

public class Show extends AppCompatActivity {
    FragmentB fragB;
    FragmentManager fragmentManager;
    ActionBar actionBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //actionBar.setDisplayHomeAsUpEnabled(true);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);
       // getActionBar().setHomeButtonEnabled(true);
        //getActionBar().setDisplayHomeAsUpEnabled(true);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        Bundle extras = getIntent().getExtras();

            String Name  = extras.getString("PlaceName");
            String Adress  = extras.getString("PlaceAdress");
            String City  = extras.getString("PlaceCity");
            String Description = extras.getString("PlaceDescription");
            int imgMain=extras.getInt("PictureMain");
            int imgOne=extras.getInt("PictureOne");
            int imgTwo=extras.getInt("PictureTwo");
            int imgThree=extras.getInt("PictureThree");
            int rating=extras.getInt("RateBar");


        fragmentManager=getFragmentManager();
        fragB= (FragmentB) fragmentManager.findFragmentById(R.id.fragment2);
        fragB.mainImage.setImageResource(imgMain);
        fragB.imageOne.requestLayout();
        fragB.imageOne.setImageResource(imgOne);
        fragB.imageTwo.setImageResource(imgTwo);
        fragB.imageThree.setImageResource(imgThree);
        fragB.Name.setText("" + Name);
        fragB.Adress.setText(String.format("%s\n%s",Adress,City));
        fragB.Description.setText(""+Description);

        fragB.ratingBar.setRating(rating);

    }

   /* protected Bitmap rescaleBitmap(int imageID, int Width, int Height) {

        // Part 1: Decode image
        Bitmap unscaledBitmap = BitmapFactory.decodeResource(getResources(), imageID);

        // Part 2: Scale image
        Bitmap scaledBitmap = Bitmap
                .createScaledBitmap(unscaledBitmap, Width, Height, true);
        unscaledBitmap.recycle();

        return scaledBitmap;


    }*/
}
