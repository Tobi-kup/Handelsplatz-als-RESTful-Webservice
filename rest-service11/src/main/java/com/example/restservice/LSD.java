package com.example.restservice;

import java.io.Serializable;

public class LSD implements Serializable{

    private int menge;


    public LSD(){}

    public void setMenge(int menge){
        this.menge = menge;
    }

    public int getMenge(){
        return menge;
    }

}
