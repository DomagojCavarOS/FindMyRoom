package com.d42gmail.cavar.findmyroom;

import android.content.res.TypedArray;

/**
 * Created by Enigma on 27.11.2015..
 */
public class Place {

    int imageMain,imgOne, imgTwo,imgThree,placeRate;
    String placeName,placeAdress,placeDescription,placeCity;

    public Place(int imageMain, int imgOne, int imgTwo, int imgThree,int placeRate, String placeName,String placeCity, String placeAdress, String placeDescription) {
        this.imageMain = imageMain;
        this.imgOne = imgOne;
        this.imgTwo = imgTwo;
        this.imgThree = imgThree;
        this.placeRate=placeRate;
        this.placeName = placeName;
        this.placeCity=placeCity;
        this.placeAdress = placeAdress;
        this.placeDescription = placeDescription;
    }
    public Place()
    {

    }


    public int getImageMain() {
        return imageMain;
    }

    public int getPlaceRate() {
        return placeRate;
    }

    public void setPlaceRate(int placeRate) {
        this.placeRate = placeRate;
    }

    public void setImageMain(int imageMain) {

        this.imageMain = imageMain;
    }

    public int getImgOne() {
        return imgOne;
    }

    public String getPlaceCity() {
        return placeCity;
    }

    public void setPlaceCity(String placeCity) {
        this.placeCity = placeCity;
    }

    public void setImgOne(int imgOne) {
        this.imgOne = imgOne;
    }

    public int getImgTwo() {
        return imgTwo;
    }

    public void setImgTwo(int imgTwo) {
        this.imgTwo = imgTwo;
    }

    public int getImgThree() {
        return imgThree;
    }

    public void setImgThree(int imgThree) {
        this.imgThree = imgThree;
    }

    public String getPlaceName() {
        return placeName;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }

    public String getPlaceAdress() {
        return placeAdress;
    }

    public void setPlaceAdress(String placeAdress) {
        this.placeAdress = placeAdress;
    }

    public String getPlaceDescription() {
        return placeDescription;
    }

    public void setPlaceDescription(String placeDescription) {
        this.placeDescription = placeDescription;
    }
}
