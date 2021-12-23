package com.example.demoq;

public class Step_Walk implements Runnable
{
    private Token tok;

    Step_Walk(Token t)
    {
        tok = t;
    }
    @Override
    public void run() {
        tok.one_step();
    }
}
