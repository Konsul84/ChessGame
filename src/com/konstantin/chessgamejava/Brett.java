package com.konstantin.chessgamejava;

public class Brett {
    private Figur [][] figurs;
    public Brett(){
        figurs =new Figur[8][8];
                setupFigur();
    }
    private Figur whiteKing;
    private Figur blackKing;

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
                            case 1:
                            case 6:
                                figurs[zeile][spalte] =new Laufer((zeile%2==0?FigurFarbe.BLACK:FigurFarbe.WHITE),new Position1(zeile,spalte),this);
                                break;
                            case 2:
                            case 5:
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
        // wenn Feld nicht sicher ist steht König im Schach
        return !figur.isPositionSafe(figur.getPosition(),figurs);
    }
}
