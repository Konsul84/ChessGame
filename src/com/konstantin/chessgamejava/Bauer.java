package com.konstantin.chessgamejava;

public class Bauer extends Figur{
    public Bauer(FigurFarbe farbe, Position1 position,Brett brett) {
        super(farbe, position,brett);
        bezeichnung = farbe == FigurFarbe.BLACK ? 'B' : 'b';

    }



    @Override
    public boolean isValidMove(Position1 newPosition, Figur[][] figurs) {
        if (newPosition.getZeile() < 0 || newPosition.getZeile() > 7 ||
                newPosition.getSpalte() < 0 || newPosition.getSpalte() > 7) {
            return false;
        }
        int direction = farbe ==FigurFarbe.BLACK ?1:-1;
        int zeilenDiff = (newPosition.getZeile()- position.getZeile())*direction;
        int spaltenDiff = newPosition.getSpalte()- position.getSpalte();

        // 1 Feld bewegen
        if((zeilenDiff==1 &&spaltenDiff==0)&&(figurs[newPosition.getZeile()][newPosition.getSpalte()]==null)){
            return isMyKingNotCheck(newPosition,figurs);
        }

        // schräg schlagen
        if(Math.abs(spaltenDiff)==1 && zeilenDiff==1&&figurs[newPosition.getZeile()][newPosition.getSpalte()]!=null
                &&  figurs[newPosition.getZeile()][newPosition.getSpalte()].getFarbe()!=
                        this.getFarbe()){
            return isMyKingNotCheck(newPosition,figurs);
        }

        // ermitteln ob Bauer noch auf seienr Startposition steht
        boolean isStartposition = ((farbe == FigurFarbe.BLACK&& position.getZeile()==1)||(farbe ==FigurFarbe.WHITE&&position.getZeile()==6));

        // Feld was übersprungen werden soll definieren
        int midZeile = position.getZeile()+direction;

        // Prüfen ob Bauer sich 2 Felder bewegen darf
        if(figurs[midZeile][position.getSpalte()]==null){
            if(zeilenDiff==2 &&spaltenDiff==0&& isStartposition&& figurs[newPosition.getZeile()][newPosition.getSpalte()]==null){
                return isMyKingNotCheck(newPosition,figurs);
            }
        }
        return false;
    }
}
