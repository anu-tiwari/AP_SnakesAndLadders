package com.example.demoq;

import java.util.ArrayList;

public class Ladder extends Snake_Ladder
{
    Ladder(Cell T, Cell D) {
        super(T, D);
    }

    @Override
    public void move(Token tok) {

        tok.getBt().setTranslateX(getDeliver().getX()-tok.getOg().getX());
        tok.getBt().setTranslateY(getDeliver().getY()-tok.getOg().getY());

        tok.setPos(this, getDeliver());
    }
    //low cell would be in composition with cell;
}
