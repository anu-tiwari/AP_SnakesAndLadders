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
        //tok.move(num);
        //des = cells.get();
        if (num==0) {
            if (HelloController.getCells().get(tok.getPos().getValue()).getValue()>100)
                return;
            tok.setDes(HelloController.getCells().get(tok.getPos().getValue()));
        }
        else {
            if (HelloController.getCells().get(tok.getPos().getValue() + num).getValue()>100)
                return;
            tok.setDes(HelloController.getCells().get(tok.getPos().getValue() + num));
        }
        System.out.println("des set is "+tok.getDes().getValue());
        Move m = new Move(tok, num);
        m.start();
        System.out.println("pos of " + this +" is "+tok.getPos().value);
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
