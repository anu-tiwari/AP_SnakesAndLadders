package com.example.demoq;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;
import java.util.Random;

public class Dice
{
    ImageView dice_img;
    Image one;
    Image two;
    Image three;
    Image four;
    Image five;
    Image six;
    Random rnd;

    Dice(ImageView imgView)
    {
        dice_img = imgView;
        one = new Image(new File("/one_dice.png").toURI().toString(), true);
        if (one.isError()) {
            System.out.println(one.getException());
        } else {
            one.errorProperty().addListener((observable, oldValue, newValue) -> {
                if (one.isError()) {
                    System.out.println(one.getException());
                }
            });
        }
        two = new Image(new File("/com.example.demoq/two_dice.png").toURI().toString(), true);
        if (two.isError()) {
            System.out.println(two.getException());
        } else {
            two.errorProperty().addListener((observable, oldValue, newValue) -> {
                if (two.isError()) {
                    System.out.println(two.getException());
                }
            });
        }
        three = new Image(new File("/com.example.demoq/three_dice.png").toURI().toString(), true);
        if (three.isError()) {
            System.out.println(three.getException());
        } else {
            three.errorProperty().addListener((observable, oldValue, newValue) -> {
                if (three.isError()) {
                    System.out.println(three.getException());
                }
            });
        }
        four = new Image(new File("/com.example.demoq/four_dice.png").toURI().toString(), true);
        if (four.isError()) {
            System.out.println(four.getException());
        } else {
            four.errorProperty().addListener((observable, oldValue, newValue) -> {
                if (four.isError()) {
                    System.out.println(four.getException());
                }
            });
        }
        five = new Image(new File("/com.example.demoq/five_dice.png").toURI().toString(), true);
        if (five.isError()) {
            System.out.println(five.getException());
        } else {
            five.errorProperty().addListener((observable, oldValue, newValue) -> {
                if (five.isError()) {
                    System.out.println(five.getException());
                }
            });
        }
        six = new Image(new File("/com.example.demoq/six_dice.png").toURI().toString(), true);
        if (six.isError()) {
            System.out.println(six.getException());
        } else {
            six.errorProperty().addListener((observable, oldValue, newValue) -> {
                if (six.isError()) {
                    System.out.println(six.getException());
                }
            });
        }
        rnd = new Random();
    }

    public int roll()
    {
        int num = rnd.nextInt(6);
        num++;
        if (num==1)
        {
            dice_img.setImage(one);
        }
        else if (num==2)
        {
            dice_img.setImage(two);
        }
        else if (num==3)
        {
            dice_img.setImage(three);
        }
        else if (num==4)
        {
            dice_img.setImage(four);
        }
        else if (num==5)
        {
            dice_img.setImage(five);
        }
        else {
            dice_img.setImage(six);
        }

        return num;
    }
}
