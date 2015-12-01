package com.d42gmail.cavar.findmyroom;

import android.app.ActionBar;
import android.app.Activity;
import android.app.FragmentManager;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ActionMenuView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class Show extends Activity implements Communicator {
    FragmentB fragB;
    FragmentManager fragmentManager;
    ImageButton back;
    TextView AppBarName;
    Communicator comm2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        back= (ImageButton) findViewById(R.id.app_bar_backButton);
        AppBarName= (TextView) findViewById(R.id.app_bar_Text);

        Place place= new Place();
        Intent intent=getIntent();
        place= (Place) intent.getSerializableExtra("PlaceClass");

        fragmentManager=getFragmentManager();
        fragB= (FragmentB) fragmentManager.findFragmentById(R.id.fragment2);

        AppBarName.setText(""+place.getPlaceName());

        comm2=fragB;
        comm2.respond(place);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }


    @Override
    public void respond(Place place) {

    }
}