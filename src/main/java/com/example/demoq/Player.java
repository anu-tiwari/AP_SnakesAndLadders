package com.example.demoq;

import javafx.scene.control.Button;

public class Player
{
    Token tok;

    Player(Cell start, Button bt)
    {
        tok = new Token(start, bt);
    }

    public void move(int dice_value)
    {
        tok.move(dice_value);
    }

    public void travel(int num)
    {

    }

    public void start()
    {

    }
}
