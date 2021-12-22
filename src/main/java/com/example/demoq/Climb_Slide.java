package com.example.demoq;

public class Climb_Slide implements Runnable
{
    Snake_Ladder obstacle;
    Token tok;

    Climb_Slide(Snake_Ladder obs, Token t)
    {
        tok = t;
        obstacle = obs;
    }
    @Override
    public void run() {
        //System.out.println("in run function of step walk");
        //obstacle.deliver(tok);
    }
}
