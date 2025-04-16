package com.konstantin.chessgamejava;

public class Brett {
    private Figur [][] figurs;



    private Position1 enPassant=null;

    public void setEnPassantPawn(Figur enPassantPawn) {
        this.enPassantPawn = enPassantPawn;
    }

    private Figur enPassantPawn=null;
    private Figur whiteKing;
    private Figur blackKing;

    public Brett(){
        figurs =new Figur[8][8];
        setupFigur();

    }
    public Position1 getEnPassant() {
        return enPassant;
    }

    public void setEnPassant(Position1 enPassant) {
        this.enPassant = enPassant;
    }

    public Figur getBlackKing() {
        return blackKing;
    }

    public Figur getWhiteKing() {
        return whiteKing;
    }

    public Figur[][] getFigurs() {
        return figurs;
    }

    private void setupFigur() {
        for (int zeile = 0; zeile <8 ; zeile++) {
            for (int spalte = 0; spalte < 8; spalte++) {
                switch(zeile){
                    case 0:
                    case 7:
                        switch(spalte){
                            case 0:
                            case 7: figurs[zeile][spalte] =new Turm((zeile%2==0?FigurFarbe.BLACK:FigurFarbe.WHITE),new Position1(zeile,spalte),this);
                            break;
                            case 2:
                            case 5:
                                figurs[zeile][spalte] =new Laufer((zeile%2==0?FigurFarbe.BLACK:FigurFarbe.WHITE),new Position1(zeile,spalte),this);
                                break;
                            case 1:
                            case 6:
                                figurs[zeile][spalte] =new Springer((zeile%2==0?FigurFarbe.BLACK:FigurFarbe.WHITE),new Position1(zeile,spalte),this);
                                break;
                            case 3:
                                figurs[zeile][spalte] =new King((zeile%2==0?FigurFarbe.BLACK:FigurFarbe.WHITE),new Position1(zeile,spalte),this);
                                if(figurs[zeile][spalte].getFarbe()==FigurFarbe.BLACK){
                                    blackKing=figurs[zeile][spalte];
                                }
                                else {
                                    whiteKing=figurs[zeile][spalte];
                                }
                                break;
                            case 4:
                                figurs[zeile][spalte] =new Queen((zeile%2==0?FigurFarbe.BLACK:FigurFarbe.WHITE),new Position1(zeile,spalte),this);
                                break;
                        };
                        break;
                    case 1:
                    case 6:
                        figurs[zeile][spalte] =new Bauer((zeile == 1) ?FigurFarbe.BLACK:FigurFarbe.WHITE,new Position1(zeile,spalte),this);
                        break;
                    default:
                };
            }

        }
    }

    public boolean movePiece(Position1 start,Position1 end){
        if(start.getZeile()== end.getZeile()&& start.getSpalte()== end.getSpalte()){
            return false;
        }

        // Prüft ob eine Bauer per enPassant schlagen darf (spezielle Abhandlung vo en Passant reset)
        if(figurs[start.getZeile()][start.getSpalte()]!=null &&figurs[start.getZeile()][start.getSpalte()] instanceof Bauer && enPassant!=null&&
                enPassant.equals(end)&&figurs[start.getZeile()][start.getSpalte()].isValidMove(end,figurs)){
            figurs[end.getZeile()][end.getSpalte()]=figurs[start.getZeile()][start.getSpalte()];
            figurs[end.getZeile()][end.getSpalte()].setPosition(end);
            figurs[start.getZeile()][start.getSpalte()]=null;
            enPassant=null;
            enPassantPawn=null;
            //entferne den gegnerischen Bauern
            int gegnerzeile =figurs[start.getZeile()][start.getSpalte()].getFarbe()==FigurFarbe.WHITE ?-1:1;
            figurs[end.getZeile()+gegnerzeile][end.getSpalte()]=null;
            return true;

        }
        // setzt enpassant Information zurück (nach jedem Zug)
        enPassant=null;
        enPassantPawn=null;
        if(figurs[start.getZeile()][start.getSpalte()]!= null && figurs[start.getZeile()][start.getSpalte()].isValidMove(end,figurs))
        {
            figurs[end.getZeile()][end.getSpalte()]=figurs[start.getZeile()][start.getSpalte()];
            figurs[end.getZeile()][end.getSpalte()].setPosition(end);
            figurs[start.getZeile()][start.getSpalte()]=null;
            return true;
        }
        return false;
    }

    public boolean isKingchecked(FigurFarbe currentColor) {
        Figur figur = currentColor ==FigurFarbe.BLACK ? blackKing :whiteKing;
       // Gibt true zurück, wenn der König im Schach steht (Feld ist nicht sicher)
        return !figur.isPositionSafe(figur.getPosition(),figurs);
    }
}
