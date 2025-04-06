package com.konstantin.chessgamejava;

import javax.swing.text.Position;

public  class Figur {
    protected Position1 position;
    protected FigurFarbe farbe;
    protected char bezeichnung;


    public Figur (FigurFarbe farbe, Position1 position){
        this.position=position;
        this.farbe=farbe;
        bezeichnung=farbe==FigurFarbe.BLACK ? Character.toUpperCase(getBezeichnung()):getBezeichnung();
    }

    public char getBezeichnung() {
        return bezeichnung;
    }

    public Position1 getPosition() {
        return position;
    }

    public FigurFarbe getFarbe() {
        return farbe;
    }

    public void setPosition(Position1 position) {
        this.position = position;
    }

    public boolean isValidMove(Position1 newPosition, Figur[][]figurs){
        return true;
    }
    public boolean isNotCheck(Position1 newPosition, Figur[][]figurs) {
        return true;
    }
    public boolean isMyKingNotCheck(Position1 newPosition,Figur[][]figurs){
        Figur startFigur =figurs[position.getZeile()][position.getSpalte()];
        Figur endFigur =figurs[newPosition.getZeile()][newPosition.getSpalte()];
        figurs[newPosition.getZeile()][newPosition.getSpalte()] =startFigur;
        figurs[position.getZeile()][position.getSpalte()] =null;

        boolean notCheck=false;
        Figur myKing =(this.getFarbe()==FigurFarbe.BLACK) ?Brett.getBlackKing():Brett.getWhiteKing();

        notCheck =myKing.isNotCheck(myKing.getPosition(),figurs);

        if(notCheck){
            Figur enemyKing =(this.getFarbe()==FigurFarbe.WHITE) ?Brett.getBlackKing():Brett.getWhiteKing();
            Spiel.setIsKingChecked(enemyKing.isEnemyKingChecked(position,figurs));

        }
        figurs[position.getZeile()][position.getSpalte()] = startFigur;
        figurs[newPosition.getZeile()][newPosition.getSpalte()] =endFigur;
        if(!notCheck){
            System.out.println("Zug nicht ausführbar, ihr König würde im Schach stehen!");
        }
        return notCheck;
    }

    public boolean isEnemyKingChecked(Position1 position, Figur[][] figurs) {
        return false;
    }




}
