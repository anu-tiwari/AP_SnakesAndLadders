package com.example.demoq;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.shape.Rectangle;

public class Player
{
    Token tok;
    Rectangle label;
    Rectangle label_top;
    Rectangle label_bottom;
    Rectangle BG;
    Label display;

    Player(Cell start, Button bt, Rectangle l, Rectangle t, Rectangle b, Rectangle bg, Label dis, Cell og)
    {
        tok = new Token(start, bt, og);
        label = l;
        label_top = t;
        label_bottom = b;
        BG = bg;
        display = dis;
    }

    public void travel(int num)
    {
        tok.move(num);
        if (tok.getPos().isSnakeMouth() || tok.getPos().isLadderLow())
            HelloController.getSandL().get(tok.getPos()).move(tok);
    }

    public void start()
    {
        tok.start();
    }

    public Rectangle getLabel() {
        return label;
    }

    public Rectangle getLabel_top() {
        return label_top;
    }

    public Rectangle getLabel_bottom() {
        return label_bottom;
    }

    public Rectangle getBG()
    {
        return BG;
    }

    public Label getDisplay() {
        return display;
    }

    public Token getTok() {
        return tok;
    }

    public boolean hasWon()
    {
        return tok.getPos().getValue() == 100;
    }
}
