package com.example.demoq;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;

public class Player
{
    private final String name;
    private final Token tok;
    private final Rectangle label;
    private final Rectangle label_top;
    private final Rectangle label_bottom;
    private final ImageView BG;
    private final Label display;
    private final Button indicator;

    Player(String n, Button bt, Rectangle l, Rectangle t, Rectangle b, ImageView bg, Label dis, Cell og, Button i)
    {
        name = n;
        tok = new Token(bt, og);
        label = l;
        label_top = t;
        label_bottom = b;
        BG = bg;
        display = dis;
        indicator = i;
    }

    public String getName() {
        return name;
    }

    public Button getIndicator()
    {
        return indicator;
    }
    public int travel(int num)
    {
        if (num==0) {
            if (tok.getPos().getValue()>99)
                return 1;
            tok.setDes(HelloController.getCells().get(tok.getPos().getValue()));
        }
        else {
            if (tok.getPos().getValue() + num>99) {
                return 1;
            }
            tok.setDes(HelloController.getCells().get(tok.getPos().getValue() + num));
        }
        Game.freeze_dice();
        Move m = new Move(tok, num);
        m.start();
        return 0;
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

    public ImageView getBG()
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
