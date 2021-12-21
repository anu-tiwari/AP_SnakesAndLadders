package com.example.demoq;

public class Step_Walk implements Runnable
{
    Token tok;

    Step_Walk(Token t)
    {
        tok = t;
    }
    @Override
    public void run() {
        //System.out.println("in run function of step walk");
        tok.one_step();
    }
}
