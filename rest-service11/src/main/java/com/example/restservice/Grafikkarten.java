package com.example.restservice;

import java.io.Serializable;

public class Grafikkarten implements Serializable{

    private int menge;


    public Grafikkarten(){}

    public void setMenge(int menge){
        this.menge = menge;
    }

    public int getMenge(){
        return menge;
    }

}
