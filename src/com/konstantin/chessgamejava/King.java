package com.konstantin.chessgamejava;

public class King extends Figur{
    public King(FigurFarbe farbe,Position1 position,Brett brett) {
        super(farbe,position,brett);
        bezeichnung = farbe == FigurFarbe.BLACK ? 'K' : 'k';
    }

    @Override
    public boolean isValidMove(Position1 newPosition, Figur[][] figurs) {
        Figur figur = figurs[newPosition.getZeile()][newPosition.getSpalte()];
        if(figur==null || figur.getFarbe()!=this.getFarbe()){
            int zeilenDiff = newPosition.getZeile()- position.getZeile();
            int spaltenDiff = newPosition.getSpalte()- position.getSpalte();
            if((Math.abs(zeilenDiff)==1||Math.abs(zeilenDiff)==0) &&
                    (Math.abs(spaltenDiff)==1||Math.abs(spaltenDiff)==0)){
                return isPositionSafe(newPosition,figurs);
            }
        }
        return false;
    }
// Prüft ob König nach bewegung im Schach steht

    public boolean isPositionSafe(Position1 newPosition, Figur[][]figurs) {
        boolean isValid =false;
        for (int zeile = 0; zeile <8 ; zeile++) {
            for (int spalte = 0; spalte < 8; spalte++) {
                Figur figur = figurs[zeile][spalte];
                if (figur != null && figur.getFarbe() != this.getFarbe()) {
                    isValid = figur.isValidMove(newPosition, figurs);
                    // Gegner kann mich schlagen , Schach
                    if (isValid) return false;
                }
            }
        }
        // kein Gegner kann mich schlagen, kein Schach
        return true;
    }

    public boolean isEnemyKingChecked(Position1 kingPosition,Figur[][]figurs){
        if(!isPositionSafe(kingPosition,figurs)) {
            System.out.println("Gegnerischer König steht im Schach");
            return true;
        }
        return false;
    }
}
