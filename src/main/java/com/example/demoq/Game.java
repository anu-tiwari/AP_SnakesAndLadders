package com.example.demoq;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Game
{
    Player P1;
    Player P2;
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
    }

    public void rollDice()
    {
        int num = dice.roll();
        if (next_chance==1)
        {
            P1.travel(num);
        }
        else
        {
            P2.travel(num);
        }
    }
}
