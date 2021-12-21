package com.example.demoq;

public class Move extends Thread
{
    Token tok;
    int dice_value;

    Move(Token t, int dice)
    {
        tok = t;
        dice_value = dice;
    }

    @Override
    public void run()
    {
        tok.move(dice_value);
    }
}
