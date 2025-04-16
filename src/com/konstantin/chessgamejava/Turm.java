package com.konstantin.chessgamejava;

import javax.swing.text.Position;

public class Turm extends Figur{
    public Turm(FigurFarbe farbe,Position1 position,Brett brett) {
        super(farbe,position,brett);
        bezeichnung = farbe == FigurFarbe.BLACK ? 'T' : 't';

    }

    @Override
    public boolean isValidMove(Position1 newPosition, Figur[][] figurs) {
        if (newPosition.getZeile() < 0 || newPosition.getZeile() > 7 ||
                newPosition.getSpalte() < 0 || newPosition.getSpalte() > 7) {
            return false;
        }

        if(position.getSpalte()== newPosition.getSpalte()){
            Figur figur =figurs[newPosition.getZeile()][newPosition.getSpalte()];
            if(figur==null||figur.getFarbe()!=this.getFarbe()){
                int zeileMax=Math.max(position.getZeile(), newPosition.getZeile());
                int zeileMin=Math.min(position.getZeile(), newPosition.getZeile());
                for (int i = zeileMin+1; i <zeileMax ; i++) {
                    if(figurs[i][position.getSpalte()]!=null){
                        return false;
                    }
                }
                return isMyKingNotCheck(newPosition,figurs);
            }

        }

        if(position.getZeile()==newPosition.getZeile()){
            Figur figur =figurs[newPosition.getZeile()][newPosition.getSpalte()];
            if(figur==null||figur.getFarbe()!=this.getFarbe()){
                int spalteMax =Math.max(position.getSpalte(), newPosition.getSpalte());
                int spalteMin =Math.min(position.getSpalte(), newPosition.getSpalte());
                for (int i = spalteMin+1; i <spalteMax ; ++i) {
                    if(figurs[position.getZeile()][i]!=null){
                        return false;
                    }
                }
                return true;
            }


        }

        return false;
    }
}
