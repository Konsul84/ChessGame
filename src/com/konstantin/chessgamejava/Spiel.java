
package com.konstantin.chessgamejava;
import java.util.Locale;
import java.util.Scanner;

public class Spiel {
    private Brett brett;
    private boolean turnWhite;
    private Position1 positionStart;
    private Position1 positionEnd;
    private final Scanner sc = new Scanner(System.in);
    private static boolean isKingChecked=false;

    public static boolean isIsKingChecked() {
        return isKingChecked;
    }

    public static void setIsKingChecked(boolean isKingChecked) {
        Spiel.isKingChecked = isKingChecked;
    }





    public Spiel() {

        brett = new Brett();
        turnWhite=true;
        printSpielFeld();
    }
    public void spielen(){
        while(true){
            Position1 start =eingabeStartposition();
            Position1 end = eingabeEndPosition();
            brett.movePiece(start,end);
            printSpielFeld();
            turnWhite=!turnWhite;
        }
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

    public void printSpielFeld() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if(brett.getFigurs()[i][j]==null){
                    System.out.print("x");
                }else{
                    System.out.print(brett.getFigurs()[i][j].getBezeichnung());
                }
               }
            System.out.printf("%n");
            }
        }
    }
