package com.d42gmail.cavar.findmyroom;

import android.app.Fragment;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by Enigma on 27.11.2015..
 */
public class FragmentA extends Fragment {

    RecyclerView recyclerView;
    ArrayList<Place> arrayPlaces=new ArrayList<Place>();
    RecyclePlaceAdapter adapter;
    Communicator comm;
    String[] PlaceArray;
    String[] AdresArray;
    String[] DescriptionArray;
    String[] CityArray;
    int[] RateArray;
    TypedArray PicturesArrayMain,PicturesArrayOne,PicturesArrayTwo,PicturesArrayThree,TumbnailArray;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view= inflater.inflate(R.layout.fragmenta,container,false);

        recyclerView= (RecyclerView) view.findViewById(R.id.RecyclePlaceAdapter);
        adapter=new RecyclePlaceAdapter(getActivity(),Populate(arrayPlaces),recyclerView);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        return view;
    }

    private ArrayList<Place> Populate(ArrayList<Place> arrayPlace) {

        PlaceArray=getResources().getStringArray(R.array.place);
        AdresArray=getResources().getStringArray(R.array.adress);
        CityArray=getResources().getStringArray(R.array.city);
        DescriptionArray=getResources().getStringArray(R.array.description);
        RateArray=getResources().getIntArray(R.array.rate);
        PicturesArrayMain=getResources().obtainTypedArray(R.array.picturesMain);
        PicturesArrayOne=getResources().obtainTypedArray(R.array.picturesOne);
        PicturesArrayTwo=getResources().obtainTypedArray(R.array.picturesTwo);
        PicturesArrayThree=getResources().obtainTypedArray(R.array.picturesThree);
        TumbnailArray=getResources().obtainTypedArray(R.array.pictureTumbnail);

        for(int i=0;i<=5;i++){

            Place place1=new Place();
            place1.setPlaceName(PlaceArray[i]);
            place1.setPlaceAdress(AdresArray[i]);
            place1.setPlaceCity(CityArray[i]);
            place1.setPlaceDescription(DescriptionArray[i]);
            place1.setPlaceRate(RateArray[i]);

            place1.setImageMain(PicturesArrayMain.getResourceId(i, 0));
            place1.setImgOne(PicturesArrayOne.getResourceId(i, 0));
            place1.setImgTwo(PicturesArrayTwo.getResourceId(i, 0));
            place1.setImgThree(PicturesArrayThree.getResourceId(i, 0));
            place1.setImgTbn(TumbnailArray.getResourceId(i, 0));

            arrayPlace.add(place1);
        }
        return arrayPlace;
    }
}