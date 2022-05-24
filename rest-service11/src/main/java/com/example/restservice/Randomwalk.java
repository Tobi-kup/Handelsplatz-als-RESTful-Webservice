package com.example.restservice;
import static java.lang.Math.*;

public class Randomwalk {

    double kurs = 5.0*(2* Math.random() - 1.0);                  //startwert
    double tendenz = 0.3*(2* Math.random() - 1.0);               //Tendenz des Handelswerts
    double dt = 0.001;                                           //zeitschritt
    double streuung = 0.8;                                       //standart abweichung
    double y = 0;                                                //random number

    public double Rwalk(){
        double sqdt = sqrt(dt);
        double y = 2* Math.random() - 1.0;
        kurs = kurs * (1 + tendenz * dt + streuung * sqdt * y);
        return kurs;
    }

    public void walkgenerate(){
        for(int i=0; i<1000; i++){
            System.out.println(Rwalk());
        }
    }
}
