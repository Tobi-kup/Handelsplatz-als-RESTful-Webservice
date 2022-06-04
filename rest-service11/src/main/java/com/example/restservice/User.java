package com.example.restservice;

public class User {

    private String name;
    private String password;

    private int CSGO_Case_Key = 0;
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

    public void verkaufeCSGO_Case_Key(){
        CSGO_Case_Key -=1;
    }

    public void verkaufeDiscord_Nitro(){
        Discord_Nitro -=1;
    }

    public void verkaufeGrafikkarten(){
        Grafikkarten -=1;
    }

    public void verkaufeLSD(){
        LSD -=1;
    }

    public void verkaufeNFTs(){
        NFTs -=1;
    }

    public void verkaufeNieren(){
        Nieren -=1;
    }

    public void verkaufeRapsoel(){
        Rapsoel -=1;
    }

    public void verkaufeReddit_Karma(){
        Reddit_Karma -=1;
    }

    public void verkaufeToilettenpapier(){
        Toilettenpapier -=1;
    }

    public void verkaufeValorant_Points(){
        Valorant_Points -=1;
    }


    public void kaufeCSGO_Case_Key(){
        CSGO_Case_Key +=1;
    }

    public void kaufeDiscord_Nitro(){
        Discord_Nitro +=1;
    }

    public void kaufeGrafikkarten(){
        Grafikkarten +=1;
    }

    public void kaufeLSD(){
        LSD +=1;
    }

    public void kaufeNFTs(){
        NFTs +=1;
    }

    public void kaufeNieren(){
        Nieren +=1;
    }

    public void kaufeRapsoel(){
        Rapsoel +=1;
    }

    public void kaufeReddit_Karma(){
        Reddit_Karma +=1;
    }

    public void kaufeToilettenpapier(){
        Toilettenpapier +=1;
    }

    public void kaufeValorant_Points(){
        Valorant_Points +=1;
    }

}
