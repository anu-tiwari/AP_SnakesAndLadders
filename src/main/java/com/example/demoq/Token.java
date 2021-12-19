package com.example.demoq;

import javafx.scene.control.Button;

public class Token
{
    Cell pos;
    Button bt;

    Token(Cell start, Button b)
    {
        pos = start;
        bt = b;
    }

    public Button getBt() {
        return bt;
    }

    public Cell getPos() {
        return pos;
    }

    public void move(int dice_value)
    {

    }
}
