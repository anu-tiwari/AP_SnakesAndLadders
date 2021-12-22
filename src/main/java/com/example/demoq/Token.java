package com.example.demoq;

import javafx.animation.PathTransition;
import javafx.animation.PauseTransition;
import javafx.animation.SequentialTransition;
import javafx.application.Platform;
import javafx.scene.control.Button;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.util.Duration;

import java.util.ArrayList;

public class Token
{
    Cell pos;
    Button bt;
    Cell og;
    Cell des;
    ArrayList<Cell> cells;
    boolean encounter;

    Token(Button b, Cell org)
    {
        bt = b;
        og = org;
        pos = og;
        cells = HelloController.getCells();
        encounter = false;
    }

    public Button getBt() {
        return bt;
    }

    public Cell getPos() {
        return pos;
    }

    public void setPos(Cell p)
    {
        pos = p;
    }

    public void setDes(Cell d)
    {
        des = d;
    }

//    public void move(int dice_value)
//    {
        //int new_val = pos.getValue() + dice_value;
//        if (des.getValue()>100)
//            return;
//        for (int i= pos.getValue(); i<=new_val-1; i++)
//        {
//            bt.setTranslateX(cells.get(i).getX()-og.getX());
//            bt.setTranslateY(cells.get(i).getY()-og.getY());
//        }
        //des = cells.get(new_val-1);
        //System.out.println("des is "+des.getValue());
        //walk_steps();
//        bt.setTranslateX(cells.get(new_val-1).getX()-og.getX());
//        bt.setTranslateY(cells.get(new_val-1).getY()-og.getY());
//        pos = cells.get(new_val-1);
//    }

    public void move(int dice_value)
    {
        if (des.getValue()>100)
            return;
        while(!pos.equals(cells.get(des.getValue()-1)))
        {
            //System.out.println(pos.equals(des));
            //System.out.println("in walk  steps look pos is "+pos.getValue());
            try{
                Thread.sleep(250);
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
            //System.out.println("before run later"+pos.equals(des));
            //System.out.println("doing run later");
            Platform.runLater(new Step_Walk(this));
        }
//        if (pos.getValue()==des.getValue())
//        {
//            if (pos.isSnakeMouth() || pos.isLadderLow()) {
//                System.out.println("fetching snake or ladder");
//                setDes(HelloController.getSandL().get(pos).getDeliver());
//                encounter = true;
//                HelloController.getSandL().get(pos).move(this);
//                Snake_Ladder sandl= HelloController.getSandL().get(pos);
//                Path path = new Path();
//                path.getElements().add(new MoveTo((sandl.getTrap().getX()+20.0)-getOg().getX(), (sandl.getTrap().getY()+20.0)-getOg().getY()));
//                path.getElements().add(new LineTo((sandl.getDeliver().getX()+20.0)-getOg().getX(), (sandl.getDeliver().getY()+20.0)-getOg().getY()));
//
//                PathTransition pathTransition = new PathTransition();
//
//                pathTransition.setDuration(Duration.millis(1000));
//                pathTransition.setNode(getBt());
//                pathTransition.setPath(path);
//                pathTransition.setCycleCount(1);
//                pathTransition.setAutoReverse(false);
                //pathTransition.setOnFinished(new EventHandler<ActionEvent>() {

//        pathTransition.setOnFinished(e -> {
//             set(tok);});
//        pathTransition.play();
//                PauseTransition pauseTransition = new PauseTransition(Duration.millis(2000));
//                SequentialTransition sequentialTransition = new SequentialTransition(pathTransition, pauseTransition);
//                sequentialTransition.setOnFinished(e -> {
//                    setDes(sandl.getDeliver());
//                    setPos(sandl.getDeliver());});
//                sequentialTransition.play();
//                pathTransition.setOnFinished(e -> { setDes(sandl.getDeliver());
//                    setPos(this, sandl.getDeliver());});
            //}
        //}
//        if (pos.getValue()==des.getValue())
//        {
//            Game.unfreeze_dice();
//            Game.reset_prompt(this);
//            Game.setNext_chance(this);
//            Game.prompt(this);
//        }
        pos = des;
        System.out.println("pos just assigned as "+pos.getValue());

//        if (pos.isSnakeMouth() || pos.isLadderLow())
//            HelloController.getSandL().get(pos).move(this);
    }

    public void start()
    {
        bt.setTranslateX(cells.get(0).getX() - og.getX());
        bt.setTranslateY(cells.get(0).getY() - og.getY());
        pos = cells.get(0);
        System.out.println("started at pos "+pos.getValue());
    }

    public Cell getDes() {
        return des;
    }

    public Cell getOg()
    {
        return og;
    }

    public void one_step()
    {
        if (pos.getValue()==des.getValue()) {
            Game.unfreeze_dice();
            Game.reset_prompt(this);
            Game.setNext_chance(this);
            Game.prompt(this);
            return;
        }
//        if (pos.getValue()==des.getValue() && encounter)
//            return;
//        if (encounter)
//            return;
        //System.out.println("translating to  "+cells.get(getPos().getValue()).getValue());
        bt.setTranslateX(cells.get(getPos().getValue()).getX() - og.getX());
        bt.setTranslateY(cells.get(getPos().getValue()).getY() - og.getY());
        pos = cells.get(getPos().getValue());
        System.out.println("in one step new pos is "+pos.getValue());
        System.out.println("in one step des is "+des.getValue());
        if (pos.getValue()==des.getValue()) {
            if (pos.isSnakeMouth() || pos.isLadderLow()) {
                System.out.println("fetching snake or ladder");
                //setDes(HelloController.getSandL().get(pos).getDeliver());
                HelloController.getSandL().get(pos).move(this);
            }
        }
//                HelloController.getSandL().get(pos).move(this);
////                Snake_Ladder sandl= HelloController.getSandL().get(pos);
////                Path path = new Path();
////                path.getElements().add(new MoveTo((sandl.getTrap().getX()+20.0)-getOg().getX(), (sandl.getTrap().getY()+20.0)-getOg().getY()));
////                path.getElements().add(new LineTo((sandl.getDeliver().getX()+20.0)-getOg().getX(), (sandl.getDeliver().getY()+20.0)-getOg().getY()));
////
////                PathTransition pathTransition = new PathTransition();
////
////                pathTransition.setDuration(Duration.millis(1000));
////                pathTransition.setNode(getBt());
////                pathTransition.setPath(path);
////                pathTransition.setCycleCount(1);
////                pathTransition.setAutoReverse(false);
//                //pathTransition.setOnFinished(new EventHandler<ActionEvent>() {
//
////        pathTransition.setOnFinished(e -> {
////             set(tok);});
////        pathTransition.play();
////                PauseTransition pauseTransition = new PauseTransition(Duration.millis(2000));
////                SequentialTransition sequentialTransition = new SequentialTransition(pathTransition, pauseTransition);
////                sequentialTransition.setOnFinished(e -> {
////                    setDes(sandl.getDeliver());
////                    setPos(sandl.getDeliver());});
////                sequentialTransition.play();
////                pathTransition.setOnFinished(e -> { setDes(sandl.getDeliver());
////                    setPos(this, sandl.getDeliver());});
//            }
//        }
        if(pos.getValue()==100)
        {
            Game.win(this);
        }
    }

//    public void send_to_SandL()
//    {
//        HelloController.getSandL().get(pos).move(this);
//    }

    public void reset()
    {
        bt.setTranslateX(0.0);
        bt.setTranslateY(0.0);
        pos = og;
    }
}
