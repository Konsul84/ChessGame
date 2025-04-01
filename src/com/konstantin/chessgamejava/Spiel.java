package com.konstantin.chessgamejava;

public class Spiel {
    private Brett brett;

    public Spiel() {
        brett = new Brett();
        printSpielFeld();
    }

    public Brett getBrett() {
        return brett;
    }

    public void printSpielFeld() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                System.out.print(brett.getFigurs()[i][j].getBezeichnung());
               }
            System.out.printf("%n");
            }
        }
    }
