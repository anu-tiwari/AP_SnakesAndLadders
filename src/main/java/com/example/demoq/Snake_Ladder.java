package com.example.demoq;

abstract public class Snake_Ladder
{
    private Cell trap;
    private Cell deliver;

    Snake_Ladder(Cell T, Cell D)
    {
        trap = T;
        deliver = D;
    }
    public Cell getTrap() {
        return trap;
    }

    public Cell getDeliver() {
        return deliver;
    }

    abstract public void move(Token tok);
}
