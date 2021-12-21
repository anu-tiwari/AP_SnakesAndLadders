package com.example.demoq;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Game
{
    static Player P1;
    static Player P2;
    boolean P1_isStart;
    boolean P2_isStart;
    int next_chance;    //1 for P1 2 for P2
    //Button dice_button;
    ImageView dice_img;
    Dice dice;
    static ImageView arrow;
    static ImageView win_img;
    static Rectangle win_dim;

    Game(Button p1, Button p2, Cell p1_start, Cell p2_start, ImageView dice_image, Rectangle p1_label, Rectangle p2_label, Rectangle p1_top, Rectangle p2_top, Rectangle p1_bottom, Rectangle p2_bottom, Rectangle p1_bg, Rectangle p2_bg, Label p1_display, Label p2_display, Cell og1, Cell og2, ImageView a, ImageView win, Rectangle win_dimming)
    {
        P1 = new Player("P1", p1_start, p1, p1_label, p1_top, p1_bottom, p1_bg, p1_display, og1);
        P2 = new Player("P2", p2_start, p2, p2_label, p2_top, p2_bottom, p2_bg, p2_display, og2);
        next_chance = 1;
        //dice_button = d;
        dice_img = dice_image;
        dice = new Dice(dice_img);
        P1_isStart = false;
        P2_isStart = false;
        arrow = a;
        win_img = win;
        win_dim = win_dimming;
        prompt(P1);
    }

    public static void prompt(Player p)
    {
        arrow.setImage(new Image(String.valueOf(HelloApplication.class.getResource("/images/arrow.png"))));
        if (p.equals(P1))
            p = P2;
        else
            p = P1;
        p.getLabel().setFill(Color.web("#22205e"));
        p.getLabel_top().setFill(Color.web("#0c467c"));
        p.getLabel_bottom().setFill(Color.web("#42276b"));
        p.getBG().setFill(Color.web("#0f477c"));
        p.getBG().setStroke(Color.web("#615d07"));
        p.getDisplay().setTextFill(Color.web("#808080"));
    }

    public static void reset_prompt()
    {
        P1.getLabel().setFill(Color.web("#443ebc"));
        P1.getLabel_top().setFill(Color.DODGERBLUE);
        P1.getLabel_bottom().setFill(Color.web("#844ed3"));
        P1.getBG().setFill(Color.DODGERBLUE);
        P1.getBG().setStroke(Color.web("#e4da19"));
        P1.getDisplay().setTextFill(Color.WHITE);
        //P1.getTok().getBt().setBackground(new BackgroundFill(Color.web("")));

        P2.getLabel().setFill(Color.web("#443ebc"));
        P2.getLabel_top().setFill(Color.DODGERBLUE);
        P2.getLabel_bottom().setFill(Color.web("#844ed3"));
        P2.getBG().setFill(Color.DODGERBLUE);
        P2.getBG().setStroke(Color.web("#e4da19"));
        P2.getDisplay().setTextFill(Color.WHITE);
        //P2.getTok().getBt().setBackground(new BackgroundFill(Color.web("#11a118")));
    }
    public void rollDice()
    {
        arrow.setImage(null);
        freeze_dice();
        int num = dice.roll();
        if (next_chance==1)
        {
            if (num==1 && !P1_isStart) {
                P1.start();
                P1_isStart = true;
            }
//            else if(num==1 && P1_isStart)
//            {
//                P1.travel(num);
//            }
            else if (P1_isStart) {
                P1.travel(num-1);
            }
        }
        else
        {
            if (num==1 && !P2_isStart) {
                P2.start();
                P2_isStart = true;
            }
//            else if(num==1 && P2_isStart)
//            {
//                P1.travel(num);
//            }
            else if (P2_isStart)
                P2.travel(num-1);
        }
        reset_prompt();
        if (next_chance==1) {
            next_chance = 2;
            prompt(P2);
        }
        else {
            next_chance = 1;
            prompt(P1);
        }
    }

    public static void win()
    {
        if (P1.hasWon())
        {
            win_dim.setFill(Color.web("#000000"));
            win_dim.setOpacity(0.7);
            win_img.setImage(new Image(String.valueOf(HelloApplication.class.getResource("/images/Win_P1.png"))));
            return;
        }
        if (P2.hasWon())
        {
            win_dim.setFill(Color.web("#000000"));
            win_dim.setOpacity(0.7);
            win_img.setImage(new Image(String.valueOf(HelloApplication.class.getResource("/images/Win_P2.png"))));
            return;
        }
    }
    public void freeze_dice() {
    }

    public void setNext_chance()
    {

    }
}
