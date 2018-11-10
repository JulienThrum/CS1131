import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.stage.Stage;


public class Lab8Problem2 extends Application {

    public Line createLine(double x1, double y1, double x2, double y2){
        Line line = new Line(x1,y1,x2,y2);
        line.setStroke(Color.rgb(127, 244, 16));
        line.setStrokeWidth(1);
        return line;
    }

    public void start(Stage stage){
        Group root = new Group();

        Scene scene = new Scene(root,200,200);

        double x1 = (scene.getWidth())/2;
        for(int i = 0; i <= scene.getHeight()/2; i+=5){
            Line linea = createLine(x1, 0+i, x1-i, 100);
            Line lineb = createLine(x1,0+i,x1+i, 100);
            Line linec = createLine(x1, 200-i, x1-i, 100);
            Line lined = createLine(x1, 200-i, x1+i, 100);
            root.getChildren( ).addAll(linea,lineb,linec,lined);
        }
        scene.setFill(Color.BLACK);
        stage.setTitle("My JavaFX Application");
        stage.setScene(scene);
        stage.show();
    }
    public static void main(String[] args){
        launch(args);
    }
}
