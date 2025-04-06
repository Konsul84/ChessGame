package com.konstantin.chessgamejava;

import javax.swing.text.Position;

public class Queen extends Figur{
    public Queen(FigurFarbe farbe,Position1 position) {
        super(farbe,position);
        bezeichnung = farbe == FigurFarbe.BLACK ? 'Q' : 'q';
    }
    private final Turm turmMoveCheck =new Turm(this.getFarbe(),this.getPosition());
    private final Laufer lauferMoveCheck =new Laufer(this.getFarbe(),this.getPosition());

    @Override
    public boolean isValidMove(Position1 newPosition, Figur[][] figurs) {
        turmMoveCheck.setPosition(this.getPosition());
        lauferMoveCheck.setPosition(this.getPosition());
        if(turmMoveCheck.isValidMove(newPosition, figurs)|| lauferMoveCheck.isValidMove(newPosition,figurs)){
            return isMyKingNotCheck(newPosition,figurs);
        }
        return false;
    }
}
