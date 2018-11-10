import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class Chapter15 extends Application {
    private int x = 300;
    private int y = 200;
    private Circle c;

    @Override
    public void start(Stage primaryStage) throws Exception {
        BorderPane root = new BorderPane();

        Button left = new Button("Left");
        Button up = new Button("Up");
        Button down = new Button("Down");
        Button right = new Button("Right");

        c = new Circle(x, y, 20);
        c.setStroke(Color.BLACK);
        c.setFill(Color.TRANSPARENT);
        root.getChildren().add(c);

        left.setOnAction(e -> {
            root.getChildren().remove(c);
            if(!(x <= 20)) {
                x -= 5;
            }
            c = new Circle(x, y, 20);
            root.getChildren().add(c);
            c.setStroke(Color.BLACK);
            c.setFill(Color.TRANSPARENT);
        });

        up.setOnAction(e -> {
            root.getChildren().remove(c);
            if(!(y <= 20)) {
                y -= 5;
            }
            c = new Circle(x, y, 20);
            c.setStroke(Color.BLACK);
            c.setFill(Color.TRANSPARENT);
            root.getChildren().add(c);
        });

        down.setOnAction(e -> {
            root.getChildren().remove(c);
            if(!(y >= root.getHeight() - 20)) {
                y += 5;
            }
            c = new Circle(x, y, 20);
            c.setStroke(Color.BLACK);
            c.setFill(Color.TRANSPARENT);
            root.getChildren().add(c);
        });

        right.setOnAction(e -> {
            root.getChildren().remove(c);
            if(!(x >= root.getWidth() - 20)) {
                x += 5;
            }
            c = new Circle(x, y, 20);
            c.setStroke(Color.BLACK);
            c.setFill(Color.TRANSPARENT);
            root.getChildren().add(c);
        });

        HBox hBox = new HBox();
        hBox.getChildren().addAll(left, up, down, right);
        hBox.setAlignment(Pos.CENTER);
        hBox.setSpacing(7);

        root.setBottom(hBox);

        Scene scene = new Scene(root, 600, 400);
        primaryStage.setTitle("Chapter15");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
