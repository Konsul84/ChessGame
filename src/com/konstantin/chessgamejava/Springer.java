package com.konstantin.chessgamejava;

import javax.swing.text.Position;

public class Springer extends Figur{
    public Springer(FigurFarbe farbe,Position1 position,Brett brett) {
        super(farbe,position,brett);
        bezeichnung = farbe == FigurFarbe.BLACK ? 'S' : 's';
    }

    @Override
    public boolean isValidMove(Position1 newPosition, Figur[][] figurs) {
        int zeilenDiff=Math.abs(newPosition.getZeile()- position.getZeile());
        int spaltendDiff = Math.abs(newPosition.getSpalte()- position.getSpalte());

        if((zeilenDiff==2&&spaltendDiff==1)||(zeilenDiff==1&&spaltendDiff==2)){
            Figur figur =figurs[newPosition.getZeile()][newPosition.getSpalte()];

            if(figur!=null&&figur.getFarbe()==this.getFarbe()){
                return false;
            }
            return isMyKingNotCheck(newPosition,figurs);
        }
        return false;

    }
//    public boolean isMyKingNotCheck(Position1 newPosition,Figur[][]figurs){
//        Figur startFigur =figurs[position.getZeile()][position.getSpalte()];
//        Figur endFigur =figurs[newPosition.getZeile()][newPosition.getSpalte()];
//        figurs[newPosition.getZeile()][newPosition.getSpalte()] =startFigur;
//        figurs[position.getZeile()][position.getSpalte()] =null;
//
//        boolean notCheck=false;
//        if(this.getFarbe()==FigurFarbe.BLACK){
//            notCheck=Brett.blackKing.isNotCheck(Brett.blackKing.position,figurs);
//
//        }else{
//            notCheck=Brett.whiteKing.isNotCheck(Brett.whiteKing.position, figurs);
//        }
//        figurs[position.getZeile()][position.getSpalte()] = startFigur;
//        figurs[newPosition.getZeile()][newPosition.getSpalte()] =endFigur;
//        return notCheck;
//    }


}
