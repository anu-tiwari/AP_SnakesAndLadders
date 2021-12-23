package com.example.demoq;

public class Cell
{
    private final int value;
    private final double X;
    private final double Y;
    private boolean SnakeMouth;
    private boolean LadderLow;

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
