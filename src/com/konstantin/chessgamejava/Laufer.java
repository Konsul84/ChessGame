package com.konstantin.chessgamejava;

import javax.swing.text.Position;

public class Laufer extends Figur{
    public Laufer(FigurFarbe farbe,Position1 position,Brett brett) {
        super(farbe,position,brett);
        bezeichnung = farbe == FigurFarbe.BLACK ? 'L' : 'l';
    }

    @Override
    public boolean isValidMove(Position1 newPosition, Figur[][] figurs) {
        int zeilenDiff = Math.abs(newPosition.getZeile()- position.getZeile());
        int spaltenDiff =Math.abs(newPosition.getSpalte()- position.getSpalte());
        
        if(zeilenDiff!=spaltenDiff){
            return false;
        }
        Figur zielFigur =figurs[newPosition.getZeile()][newPosition.getSpalte()];
        if (zielFigur ==null || zielFigur.getFarbe()!=this.getFarbe()){
            int zeilenDiffFactor = newPosition.getZeile()-position.getZeile() >0 ? 1:-1;
            int spaltenDiffFactor = newPosition.getSpalte()- position.getSpalte()>0 ? 1:-1;
            for (int i = 1; i <zeilenDiff ; i++) {
                if(figurs[position.getZeile()+i*zeilenDiffFactor][position.getSpalte()+i*spaltenDiffFactor]!=null){
                    return false;
                }

            }
            return isMyKingNotCheck(newPosition,figurs);
        }
        return false;
    }
}
