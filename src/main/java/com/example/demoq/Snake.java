package com.example.demoq;

import javafx.animation.PathTransition;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.util.Duration;

public class Snake extends Snake_Ladder
{
    Snake(Cell T, Cell D) {
        super(T, D);
    }

    @Override
    public void move(Token tok) {
        Path path = new Path();
        path.getElements().add(new MoveTo((getTrap().getX()+20.0)-tok.getOg().getX(), (getTrap().getY()+20.0)-tok.getOg().getY()));
        path.getElements().add(new LineTo((getDeliver().getX()+20.0)-tok.getOg().getX(), (getDeliver().getY()+20.0)-tok.getOg().getY()));

        PathTransition pathTransition = new PathTransition();

        pathTransition.setDuration(Duration.millis(250));
        pathTransition.setNode(tok.getBt());
        pathTransition.setPath(path);
        pathTransition.setCycleCount(1);
        pathTransition.setAutoReverse(false);
        pathTransition.setOnFinished(e -> {
            set(tok);});
        pathTransition.play();
    }

    public void set(Token tok)
    {
        tok.setDes(getDeliver());
        tok.setPos(getDeliver());
    }
}
