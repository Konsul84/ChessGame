package com.konstantin.chessgamejava;

public class Bauer extends Figur{
    public Bauer(FigurFarbe farbe, Position1 position) {
        super(farbe, position);
        bezeichnung ='b';

    }

    @Override
    public char getBezeichnung() {
        return bezeichnung;
    }
}
