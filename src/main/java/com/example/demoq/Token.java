package com.example.demoq;

import javafx.application.Platform;
import javafx.scene.control.Button;

import java.util.ArrayList;

public class Token
{
    private Cell pos;
    private Button bt;
    private Cell og;
    private Cell des;
    private ArrayList<Cell> cells;

    Token(Button b, Cell org)
    {
        bt = b;
        og = org;
        pos = og;
        cells = HelloController.getCells();
    }

    public Button getBt() {
        return bt;
    }

    public Cell getPos() {
        return pos;
    }

    public void setPos(Cell p)
    {
        pos = p;
    }

    public void setDes(Cell d)
    {
        des = d;
    }

    public void move()
    {
        if (des.getValue()>100)
            return;
        while(!pos.equals(cells.get(des.getValue()-1)))
        {
            try{
                Thread.sleep(250);
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
            Platform.runLater(new Step_Walk(this));
        }
        pos = des;
    }

    public void start()
    {
        bt.setTranslateX(cells.get(0).getX() - og.getX());
        bt.setTranslateY(cells.get(0).getY() - og.getY());
        pos = cells.get(0);
    }

    public Cell getDes() {
        return des;
    }

    public Cell getOg()
    {
        return og;
    }

    public void one_step()
    {
        if (pos.getValue()==des.getValue()) {
            Game.unfreeze_dice();
            Game.reset_prompt(this);
            Game.setNext_chance();
            Game.prompt(this);
            return;
        }
        bt.setTranslateX(cells.get(getPos().getValue()).getX() - og.getX());
        bt.setTranslateY(cells.get(getPos().getValue()).getY() - og.getY());
        pos = cells.get(getPos().getValue());
        if (pos.getValue()==des.getValue()) {
            if (pos.isSnakeMouth() || pos.isLadderLow()) {
                HelloController.getSandL().get(pos).move(this);
            }
        }
        if(pos.getValue()==100)
        {
            Game.win(this);
        }
    }

    public void reset()
    {
        bt.setTranslateX(0.0);
        bt.setTranslateY(0.0);
        pos = og;
    }
}
