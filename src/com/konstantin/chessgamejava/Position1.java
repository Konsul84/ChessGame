package com.konstantin.chessgamejava;

public class Position1 {
    private int zeile;
    private int spalte;
    public Position1(int zeile, int spalte){
        this.zeile=zeile;
        this.spalte=spalte;
    }
    public int getZeile(){
        return  zeile;

    }
    public int getSpalte(){
        return spalte;
    }
}
