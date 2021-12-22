package com.example.demoq;

import javafx.animation.Animation;
import javafx.animation.PathTransition;
import javafx.animation.TranslateTransition;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.paint.Color;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

import java.io.InputStream;

public class Game
{
    static Player P1;
    static Player P2;
    boolean P1_isStart;
    boolean P2_isStart;
    static int next_chance;    //1 for P1 2 for P2
    static Button dice_button;
    ImageView dice_img;
    Dice dice;
    static ImageView arrow;
    static ImageView win_img;
    static Rectangle win_dim;
    //static TranslateTransition translate;
    static PathTransition pathTransition;
    static Image arr;
    static Button replay;
    static Image light;
    static Image dark;
    static ImageView db;
    static ImageView dg;
    static ImageView lg;
    static ImageView lb;
    //static Arrow_Mov arrow_anim;

    Game(Button indi1, Button indi2, Button rep, Button d, Button p1, Button p2, ImageView dice_image, Rectangle p1_label, Rectangle p2_label, Rectangle p1_top, Rectangle p2_top, Rectangle p1_bottom, Rectangle p2_bottom, ImageView p1_bg, ImageView p2_bg, Label p1_display, Label p2_display, Cell og1, Cell og2, ImageView a, ImageView win, Rectangle win_dimming)
    {
        P1 = new Player("P1",  p1, p1_label, p1_top, p1_bottom, p1_bg, p1_display, og1, indi1);
        P2 = new Player("P2", p2, p2_label, p2_top, p2_bottom, p2_bg, p2_display, og2, indi2);
        next_chance = 1;
        dice_button = d;
        dice_img = dice_image;
        dice = new Dice(dice_img);
        P1_isStart = false;
        P2_isStart = false;
        arrow = a;
        win_img = win;
        win_img.setCache(false);
        win_dim = win_dimming;
        arrow.setImage(new Image(String.valueOf(HelloApplication.class.getResource("/images/arrow.png"))));
        arrow.setCache(false);
        //arrow_anim = new Arrow_Mov(arrow);
        //translate = new TranslateTransition();
        arr = new Image(String.valueOf(HelloApplication.class.getResource("/images/arrow.png")));
        replay = rep;
        replay.setDisable(true);
        light = new Image(String.valueOf(HelloApplication.class.getResource("/images/light.png")));
        dark = new Image(String.valueOf(HelloApplication.class.getResource("/images/dark.png")));
        Image img1 = new Image(String.valueOf(HelloApplication.class.getResource("/images/blue.png")));
        lb = new ImageView(img1);
        lb.setFitHeight(40);
        lb.setFitWidth(40);
        lb.setPreserveRatio(true);
        Image img2 = new Image(String.valueOf(HelloApplication.class.getResource("/images/blue_dark.png")));
        db = new ImageView(img2);
        db.setFitHeight(40);
        db.setFitWidth(40);
        db.setPreserveRatio(true);
        Image img3 = new Image(String.valueOf(HelloApplication.class.getResource("/images/green.png")));
        lg = new ImageView(img3);
        lg.setFitHeight(40);
        lg.setFitWidth(40);
        lg.setPreserveRatio(true);
        Image img4 = new Image(String.valueOf(HelloApplication.class.getResource("/images/green_dark.png")));
        dg = new ImageView(img4);
        dg.setFitHeight(40);
        dg.setFitWidth(40);
        dg.setPreserveRatio(true);
        prompt(this);
    }

    public static void prompt(Object o)
    {
        if (!(o instanceof Game || o instanceof Token || o instanceof Step_Walk))
            return;
        Player p;
        if (next_chance==1)
            p = P2;
        else
            p = P1;
        //arrow = new ImageView(arr);
        arrow.setImage(new Image(String.valueOf(HelloApplication.class.getResource("/images/arrow.png"))));
//        if (p.equals(P1))
//            p = P2;
//        else
//            p = P1;
//        arrow_anim.start();
//        arrow_anim.run();
//        arrow.setX(261.0);
//        arrow.setY(669.0);
        //translate = new TranslateTransition();
//        translate.setByY(10);
//        translate.setDuration(Duration.millis(1000));
//        translate.setCycleCount(2);
//        translate.setAutoReverse(true);
//        translate.setNode(arrow);
//        translate.play();

        Path path = new Path();
        path.getElements().add(new MoveTo(23, 10));
        path.getElements().add(new LineTo(23, 20));

        pathTransition = new PathTransition();

        pathTransition.setDuration(Duration.millis(500));
        pathTransition.setNode(arrow);
        pathTransition.setPath(path);
        pathTransition.setCycleCount(Animation.INDEFINITE);
        pathTransition.setAutoReverse(true);
        pathTransition.play();

        //layoutX="261.0" layoutY="669.0"/>
        p.getLabel().setFill(Color.web("#22205e"));
        p.getLabel_top().setFill(Color.web("#0c467c"));
        p.getLabel_bottom().setFill(Color.web("#42276b"));
        p.getBG().setImage(dark);
        if (p.getName().equals("P1"))
            p.getIndicator().setGraphic(db);
        else
            p.getIndicator().setGraphic(dg);
        p.getDisplay().setTextFill(Color.web("#808080"));
    }

