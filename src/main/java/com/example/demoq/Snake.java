package com.example.demoq;

import java.util.ArrayList;

public class Snake extends Snake_Ladder
{
    Snake(Cell T, Cell D) {
        super(T, D);
    }

    @Override
    public void move(Token tok) {
        tok.setDes(getDeliver());
        tok.getBt().setTranslateX(getDeliver().getX()-tok.getOg().getX());
        tok.getBt().setTranslateY(getDeliver().getY()-tok.getOg().getY());

        tok.setPos(this, getDeliver());
    }
}
