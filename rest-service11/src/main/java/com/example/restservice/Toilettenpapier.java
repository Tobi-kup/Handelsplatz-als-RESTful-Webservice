package com.example.restservice;

import java.io.Serializable;

public class Toilettenpapier implements Serializable{

    private int menge;


    public Toilettenpapier(){}

    public void setMenge(int menge){
        this.menge = menge;
    }

    public int getMenge(){
        return menge;
    }

}
