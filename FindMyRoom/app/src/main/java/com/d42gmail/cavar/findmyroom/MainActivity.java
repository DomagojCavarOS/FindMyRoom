package com.d42gmail.cavar.findmyroom;

import android.app.FragmentManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;


public class MainActivity extends AppCompatActivity implements Communicator {

    FragmentA fragA;
    FragmentB fragB;
    FragmentManager fragmentManager;
    Communicator comm1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        boolean isTablet=tabletTest(getApplicationContext());
        if(isTablet==true) {
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
            Log.i("prikaz","tablet sam");
        }
        else
        {
            Log.i("prikaz","mob sam");
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        }

        fragmentManager=getFragmentManager();
        fragA = (FragmentA) fragmentManager.findFragmentById(R.id.fragment);

    }

    @Override
    public void respond(Place place) {

        fragB= (FragmentB) fragmentManager.findFragmentById(R.id.fragment2);

        if(fragB != null && fragB.isVisible())
        {//ako je tablet na landscape-u

            layoutChange();
            comm1=fragB;
            comm1.respond(place);


        }
        else
        {
            Intent intent=new Intent(this,Show.class);
            intent.putExtra("PlaceClass", place);
            Log.i("test", "prosao itent");
            startActivityForResult(intent, 0);

        }


    }

    private void layoutChange() {

        fragB.mainImage.requestLayout();
        fragB.mainImage.getLayoutParams().height=350;
        fragB.imageOne.requestLayout();
        fragB.imageOne.getLayoutParams().height=175;
        fragB.imageOne.getLayoutParams().width=175;
        fragB.imageTwo.requestLayout();
        fragB.imageTwo.getLayoutParams().height=175;
        fragB.imageTwo.getLayoutParams().width=175;
        fragB.imageThree.requestLayout();
        fragB.imageThree.getLayoutParams().height=175;
        fragB.imageThree.getLayoutParams().width=175;

        fragB.mainImage.setClickable(true);
        fragB.imageOne.setClickable(true);
        fragB.imageTwo.setClickable(true);
        fragB.imageThree.setClickable(true);


    }

    public static boolean tabletTest(Context context) {

        return (context.getResources().getConfiguration().screenLayout & Configuration.SCREENLAYOUT_SIZE_MASK) >= Configuration.SCREENLAYOUT_SIZE_LARGE;

    }
}