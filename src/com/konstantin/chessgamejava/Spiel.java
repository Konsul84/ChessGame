
package com.konstantin.chessgamejava;
import java.util.Locale;
import java.util.Scanner;

public class Spiel {
    private Brett brett;
    private boolean turnWhite;
    private Position1 positionStart;
    private Position1 positionEnd;
    private final Scanner sc = new Scanner(System.in);
    private static boolean checked=false;
    private static boolean hasValidMoves=true;



    public static void setIsKingChecked(boolean isKingChecked) {
        Spiel.checked = isKingChecked;
    }

    public Spiel() {

        brett = new Brett();

        // weiss fängt an
        turnWhite=true;
    }
    public void spielen(){
        printSpielFeld();
        //Spielen schleife
        while(true){
            //bestimmen welches die eigene Farbe ist um zu schauen ob man selber im Schach steht
            FigurFarbe currentColor =turnWhite ?FigurFarbe.WHITE :FigurFarbe.BLACK;
            checked =brett.isKingchecked(currentColor);
            if(checked) System.out.println("Schach");

            // schauen ob der derzeitige spielerr gültige züge hat
            if(hasNoValidMoves(currentColor)){
                //wenn keine gültigen züge und schach = Schachmatt sonst Patt
                if(checked){
                    System.out.println("Schach Matt, Spieler "+currentColor+" hat gewonnen!");
                }
                else{
                    System.out.println("Patt!");
                }
                break;
            }

            // gültigen Zug auf false setzten damit schleife anläuft
            boolean validMove=false;
            //Schleife checkt ob der Zug wirklich ausgeführt wird
            while (!validMove){

                // Liest start und Endposition ein
                Position1 start =eingabeStartposition();
                Position1 end = eingabeEndPosition();

                // Führt den Zug nur aus wenn er gültig ist und gibt das als true / false zurück
                validMove= brett.movePiece(start,end);

                // Wenn Zug nicht ausgeführt wurde wird einem gesagt das der Zug nicht gültig ist.
                if(!validMove){
                    System.out.println("Üngultiger Zug bitte Zug wiederholen!");
                }
            }
            // resettet checked wieder auf false
            checked=false;

            // wechselt Spielerfarbe
            turnWhite=!turnWhite;
        }
    }

    private boolean hasNoValidMoves(FigurFarbe enemyColor) {
        for (int i = 0; i <8 ; i++) {
            for (int j = 0; j <8 ; j++) {
                Figur figur =brett.getFigurs()[i][j];
                if(figur!=null){
                    if(figur.getFarbe()==enemyColor){
                        for (int k = 0; k <8 ; k++) {
                            {
                                for (int l = 0; l <8 ; l++) {
                                    Position1 enemyPosition =new Position1(k,l);
                                    if(figur.isValidMove(enemyPosition, brett.getFigurs())){
                                        // Einen Gültigen Zug gefunden
                                        return false;
                                    }
                                }
                            }

                        }
                    }

                }

            }

        }
        //keinen Gültigen Zug gefunden
        return true;
    }

    private Position1 eingabeEndPosition(){

        int zeileEnd=-1;
        int spalteEnd=-1;
        boolean validEingabe=false;
        do{
            try{
                System.out.println("Bitte die Zielposition eingeben Format a0 bis h8: ");
                String input=sc.next().toLowerCase().trim();

                if(input.length()!=2){
                    System.out.println("Ungültige Eingabelänge, wiederholen Sie bitte ihre Eingabe:");
                    continue;
                }

                char zeileChar =input.charAt(1);
                char spalteChar =input.charAt(0);
                if(zeileChar<'1'||zeileChar>'8'|| spalteChar<'a'||spalteChar>'h'){
                    System.out.println("Eingabe ist nicht zwischen a0 und h8, wiederholen Sie bitte ihre Eingabe:");
                    continue;

                }
                spalteEnd =(spalteChar-'a');
                zeileEnd =7- Character.getNumericValue(zeileChar);
                validEingabe=true;
            } catch (NumberFormatException e) {
                System.out.println("Eigentlich deckt der Code alles ab so dass keien Exeption kommen könnte");
            }
        }while (!validEingabe);
        return new Position1(zeileEnd,spalteEnd);
    }

    private Position1 eingabeStartposition() {
        String spielerFarbe =(turnWhite==true ? "Weiß":"Schwarz");
        System.out.printf("Spieler %s ist am Zug! %n",spielerFarbe);
        boolean validEingabe =false;
        int zeileStart=-1;
        int spalteStart=-1;
        do{
            try{
                System.out.println("Welche Figur wollen sie bewegen? Format: a0 bis h8");
                String input=sc.next().toLowerCase().trim();

                if(input.length()!=2){
                    System.out.println("Ungültige Eingabelänge, wiederholen Sie bitte ihre Eingabe:");
                    continue;
                }

                char zeileChar =input.charAt(1);
                char spalteChar =input.charAt(0);
                if(zeileChar<'1'||zeileChar>'8'|| spalteChar<'a'||spalteChar>'h'){
                    System.out.println("Eingabe ist nicht zwischen a0 und h8, wiederholen Sie bitte ihre Eingabe:");
                    continue;

                }
                spalteStart =(spalteChar-'a');
                zeileStart =7- Character.getNumericValue(zeileChar);

                Figur figur = brett.getFigurs()[zeileStart][spalteStart];
                if(figur==null){
                    System.out.println("Auf dem Feld befindet sich keine Figur, bitte wiederholen Sie ihre Eingabe!");
                    continue;
                }else if((turnWhite&&figur.getFarbe()==FigurFarbe.WHITE)||
                        (!turnWhite&&figur.getFarbe()==FigurFarbe.BLACK)){
                    validEingabe=true;
                } else {
                    System.out.printf("Das ist nicht ihre Figur! Bitte eine %se Figur auswählen!",spielerFarbe);
                    continue;
                }
            } catch (Exception e) {
                System.out.println("Eigentlich deckt der Code alles ab so dass keien Exeption kommen könnte");
            }
        }while(!validEingabe);
        return new Position1(zeileStart,spalteStart);
    }

    public Brett getBrett() {
        return brett;
    }


    // Spielfeld ausgeben
    public void printSpielFeld() {

        // Spalten mit A-H beschriften
        System.out.println("ABCDEFGH");

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if(brett.getFigurs()[i][j]==null){
                    //Schachbrettmuster für nicht besetzte Felder
                    char feld = (i+j)%2==0 ? ' ': '\u2591';
                    System.out.print(feld);
                }else{
                    System.out.print(brett.getFigurs()[i][j].getBezeichnung());
                }
               }
            // Zeilen mit 1-8 beschriften
            System.out.print(" "+(i+1));
            System.out.printf("%n");
            }
        }
    }
