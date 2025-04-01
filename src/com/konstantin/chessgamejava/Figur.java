package com.konstantin.chessgamejava;

import javax.swing.text.Position;

public class Figur {
    protected Position1 position;
    protected FigurFarbe farbe;
    protected char bezeichnung;

    public char getBezeichnung() {
        return bezeichnung;
    }

    public Position1 getPosition() {
        return position;
    }

    public FigurFarbe getFarbe() {
        return farbe;
    }

    public Figur (FigurFarbe farbe, Position1 position){
        this.position=position;
        this.farbe=farbe;
        bezeichnung ='x';
    }
}
