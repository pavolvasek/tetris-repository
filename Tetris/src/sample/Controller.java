package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Rectangle;

import java.lang.reflect.Array;
import java.net.URL;
import java.util.*;

public class Controller implements Initializable {
    public int count;

    @FXML
    public Button leftButton;
    public Button rightButton;
    public Button downButton;
    public Rectangle myRectangle;
    public Rectangle myRectangle1;
    public Rectangle myRectangle2;
    public Rectangle myRectangle3;
    public Rectangle myRectangle4;
    public Rectangle myRectangle5;
    public Rectangle myRectangle6;
    public Rectangle myRectangle7;
    public Rectangle myRectangle8;
    public Rectangle myRectangle9;
    public Rectangle myRectangle10;
    public Rectangle myRectangle11;
    public Rectangle myRectangle12;
    public Rectangle myRectangle13;
    public Rectangle myRectangle14;
    public Rectangle myRectangle15;
    public Rectangle myRectangle16;
    public Rectangle myRectangle17;
    public Rectangle myRectangle18;
    public Rectangle myRectangle19;
    public Rectangle myRectangle20;
    public Rectangle myRectangle21;
    public Rectangle myRectangle22;
    public Rectangle myRectangle23;
    public Rectangle myRectangle24;

    public Label levelText;
    public Label scoreText;
    public ArrayList<Integer> score;
    public ArrayList<Rectangle> listRectangles;
    public ArrayList<Rectangle> presentRectangles;
    public ArrayList<Double> coordinatesY;


    public Controller() {
        presentRectangles = new ArrayList<>();
        coordinatesY = new ArrayList<>();
        score = new ArrayList<>();

    }

