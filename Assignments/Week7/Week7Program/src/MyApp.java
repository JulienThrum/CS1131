import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;
import java.io.File;

public class MyApp extends Application {
    /**
     * The start method. Required by Application
     *
     * @param stage
     */
    public void start(Stage stage) {
        Parameters params = getParameters();
        List<String> parameters = params.getRaw();

        File file = new File(!parameters.isEmpty() ? parameters.get(0) : "");
        Scanner fin = null;
        Group root = new Group();
        Scene scene = null;
        Circle circle = null;
        Line line = null;
        Text text = null;
        Rectangle rectangle = null;
        int counter = 0;
        String s;

        try(Scanner scanner = new Scanner(file)) {
            fin = new Scanner(file);
            while(fin.hasNext()) {
                s = fin.next();
                if(s.equals("SIZE")) {
                    scene = new Scene(root, fin.nextInt(), fin.nextInt());
                    scene.setFill(Color.BLACK);
                } else if(s.equals("CIRCLE")) {
                    circle = new Circle(fin.nextDouble(), fin.nextDouble(), fin.nextDouble());
                    circle.setFill(Color.BLACK);
                    circle.setStroke(Color.GREEN);
                    circle.setStrokeWidth(1.5);
                    root.getChildren().add(circle);
                } else if(s.equals("LINE")) {
                    line = new Line(fin.nextDouble(), fin.nextDouble(), fin.nextDouble(), fin.nextDouble());
                    line.setStroke(Color.GREEN);
                    line.setStrokeWidth(1.5);
                    root.getChildren().add(line);
                } else if(s.equals("RECTANGLE")) {
                    rectangle = new Rectangle(fin.nextDouble(), fin.nextDouble(), fin.nextDouble(), fin.nextDouble());
                    rectangle.setStroke(Color.GREEN);
                    rectangle.setStrokeWidth(1.5);
                    root.getChildren().add(rectangle);
                } else if(s.equals("TEXT")) {
                    text = new Text(fin.nextDouble(), fin.nextDouble(), fin.nextLine());
                    text.setStroke(Color.GREEN);
                    root.getChildren().add(text);
                } else if(s.equals("//")){
                    fin.nextLine();
                } else if(s.equals("END")) {
                    break;
                }
            }
        } catch(FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if(fin != null) {
                fin.close();
            }
        }

        stage.setTitle("My JavaFX Application");
        stage.setScene(scene);
        stage.show();
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
