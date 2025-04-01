package com.konstantin.chessgamejava;

public class Brett {
    private Figur [][] figurs;
    public Brett(){
        figurs =new Figur[8][8];
                setupFigur();
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
                            case 7: figurs[zeile][spalte] =new Turm((zeile%2==0?FigurFarbe.BLACK:FigurFarbe.WHITE),new Position1(zeile,spalte));
                            break;
                            case 1:
                            case 6:
                                figurs[zeile][spalte] =new Laufer((zeile%2==0?FigurFarbe.BLACK:FigurFarbe.WHITE),new Position1(zeile,spalte));
                                break;
                            case 2:
                            case 5:
                                figurs[zeile][spalte] =new Springer((zeile%2==0?FigurFarbe.BLACK:FigurFarbe.WHITE),new Position1(zeile,spalte));
                                break;
                            case 3:
                                figurs[zeile][spalte] =new King((zeile%2==0?FigurFarbe.BLACK:FigurFarbe.WHITE),new Position1(zeile,spalte));
                                break;
                            case 4:
                                figurs[zeile][spalte] =new Queen((zeile%2==0?FigurFarbe.BLACK:FigurFarbe.WHITE),new Position1(zeile,spalte));
                                break;
                        };
                        break;
                    case 1:
                    case 6:
                        figurs[zeile][spalte] =new Bauer((zeile%2!=0?FigurFarbe.BLACK:FigurFarbe.WHITE),new Position1(zeile,spalte));
                        break;
                    default: figurs[zeile][spalte] =new Figur(FigurFarbe.BLACK,new Position1(zeile,spalte));
                };
            }

        }
    }
}
