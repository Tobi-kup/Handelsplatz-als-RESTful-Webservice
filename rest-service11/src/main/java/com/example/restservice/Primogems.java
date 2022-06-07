package com.example.restservice;

import java.io.Serializable;

public class Primogems implements Serializable{

    private double menge;


    public Primogems(double menge){ this.menge = menge; }


    public void setMenge(int menge){
        this.menge = menge;
    }

    public double getMenge(){ return menge; }

    public void erhoehe(double i){ menge += i; }

    public void vermindere (double i){ menge -= i; }

}
