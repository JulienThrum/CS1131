
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Lab8Problem3 extends Application {
    /**
     * The start method. Required by Application
     *
     * @param args
     */
    //ArrayList<Node> nodes = new ArrayList<>();

    Group root = new Group();
    Scene scene = new Scene(root, 500, 500, Color.BLACK);

    public void start(Stage stage) {

        drawEllipses();

        stage.setTitle("My JavaFX Application");
        stage.setScene(scene);

        stage.show();
    }


    public void drawEllipses() {

        for (int y = 0, x = 0; y < 250; y += 10, x += 10) {

            Ellipse a = new Ellipse(250, 250, 250 - y, y);
            a.setStroke(Color.GREEN);
            a.setFill(Color.TRANSPARENT);
            root.getChildren().add(a);
            Ellipse b = new Ellipse(250,250, x, 250 - x);
            b.setStroke(Color.GREEN);
            b.setFill(Color.TRANSPARENT);
            root.getChildren().add(b);
        }


    }


    /**
     * The main method
     *
     * @param args
     */
    public static void main(String[] args) {
        launch(args);
    }
}

