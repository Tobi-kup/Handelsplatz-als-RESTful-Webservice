package com.example.restservice;

public class User {

    private String name;
    private String password;
    Primogems coins = new Primogems(1000);

    private int CSGO_Case_Keys = 0;
    private int Discord_Nitro = 0;
    private int Grafikkarten = 0;
    private int LSD = 0;
    private int NFTs = 0;
    private int Nieren = 0;
    private int Rapsoel = 0;
    private int Reddit_Karma = 0;
    private int Toilettenpapier = 0;
    private int Valorant_Points = 0;


    public User(String name, String password){
        this.name = name;
        this.password = password;
    }


    public String getName(){ return name; }

    public String getPassword(){ return password; }

    public double getCoins(){ return coins.getMenge(); }

    public int getCSGO_Case_Keys(){ return CSGO_Case_Keys; }

    public int getDiscord_Nitro(){ return Discord_Nitro; }

    public int getGrafikkarten(){ return Grafikkarten; }

    public int getLSD(){ return LSD; }

    public int getNFTs(){ return NFTs; }

    public int getNieren(){ return Nieren; }

    public int getRapsoel(){ return Rapsoel; }

    public int getReddit_Karma(){ return Reddit_Karma; }

    public int getToilettenpapier(){ return Toilettenpapier; }

    public int getValorant_Points(){ return Valorant_Points; }



    public void vermindereCoins(double i) { coins.vermindere(i); }

    public void verkaufeCSGO_Case_Keys(int i){ CSGO_Case_Keys -=i; }

    public void verkaufeDiscord_Nitro(int i){
        Discord_Nitro -= i;
    }

    public void verkaufeGrafikkarten(int i){
        Grafikkarten -=i;
    }

    public void verkaufeLSD(int i){
        LSD -=i;
    }

    public void verkaufeNFTs(int i){
        NFTs -=i;
    }

    public void verkaufeNieren(int i){
        Nieren -=i;
    }

    public void verkaufeRapsoel(int i){
        Rapsoel -=i;
    }

    public void verkaufeReddit_Karma(int i){
        Reddit_Karma -=i;
    }

    public void verkaufeToilettenpapier(int i){
        Toilettenpapier -=i;
    }

    public void verkaufeValorant_Points(int i){
        Valorant_Points -=i;
    }



    public void erhoeheCoins(double i) { coins.erhoehe(i); }

    public void kaufeCSGO_Case_Keys(int i){ CSGO_Case_Keys +=i; }

    public void kaufeDiscord_Nitro(int i){
        Discord_Nitro +=i;
    }

    public void kaufeGrafikkarten(int i){
        Grafikkarten +=i;
    }

    public void kaufeLSD(int i){
        LSD +=i;
    }

    public void kaufeNFTs(int i){
        NFTs +=i;
    }

    public void kaufeNieren(int i){
        Nieren +=i;
    }

    public void kaufeRapsoel(int i){
        Rapsoel +=i;
    }

    public void kaufeReddit_Karma(int i){
        Reddit_Karma +=i;
    }

    public void kaufeToilettenpapier(int i){ Toilettenpapier +=i; }

    public void kaufeValorant_Points(int i){
        Valorant_Points +=i;
    }



    public void abheben(double value) { vermindereCoins(value); }

    public void einzahlen(double value) { erhoeheCoins(value); }

}
