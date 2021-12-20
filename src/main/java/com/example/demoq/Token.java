package com.example.demoq;

import javafx.scene.control.Button;

import java.util.ArrayList;

public class Token
{
    Cell pos;
    Button bt;
    Cell og;
    ArrayList<Cell> cells;

    Token(Cell start, Button b, Cell org)
    {
        pos = start;
        bt = b;
        og = org;
        cells = HelloController.getCells();
    }

    public Button getBt() {
        return bt;
    }

    public Cell getPos() {
        return pos;
    }

    public void move(int dice_value)
    {
        int new_val = pos.getValue() + dice_value;
//        for (int i= pos.getValue(); i<=new_val-1; i++)
//        {
//            bt.setTranslateX(cells.get(i).getX()-og.getX());
//            bt.setTranslateY(cells.get(i).getY()-og.getY());
//        }
        bt.setTranslateX(cells.get(new_val-1).getX()-og.getX());
        bt.setTranslateY(cells.get(new_val-1).getY()-og.getY());
        pos = cells.get(new_val-1);
    }

    public void start()
    {
        bt.setTranslateX(cells.get(0).getX() - og.getX());
        bt.setTranslateY(cells.get(0).getY() - og.getY());
        pos = cells.get(0);
    }
}
