import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Chapter14 extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        String[] print = "WELCOME TO JAVA ".split("");
        Pane pane1 = new Pane();
        Text text1 = null;
        double angle;
        double x;
        double y;
        double k;
        for(int i = 0; i < print.length; i++) {
            k = (2 * Math.PI) * ((double) i / print.length);
            x = 250 + 100 * Math.cos(k);
            y = 250 + 100 * Math.sin(k);
            text1 = new Text(x, y, (String) print[i]);
            text1.setRotate(90 + Math.toDegrees((2 * Math.PI) * ((double) i / print.length)));

            text1.setFont(Font.font("Courier", FontWeight.BOLD, FontPosture.REGULAR, 20));
            pane1.getChildren().add(text1);
        }

        Scene scene1 = new Scene(pane1, 500, 500);
        primaryStage.setTitle("Welcome To Java Circle");
        primaryStage.setScene(scene1);
        primaryStage.show();

        Pane pane = new Pane();

        //add rectangles
        Rectangle top = new Rectangle(50, 50, 250, 125);
        Rectangle bottom = new Rectangle(100, 100, 250, 125);
        top.setFill(Color.TRANSPARENT);
        top.setStroke(Color.BLACK);
        bottom.setFill(Color.TRANSPARENT);
        bottom.setStroke(Color.BLACK);
        top.widthProperty().bind(pane.widthProperty().divide(2));
        top.heightProperty().bind(pane.heightProperty().divide(2));
        bottom.widthProperty().bind(pane.widthProperty().divide(2));
        bottom.heightProperty().bind(pane.heightProperty().divide(2));

        //add lines
        Line lt = new Line(50, 50, 100, 100);
        Line lb = new Line(50, 50 + 250, 100, 100 + 250);
        Line rt = new Line(50 + 250, 50, 100 + 250, 100);
        Line rb = new Line(50 + 250, 50 + 250, 100 + 250, 100 + 250);

        pane.getChildren().addAll(top, bottom, lt, lb, rt, rb);
        Scene scene = new Scene(pane, 500, 500);
        Stage stage = new Stage();
        stage.setTitle("Matrix");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
