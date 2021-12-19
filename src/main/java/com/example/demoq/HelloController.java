package com.example.demoq;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.geometry.Bounds;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class HelloController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    public ImageView board;

    @FXML
    public Button token2;

    @FXML
    public Button dice;

    @FXML
    public ImageView dice_img;

    @FXML
    public Label diceval;

    @FXML
    private Button token1;

//    @FXML
//    private ImageView img;

    @FXML
    private Label locval;

    private Game game;

    private ArrayList<Cell> cells;

    private Cell P1_start;
    private Cell P2_start;

    double x;
    double y;
    double curr_x;
    double curr_y;

    int i;

    @FXML
    void move(MouseEvent event)
    {
        token1.setTranslateX(x-curr_x);
        token1.setTranslateY(y-curr_y);
//        curr_x = x;
//        curr_y = y;
    }

    @FXML
    void findloc(MouseEvent event)
    {
        locval.setText("Move to X:"+ event.getSceneX() +"Y:"+ event.getSceneY());
        x = event.getSceneX();
        y = event.getSceneY();
        System.out.println("X: "+x+"Y: "+y);
    }
    @FXML
    void initialize() {
        //locval.setText("Hey");
        //dice_img = new ImageView(new Image(getClass().getResource("one_dice.jpg"), true));
        Image img = new Image(new File("one_dice.jpg").toURI().toString(), true);
        System.out.println(getClass().getResource("one_dice.jpg"));
//        dice_img.setImage(img);
        //<ImageView fx:id="dice_img" fitHeight="85.0" fitWidth="81.0" layoutX="243.0" layoutY="713.0" preserveRatio="true" style="-fx-background-radius: 5px" />
        i=0;
        initialise_cells();
        game = new Game(token1, token2, P1_start, P2_start, dice, dice_img);
        x = 0;
        y = 0;
        Bounds bis = token1.localToScene(token1.getBoundsInLocal());
        curr_x = bis.getMinX();
        curr_y = bis.getMinY();
    }

    public void initialise_cells()
    {
        ArrayList<Double> X = new ArrayList<>();
        X.add(60.0);
        X.add(106.0);
        X.add(152.0);
        X.add(197.0);
        X.add(243.0);
        X.add(288.0);
        X.add(334.0);
        X.add(380.0);
        X.add(425.0);
        X.add(470.0);

        ArrayList<Double> Y = new ArrayList<>();
        Y.add(631.0);
        Y.add(568.0);
        Y.add(504.0);
        Y.add(437.0);
        Y.add(373.0);
        Y.add(305.0);
        Y.add(241.0);
        Y.add(176.0);
        Y.add(110.0);
        Y.add(47.0);

        cells = new ArrayList<>();

    }
    public void playDice(MouseEvent mouseEvent) {
        i++;
        game.rollDice();
        diceval.setText("Dice clicked"+i+"times");
    }
}

//class rotor{
//    Button bb;
//    int state;
//    rotor(Button bb){
//        this.bb=bb;
//        this.state=0;
//    }
//    void rotate(){bb.setRotate(bb.getRotate()+30);}
//    void stop_rotation(){ state=0;}
//    void allow_rotation(){ state=1;}
//}
//
//class rotator{
//    Button hb;
//    rotator(Button hb){
//        this.hb=hb;
//    }
//    public void keep_rotating(rotor rtr, display dsp){
//        while(true){
//            if (rtr.state==1){//The idea is to allow rotor rotation as long as the rotor state is 1.
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                Platform.runLater(new Runnable2(rtr,dsp));
//            }else{break;}
//        }
//    }
//}
//
//class display{
//    Label wt;
//    display(Label wt,String s){
//        this.wt=wt;
//        wt.setText(s);
//    }
//    void display_current(String s){wt.setText(s);}
//}
//
//class myth extends Thread{
//    rotator rtt;
//    rotor rtr;
//    display dsp;
//    myth(rotator rtt, rotor rtr, display dsp){
//        this.rtr=rtr;
//        this.rtt=rtt;
//        this.dsp=dsp;
//    }
//    @Override
//    public void run(){
//        rtt.keep_rotating(rtr,dsp);
//    }
//}
//
//class Runnable2 implements Runnable{
//    rotor rtr;
//    display dsp;
//    Runnable2(rotor rtr, display dsp){
//        this.rtr=rtr;
//        this.dsp=dsp;
//    }
//    @Override
//    public void run() {
//        rtr.rotate();
//        dsp.display_current("Rotated "+rtr.bb.getRotate()+" degrees so far.");
//    }
//}