    public ArrayList<Rectangle> getListRectangles() {
        listRectangles = new ArrayList<>();
        listRectangles.add(myRectangle);
        listRectangles.add(myRectangle1);
        listRectangles.add(myRectangle2);
        listRectangles.add(myRectangle3);
        listRectangles.add(myRectangle4);
        listRectangles.add(myRectangle5);
        listRectangles.add(myRectangle6);
        listRectangles.add(myRectangle7);
        listRectangles.add(myRectangle8);
        listRectangles.add(myRectangle9);
        listRectangles.add(myRectangle10);
        listRectangles.add(myRectangle11);
        listRectangles.add(myRectangle12);
        listRectangles.add(myRectangle13);
        listRectangles.add(myRectangle14);
        listRectangles.add(myRectangle15);
        listRectangles.add(myRectangle16);
        listRectangles.add(myRectangle17);
        listRectangles.add(myRectangle18);
        listRectangles.add(myRectangle19);
        listRectangles.add(myRectangle20);
        listRectangles.add(myRectangle21);
        listRectangles.add(myRectangle22);
        listRectangles.add(myRectangle23);
        listRectangles.add(myRectangle24);

        return listRectangles;
    }



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }


    @FXML


    public void moveLeft(ActionEvent actionEvent) {
        Rectangle r1 = myRectangle;
        double x = r1.getLayoutX();
        if(x > 0 && !stopRectangle()) {
            if (detectRectangle(myRectangle)) {
                r1.setLayoutX(x);
                //System.out.println(x);
                x = 500;

            }
            x -= 33;
            r1.setLayoutX(x);
            //System.out.println(x);

        }
    }

    public void moveRight(ActionEvent actionEvent) {
        Rectangle r1 = myRectangle;
        double x = r1.getLayoutX();
        if (x < 330 && !stopRectangle()) {
            if (detectRectangle(myRectangle)) {
                r1.setLayoutX(x);
                x = 500;
            }
            x += 33;
            r1.setLayoutX(x);

        }
    }


    public void moveDown() {
        Rectangle r1 = myRectangle;
        double y = r1.getLayoutY();
        if (y < 442 && !stopRectangle()) {
            if (detectRectangle(myRectangle)) {

                r1.setLayoutY(y);
                y = 500;



            }

            y += 11.05;
            //System.out.println(y);
            r1.setLayoutY(y);

        }

        if (Math.round(y) == 442) {
            generateRectangle();
        }
        if (detectRectangle(myRectangle)) {
            generateRectangle();
        }


    }

    public boolean detectRectangle(Rectangle r) {

        for (int i = 0; i < presentRectangles.size(); i++) {
            if (Math.round(presentRectangles.get(i).getLayoutY()) == Math.round(r.getLayoutY() + 33.15) && presentRectangles.get(i).getLayoutX() == Math.round(r.getLayoutX())) {
                return true;
            }
        }

        return false;
    }

    public boolean stopRectangle() {
        Rectangle r1 = myRectangle;

        if (Math.round(r1.getLayoutY()) == 442 || detectRectangle(myRectangle) || Math.round(r1.getLayoutX()) == 414 || Math.round(r1.getLayoutY()) == 333) {
            generateRectangle();
            return true;
        }

        return false;

    }

    public void generateRectangle() {
        score.add(10);
        //if (blickFunction()) {
            //score.add(1000);
        //}
        scoreCounter();
        //System.out.println(score);
        ArrayList<Integer> random_numbersX = new ArrayList<>();
        for (int x = 0; x <= 330; x+= 33) {
            random_numbersX.add(x);
        }
        Random random = new Random();
        int x = random.nextInt(10);

        count++;
        presentRectangles.add(myRectangle);
        coordinatesY.add(myRectangle.getLayoutY());
        blickFunction();
        System.out.println(coordinatesY);
        myRectangle = getListRectangles().get(count);
        Rectangle r1 = myRectangle;


        r1.setHeight(33);
        r1.setWidth(33);
        r1.setLayoutX(random_numbersX.get(x));
        r1.setLayoutY(0);

    }


    public boolean blickFunction() {
        int countr = 0;

        Collections.sort(coordinatesY);

        if (coordinatesY.size() > 10) {
            for (int i = 0; i < coordinatesY.size()-1; i++) {

                if (Math.round(coordinatesY.get(i)) == Math.round(coordinatesY.get(i+1))) {
                    countr++;
                    double p = coordinatesY.get(i);
                    ArrayList<Rectangle> tempRectangles = new ArrayList<>();
                    ArrayList<Double> tempcoordinatesY = new ArrayList<>();
                    if (countr == 10) {
                        score.add(1000);
                        scoreCounter();
                        for (int v = 0; v < presentRectangles.size(); v++) {
                            System.out.println(Math.round(presentRectangles.get(v).getLayoutY()));
                            System.out.println(Math.round(p));
                            if (Math.round(presentRectangles.get(v).getLayoutY()) == Math.round(p)) {
                                presentRectangles.get(v).setLayoutX(414);
                                presentRectangles.get(v).setLayoutY(333);
                            }
                            else if (Math.round(presentRectangles.get(v).getLayoutY()) != Math.round(p)) {
                                tempRectangles.add(presentRectangles.get(v));
                                tempcoordinatesY.add(presentRectangles.get(v).getLayoutY()+33.15);

                            }
                        }
                        presentRectangles = tempRectangles;
                        System.out.println(presentRectangles);


                        for (int u = 0; u < presentRectangles.size(); u++) {
                            double k = 0;
                            k = presentRectangles.get(u).getLayoutY() + 33.15;
                            presentRectangles.get(u).setLayoutY(k);
                            //tempcoordinatesY.add(presentRectangles.get(u).getLayoutY());
                            System.out.println(tempcoordinatesY);
                            System.out.println(coordinatesY);

                        }
                        coordinatesY = tempcoordinatesY;
                        System.out.println(coordinatesY);
                        return true;


                    }
                }
                if (Math.round(coordinatesY.get(i)) != Math.round(coordinatesY.get(i+1))) {
                    countr = 0;
                }
            }
        }


        return false;


    }








    public void scoreCounter() {
        int scoret = 0;
        for (int i = 0; i < score.size(); i++) {
            scoret += score.get(i);
        }
        scoreText.setText(String.valueOf(scoret));


    }

    public void levelIndicator() {

    }


}
