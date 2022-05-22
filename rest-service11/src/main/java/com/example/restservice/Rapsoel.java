package com.example.restservice;

import java.io.Serializable;

public class Rapsoel implements Serializable{

    private int menge;


    public Rapsoel(){}

    public void setMenge(int menge){
        this.menge = menge;
    }

    public int getMenge(){
        return menge;
    }

}
