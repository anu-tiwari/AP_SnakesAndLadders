package com.example.demoq;

public class Cell
{
    int value;
    double X;
    double Y;
    boolean SnakeMouth;
    boolean LadderLow;

    Cell(int v, double x, double y)
    {
        value = v;
        X = x;
        Y = y;
    }

    public void setLadderLow(boolean ladderLow) {
        LadderLow = ladderLow;
    }

    public void setSnakeMouth(boolean snakeMouth) {
        SnakeMouth = snakeMouth;
    }

    public boolean isLadderLow() {
        return LadderLow;
    }

    public boolean isSnakeMouth() {
        return SnakeMouth;
    }

    public double getX()
    {
        return X;
    }

    public double getY() {
        return Y;
    }

    public int getValue() {
        return value;
    }
}
