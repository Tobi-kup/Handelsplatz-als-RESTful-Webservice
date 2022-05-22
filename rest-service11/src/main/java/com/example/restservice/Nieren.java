package com.example.restservice;

import java.io.Serializable;

public class Nieren implements Serializable{
    
    private int menge;
    
    
    public Nieren(){}
    
    public void setMenge(int menge){
        this.menge = menge;
    }
    
    public int getMenge(){
        return menge;
    }
    
}
