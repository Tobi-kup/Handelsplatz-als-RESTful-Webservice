package com.example.restservice;

import java.io.Serializable;

public class Rapsoel implements Serializable{

    private int menge;
    private int preis;

    public Rapsoel(){}

    public void setMenge(int menge){
        this.menge = menge;
    }

    public int getMenge(){
        return menge;
    }


    public void setPreis(int preis){
        this.preis = preis;
    }

    public int getPreis(){
        return preis;
    }

}
