package com.d42gmail.cavar.findmyroom;

import android.app.ActionBar;
import android.app.Activity;
import android.app.FragmentManager;
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
            Log.i("rating", "Rating portret show: " + rating);


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

        setClickable();


        AppBarName.setText(""+Name);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    private void setClickable() {
        fragB.mainImage.setClickable(true);
        fragB.imageOne.setClickable(true);
        fragB.imageTwo.setClickable(true);
        fragB.imageThree.setClickable(true);

    }

}
