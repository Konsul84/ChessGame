package com.konstantin.chessgamejava;
//gggggg
public  class Figur {
    protected Position1 position;
    protected FigurFarbe farbe;
    protected char bezeichnung;
    protected Brett brett;
    protected boolean notMoved=true;

    public Figur (FigurFarbe farbe, Position1 position, Brett brett){
        this.position=position;
        this.farbe=farbe;
        this.brett=brett;
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
    public boolean isPositionSafe(Position1 newPosition, Figur[][]figurs) {
        return true;
    }

    public boolean isNotMoved() {
        return notMoved;
    }

    public void setToMoved() {
        notMoved = false;
    }

    public boolean isMyKingNotCheck(Position1 newPosition, Figur[][]figurs){
        Figur startFigur =figurs[position.getZeile()][position.getSpalte()];
        Figur endFigur =figurs[newPosition.getZeile()][newPosition.getSpalte()];
        figurs[newPosition.getZeile()][newPosition.getSpalte()] =startFigur;
        figurs[position.getZeile()][position.getSpalte()] =null;

        boolean notCheck=false;
        Figur myKing =(this.getFarbe()==FigurFarbe.BLACK) ?brett.getBlackKing():brett.getWhiteKing();

        notCheck =myKing.isPositionSafe(myKing.getPosition(),figurs);        figurs[position.getZeile()][position.getSpalte()] = startFigur;
        figurs[newPosition.getZeile()][newPosition.getSpalte()] =endFigur;
        if(!notCheck){
            System.out.println("Zug nicht ausführbar, ihr König würde im Schach stehen!");
        }
        return notCheck;
    }






}
