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
//        if (tok.getDes().getValue()==tok.getPos().getValue())
//        {
//            Game.unfreeze_dice();
//            Game.reset_prompt(this);
//            Game.setNext_chance(this);
//            Game.prompt(this);
//        }
    }
}
