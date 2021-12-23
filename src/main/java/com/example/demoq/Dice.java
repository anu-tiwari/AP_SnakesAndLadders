package com.example.demoq;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.Random;

public class Dice
{
    private ImageView dice_img;
    private final Image one;
    private final Image two;
    private final Image three;
    private final Image four;
    private final Image five;
    private final Image six;
    private final Random rnd;

    Dice(ImageView imgView)
    {
//        FileInputStream fis1 = null;
//        FileInputStream fis2 = null;
//        FileInputStream fis3 = null;
//        FileInputStream fis4 = null;
//        FileInputStream fis5 = null;
//        FileInputStream fis6 = null;
        dice_img = imgView;
//        try
//        {   fis1 = new FileInputStream("/src/main/java/");}
//        catch(Exception e)
//        {
//            e.printStackTrace();
//        }
        one = new Image(String.valueOf(Dice.class.getResource("/images/one_dice.png")));
        if (one.isError()) {
            System.out.println(one.getException());
        } else {
            one.errorProperty().addListener((observable, oldValue, newValue) -> {
                if (one.isError()) {
                    System.out.println(one.getException());
                }
            });
        }
//        try
//        {   fis2 = new FileInputStream("two_dice.png");}
//        catch(Exception e)
//        {
//            e.printStackTrace();
//        }
        two = new Image(String.valueOf(HelloApplication.class.getResource("/images/two_dice.png")));
        if (two.isError()) {
            System.out.println(two.getException());
        } else {
            two.errorProperty().addListener((observable, oldValue, newValue) -> {
                if (two.isError()) {
                    System.out.println(two.getException());
                }
            });
        }
//        try
//        {   fis3 = new FileInputStream("three_dice.png");}
//        catch(Exception e)
//        {
//            e.printStackTrace();
//        }
        three = new Image(String.valueOf(HelloApplication.class.getResource("/images/three_dice.png")));
        if (three.isError()) {
            System.out.println(three.getException());
        } else {
            three.errorProperty().addListener((observable, oldValue, newValue) -> {
                if (three.isError()) {
                    System.out.println(three.getException());
                }
            });
        }
//        try
//        {   fis4 = new FileInputStream("four_dice.png");}
//        catch(Exception e)
//        {
//            e.printStackTrace();
//        }
        four = new Image(String.valueOf(HelloApplication.class.getResource("/images/four_dice.png")));
        if (four.isError()) {
            System.out.println(four.getException());
        } else {
            four.errorProperty().addListener((observable, oldValue, newValue) -> {
                if (four.isError()) {
                    System.out.println(four.getException());
                }
            });
        }
//        try
//        {   fis5 = new FileInputStream("five_dice.png");}
//        catch(Exception e)
//        {
//            e.printStackTrace();
//        }
        five = new Image(String.valueOf(HelloApplication.class.getResource("/images/five_dice.png")));
        if (five.isError()) {
            System.out.println(five.getException());
        } else {
            five.errorProperty().addListener((observable, oldValue, newValue) -> {
                if (five.isError()) {
                    System.out.println(five.getException());
                }
            });
        }
//        try
//        {   fis6 = new FileInputStream("six_dice.png");}
//        catch(Exception e)
//        {
//            e.printStackTrace();
//        }
        six = new Image(String.valueOf(HelloApplication.class.getResource("/images/six_dice.png")));
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

    public void reset()
    {
        dice_img.setImage(six);
    }
}
