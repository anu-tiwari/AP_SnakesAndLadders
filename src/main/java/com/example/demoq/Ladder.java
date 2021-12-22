package com.example.demoq;

import javafx.application.Platform;

import java.util.ArrayList;

public class Ladder extends Snake_Ladder
{
    Ladder(Cell T, Cell D) {
        super(T, D);
    }

    @Override
    public void move(Token tok) {
        tok.getBt().setTranslateX(getTrap().getX()-tok.getOg().getX());
        tok.getBt().setTranslateY(getTrap().getY()-tok.getOg().getY());
        tok.setDes(getDeliver());
        try{
            Thread.sleep(250);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        Platform.runLater(new Climb_Slide(this, tok));
//        tok.getBt().setTranslateX(getDeliver().getX()-tok.getOg().getX());
//        tok.getBt().setTranslateY(getDeliver().getY()-tok.getOg().getY());
//
//        tok.setPos(this, getDeliver());
    }

    @Override
    public void deliver(Token tok) {
        tok.getBt().setTranslateX(getDeliver().getX()-tok.getOg().getX());
        tok.getBt().setTranslateY(getDeliver().getY()-tok.getOg().getY());

        tok.setPos(this, getDeliver());
    }
    //low cell would be in composition with cell;
}