    public static void reset_prompt(Object o)
    {
        if (!(o instanceof Game || o instanceof Token || o instanceof Step_Walk))
            return;
        P1.getLabel().setFill(Color.web("#443ebc"));
        P1.getLabel_top().setFill(Color.DODGERBLUE);
        P1.getLabel_bottom().setFill(Color.web("#844ed3"));
        P1.getBG().setImage(light);
        P1.getIndicator().setGraphic(lb);
        P1.getDisplay().setTextFill(Color.WHITE);
        //P1.getTok().getBt().setBackground(new BackgroundFill(Color.web("")));

        P2.getLabel().setFill(Color.web("#443ebc"));
        P2.getLabel_top().setFill(Color.DODGERBLUE);
        P2.getLabel_bottom().setFill(Color.web("#844ed3"));
        P2.getBG().setImage(light);
        P2.getIndicator().setGraphic(lg);
        P2.getDisplay().setTextFill(Color.WHITE);
        //P2.getTok().getBt().setBackground(new BackgroundFill(Color.web("#11a118")));
    }
    public void rollDice()
    {
        arrow.setImage(null);
        int num = dice.roll();
        if (next_chance==1)
        {
            if (num==1 && !P1_isStart) {
                P1.start();
                P1_isStart = true;
                reset_prompt(this);
                setNext_chance(this);
                prompt(this);
            }
            else if (P1_isStart) {
                if(P1.travel(num-1)==1)
                {
                    Game.reset_prompt(this);
                    Game.setNext_chance(this);
                    Game.prompt(this);
                }
                //next_chance = 2;
            }
            else
            {
                reset_prompt(this);
                setNext_chance(this);
                prompt(this);
            }
        }
        else
        {
            if (num==1 && !P2_isStart) {
                P2.start();
                P2_isStart = true;
                reset_prompt(this);
                setNext_chance(this);
                prompt(this);
            }
            else if (P2_isStart) {
                if(P2.travel(num - 1)==1)
                {
                    Game.reset_prompt(this);
                    Game.setNext_chance(this);
                    Game.prompt(this);
                }
                //next_chance = 1;
            }
            else
            {
                reset_prompt(this);
                setNext_chance(this);
                prompt(this);
            }
        }
//        reset_prompt();
//        if (next_chance==1) {
//            next_chance = 2;
//            prompt(P2);
//        }
//        else {
//            next_chance = 1;
//            prompt(P1);
//        }
    }

    public static void win(Object o)
    {
        if (!(o instanceof Token))
            return;
        if (P1.hasWon())
        {
            win_dim.setFill(Color.web("#000000"));
            win_dim.setOpacity(0.7);
            win_img.setImage(new Image(String.valueOf(HelloApplication.class.getResource("/images/Win_P1.png"))));
        }
        else if (P2.hasWon())
        {
            win_dim.setFill(Color.web("#000000"));
            win_dim.setOpacity(0.7);
            win_img.setImage(new Image(String.valueOf(HelloApplication.class.getResource("/images/Win_P2.png"))));
        }
        dice_button.setDisable(true);
        replay.setDisable(false);
    }

    public static void freeze_dice()
    {
        //arrow_anim.stop();
        //translate.stop();
        pathTransition.stop();
//        arrow.setX(261.0);
//        arrow.setY(669.0);
        dice_button.setDisable(true);
        arrow.setImage(null);
    }

    public static void unfreeze_dice()
    {
        dice_button.setDisable(false);
        arrow.setImage(new Image(String.valueOf(HelloApplication.class.getResource("/images/arrow.png"))));
    }

    public static void setNext_chance(Object o)
    {
//        if (o instanceof Game || o instanceof Token) {
        if (next_chance == 1)
            next_chance = 2;
        else
            next_chance = 1;
        //}
    }

    public void replay_game()
    {
        win_dim.setFill(Color.TRANSPARENT);
        win_img.setImage(null);
        replay.setDisable(true);
        dice_button.setDisable(false);
        dice.reset();
        P1_isStart = false;
        P2_isStart = false;
        P1.getTok().reset();
        P2.getTok().reset();
    }
}
