package com.example.demoq;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Game
{
    Player P1;
    Player P2;
    boolean P1_isStart;
    boolean P2_isStart;
    int next_chance;    //1 for P1 2 for P2
    Button dice_button;
    ImageView dice_img;
    Dice dice;

    Game(Button p1, Button p2, Cell p1_start, Cell p2_start, Button d, ImageView dice_image)
    {
        P1 = new Player(p1_start, p1);
        P2 = new Player(p2_start, p2);
        next_chance = 1;
        dice_button = d;
        dice_img = dice_image;
        dice = new Dice(dice_img);
        P1_isStart = false;
        P2_isStart = false;
    }

    public void rollDice()
    {
        int num = dice.roll();
        if (next_chance==1)
        {
            if (num==1 && !P1_isStart)
                P1.start();
            else
                P1.travel(num);
        }
        else
        {
            if (num==2 && !P2_isStart)
                P2.start();
            else
                P2.travel(num);
        }
        if (next_chance==1)
            next_chance = 2;
        else
            next_chance = 1;
    }
}
