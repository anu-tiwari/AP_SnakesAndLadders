package com.example.demoq;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.ResourceBundle;
import javafx.geometry.Bounds;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Rectangle;

public class HelloController {

    @FXML
    public Rectangle p1_label;

    @FXML
    public Rectangle p2_label;

    @FXML
    public Rectangle p1_top;

    @FXML
    public Rectangle p2_top;

    @FXML
    public Rectangle p1_bottom;

    @FXML
    public Rectangle p2_bottom;

    @FXML
    public Rectangle p2_bg;

    @FXML
    public Rectangle p1_bg;

    @FXML
    public Label P1_disname;

    @FXML
    public Label P2_disname;

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

    private static ArrayList<Cell> cells;
    private static HashMap<Cell, Snake_Ladder> SandL;

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
//        Image img = new Image(new File("images/one_dice.jpg").toURI().toString(), true);
//        System.out.println(getClass().getResource("images/one_dice.jpg"));
//        dice_img.setImage(img);
        //<ImageView fx:id="dice_img" fitHeight="85.0" fitWidth="81.0" layoutX="243.0" layoutY="713.0" preserveRatio="true" style="-fx-background-radius: 5px" />
        i=0;
        initialise_cells();
        initialise_s_l();
        game = new Game(token1, token2, P1_start, P2_start, dice, dice_img, p1_label, p2_label, p1_top, p2_top, p1_bottom, p2_bottom, p1_bg, p2_bg, P1_disname, P2_disname, P1_start, P2_start);
        x = 0;
        y = 0;
        Bounds bis = token1.localToScene(token1.getBoundsInLocal());
        curr_x = bis.getMinX();
        curr_y = bis.getMinY();
    }

    public void initialise_s_l()
    {
        SandL = new HashMap<>();

        SandL.put(cells.get(23), new Snake(cells.get(23), cells.get(4)));
        cells.get(23).setSnakeMouth(true);
        SandL.put(cells.get(42), new Snake(cells.get(42), cells.get(21)));
        cells.get(42).setSnakeMouth(true);
        SandL.put(cells.get(59), new Snake(cells.get(59), cells.get(41)));
        cells.get(59).setSnakeMouth(true);
        SandL.put(cells.get(55), new Snake(cells.get(55), cells.get(24)));
        cells.get(55).setSnakeMouth(true);
        SandL.put(cells.get(68), new Snake(cells.get(68), cells.get(47)));
        cells.get(68).setSnakeMouth(true);
        SandL.put(cells.get(89), new Snake(cells.get(89), cells.get(71)));
        cells.get(89).setSnakeMouth(true);
        SandL.put(cells.get(85), new Snake(cells.get(85), cells.get(52)));
        cells.get(85).setSnakeMouth(true);
        SandL.put(cells.get(93), new Snake(cells.get(93), cells.get(72)));
        cells.get(93).setSnakeMouth(true);
        SandL.put(cells.get(95), new Snake(cells.get(95), cells.get(83)));
        cells.get(95).setSnakeMouth(true);
        SandL.put(cells.get(97), new Snake(cells.get(97), cells.get(57)));
        cells.get(97).setSnakeMouth(true);

        SandL.put(cells.get(2), new Ladder(cells.get(2), cells.get(20)));
        cells.get(2).setLadderLow(true);
        SandL.put(cells.get(7), new Ladder(cells.get(7), cells.get(45)));
        cells.get(7).setLadderLow(true);
        SandL.put(cells.get(15), new Ladder(cells.get(15), cells.get(25)));
        cells.get(15).setLadderLow(true);
        SandL.put(cells.get(28), new Ladder(cells.get(28), cells.get(32)));
        cells.get(28).setLadderLow(true);
        SandL.put(cells.get(36), new Ladder(cells.get(36), cells.get(64)));
        cells.get(36).setLadderLow(true);
        SandL.put(cells.get(49), new Ladder(cells.get(49), cells.get(69)));
        cells.get(49).setLadderLow(true);
        SandL.put(cells.get(63), new Ladder(cells.get(63), cells.get(76)));
        cells.get(63).setLadderLow(true);
        SandL.put(cells.get(60), new Ladder(cells.get(60), cells.get(81)));
        cells.get(60).setLadderLow(true);
        SandL.put(cells.get(75), new Ladder(cells.get(75), cells.get(94)));
        cells.get(75).setLadderLow(true);
        SandL.put(cells.get(88), new Ladder(cells.get(88), cells.get(90)));
        cells.get(88).setLadderLow(true);
    }

    public void initialise_cells()
    {
        P1_start = new Cell(-1, 54.0, 696.0);
        P2_start = new Cell(-2, 80.0, 696.0);

        ArrayList<Double> X = new ArrayList<>();
        X.add(68.0);
        X.add(115.0);
        X.add(160.0);
        X.add(207.0);
        X.add(251.0);
        X.add(296.0);
        X.add(342.0);
        X.add(388.0);
        X.add(433.0);
        X.add(478.0);

        ArrayList<Double> Y = new ArrayList<>();
        Y.add(638.0);
        Y.add(573.0);
        Y.add(509.0);
        Y.add(442.0);
        Y.add(378.0);
        Y.add(313.0);
        Y.add(246.0);
        Y.add(182.0);
        Y.add(115.0);
        Y.add(52.0);

        cells = new ArrayList<>();
        int Xcoor, Ycoor;

        for (int i = 1; i <= 100; i++)
        {
            if (i % 10 == 0)                        //Y can directly access arraylist
                Ycoor = (i / 10) - 1;
            else
                Ycoor = i / 10;

            if ((i <= 10) || (i >= 21 && i <= 30) || (i >= 41 && i <= 50) || (i >= 61 && i <= 70) || (i >= 81 && i <= 90))
            {
                Xcoor = i % 10;
                Xcoor--;
                if (Xcoor == -1)
                    Xcoor = 9;
            }
            else
            {
                Xcoor = 10 - i % 10;
                if (Xcoor == 10)
                    Xcoor = 0;
            }
            cells.add(new Cell(i, X.get(Xcoor), Y.get(Ycoor)));
        }

        for (Cell cell: cells)
        {
            System.out.println("Cell: "+cell.getValue()+" X: "+cell.getX()+" Y: "+cell.getY());
        }
    }

    public void playDice(MouseEvent mouseEvent) {
        i++;
        game.rollDice();
        diceval.setText("Dice clicked"+i+"times");
    }

    public static ArrayList<Cell> getCells() {
        return cells;
    }

    public static HashMap<Cell, Snake_Ladder> getSandL() {
        return SandL;
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