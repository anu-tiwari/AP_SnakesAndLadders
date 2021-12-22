package com.example.demoq;

import javafx.animation.PathTransition;
import javafx.animation.PauseTransition;
import javafx.animation.SequentialTransition;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.util.Duration;

import java.util.ArrayList;

public class Snake extends Snake_Ladder
{
    Snake(Cell T, Cell D) {
        super(T, D);
    }

    @Override
    public void move(Token tok) {
//        tok.getBt().setTranslateX(getTrap().getX()-tok.getOg().getX());
//        tok.getBt().setTranslateY(getTrap().getY()-tok.getOg().getY());
//        try{
//            Thread.sleep(250);
//        }
//        catch(Exception e)
//        {
//            e.printStackTrace();
//        }
//        Platform.runLater(new Climb_Slide(this, tok));
////        tok.getBt().setTranslateX(getDeliver().getX()-tok.getOg().getX());
////        tok.getBt().setTranslateY(getDeliver().getY()-tok.getOg().getY());
////

        Path path = new Path();
        path.getElements().add(new MoveTo((getTrap().getX()+20.0)-tok.getOg().getX(), (getTrap().getY()+20.0)-tok.getOg().getY()));
        path.getElements().add(new LineTo((getDeliver().getX()+20.0)-tok.getOg().getX(), (getDeliver().getY()+20.0)-tok.getOg().getY()));

        PathTransition pathTransition = new PathTransition();

        pathTransition.setDuration(Duration.millis(250));
        pathTransition.setNode(tok.getBt());
        pathTransition.setPath(path);
        pathTransition.setCycleCount(1);
        pathTransition.setAutoReverse(false);
        //pathTransition.setOnFinished(new EventHandler<ActionEvent>() {

//        pathTransition.setOnFinished(e -> {
//             set(tok);});
//        pathTransition.play();
        //PauseTransition pauseTransition = new PauseTransition(Duration.millis(2000));
        //SequentialTransition sequentialTransition = new SequentialTransition(pathTransition, pauseTransition);
        pathTransition.setOnFinished(e -> {
            set(tok);});
        pathTransition.play();
        //if (pathTransition.h)
//        pathTransition.setOnFinished(new EventHandler<ActionEvent>() {
//
//            @Override
//            public void handle(ActionEvent event) {
//                tok.setDes(getDeliver());
//                tok.setPos(this, getDeliver());
//            }
//        });
//        SequentialTransition sequentialTransition = new SequentialTransition(pathTransition);
//        sequentialTransition.play();
//        tok.setDes(getDeliver());
//        tok.setPos(this, getDeliver());
    }

    public void set(Token tok)
    {
        tok.setDes(getDeliver());
        tok.setPos(getDeliver());
//        Game.unfreeze_dice();
//        Game.reset_prompt(this);
//        Game.setNext_chance(this);
//        Game.prompt(this);
    }
//    public void deliver(Token tok)
//    {
//        tok.getBt().setTranslateX(getDeliver().getX()-tok.getOg().getX());
//        tok.getBt().setTranslateY(getDeliver().getY()-tok.getOg().getY());
//
//        tok.setPos(this, getDeliver());
//    }
}
