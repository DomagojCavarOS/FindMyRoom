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

public class Show extends Activity {
    FragmentB fragB;
    FragmentManager fragmentManager;
    ImageButton back;
    TextView AppBarName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        back= (ImageButton) findViewById(R.id.app_bar_backButton);
        AppBarName= (TextView) findViewById(R.id.app_bar_Text);

        Log.i("obj","proso");
        Place place= new Place();
        Intent intent=getIntent();
        place= (Place) intent.getSerializableExtra("PlaceClass");

        fragmentManager=getFragmentManager();
        fragB= (FragmentB) fragmentManager.findFragmentById(R.id.fragment2);

        setContent(place);

        setClickable();

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    private void setContent(Place place) {

        fragB.mainImage.setImageResource(place.getImageMain());
        fragB.imageOne.setImageResource(place.getImgOne());
        fragB.imageTwo.setImageResource(place.getImgTwo());
        fragB.imageThree.setImageResource(place.getImgThree());
        fragB.Name.setText("" + place.getPlaceName());
        fragB.Adress.setText(String.format("%s\n%s",place.getPlaceAdress(),place.getPlaceCity()));
        fragB.Description.setText(""+place.getPlaceDescription());
        fragB.ratingBar.setRating(place.getPlaceRate());
    }

    private void setClickable() {
        fragB.mainImage.setClickable(true);
        fragB.imageOne.setClickable(true);
        fragB.imageTwo.setClickable(true);
        fragB.imageThree.setClickable(true);

    }

}
