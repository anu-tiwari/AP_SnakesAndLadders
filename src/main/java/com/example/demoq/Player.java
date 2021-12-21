package com.example.demoq;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.shape.Rectangle;

public class Player
{
    String name;
    Token tok;
    Rectangle label;
    Rectangle label_top;
    Rectangle label_bottom;
    Rectangle BG;
    Label display;

    Player(String n, Cell start, Button bt, Rectangle l, Rectangle t, Rectangle b, Rectangle bg, Label dis, Cell og)
    {
        name = n;
        tok = new Token(start, bt, og);
        label = l;
        label_top = t;
        label_bottom = b;
        BG = bg;
        display = dis;
    }

    public String getName() {
        return name;
    }

    public int travel(int num)
    {
        //tok.move(num);
        //des = cells.get();
        if (num==0) {
            if (tok.getPos().getValue()>99)
                return 1;
            tok.setDes(HelloController.getCells().get(tok.getPos().getValue()));
        }
        else {
            if (tok.getPos().getValue() + num>99) {
//                Game.reset_prompt(this);
//                Game.setNext_chance(this);
//                Game.prompt(this);
                return 1;
            }
            tok.setDes(HelloController.getCells().get(tok.getPos().getValue() + num));
        }
        System.out.println("des set is "+tok.getDes().getValue());
        Game.freeze_dice();
        Move m = new Move(tok, num);
        m.start();
        System.out.println("pos of " + this.name +" is "+tok.getPos().value);
        return 0;
//        try {
//            m.join();
//        }
//        catch (Exception e)
//        {
//            e.printStackTrace();
//        }
//        if (!m.isAlive())
        //Game.setNext_chance(getName());
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
