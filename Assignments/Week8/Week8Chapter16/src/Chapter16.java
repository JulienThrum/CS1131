import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class Chapter16 extends Application {
    private int x = 0;

    @Override
    public void start(Stage primaryStage) throws Exception {
        BorderPane root = new BorderPane();

        //make radio buttons and put them in an HBox and toggleGroup
        RadioButton redButton = new RadioButton("Red");
        RadioButton yellowButton = new RadioButton("Yellow");
        RadioButton blackButton = new RadioButton("Black");
        RadioButton orangeButton = new RadioButton("Orange");
        RadioButton greenButton = new RadioButton("Green");

        ToggleGroup group = new ToggleGroup();
        redButton.setToggleGroup(group);
        yellowButton.setToggleGroup(group);
        blackButton.setToggleGroup(group);
        orangeButton.setToggleGroup(group);
        greenButton.setToggleGroup(group);

        HBox buttons = new HBox();
        buttons.setAlignment(Pos.CENTER);
        buttons.getChildren().addAll(redButton, yellowButton, blackButton, orangeButton, greenButton);

        root.setTop(buttons);

        //make text
        Rectangle box = new Rectangle(0, 25, 1000, 140);
        box.setFill(Color.TRANSPARENT);
        box.setStroke(Color.BLACK);

        Text text = new Text(325, 100, "Programming is fun");
        text.setFont(Font.font(36));
        root.getChildren().add(text);
        root.getChildren().add(box);

        //make moving buttons
        Button left = new Button("<=");
        Button right = new Button("=>");
        HBox sideToSide = new HBox();
        sideToSide.getChildren().addAll(left, right);
        sideToSide.setAlignment(Pos.CENTER);
        root.setBottom(sideToSide);

        //set actions from buttons
        left.setOnAction(e -> {
            x -= 10;
            text.setLayoutX(x);
        });

        right.setOnAction(e->{
            x += 10;
            text.setLayoutX(x);
        });

        redButton.setOnAction(e -> {
            text.setFill(Color.RED);
        });

        yellowButton.setOnAction(e -> {
            text.setFill(Color.YELLOW);
        });

        blackButton.setOnAction(e -> {
            text.setFill(Color.BLACK);
        });

        orangeButton.setOnAction(e -> {
            text.setFill(Color.ORANGE);
        });

        greenButton.setOnAction(e -> {
            text.setFill(Color.GREEN);
        });

        Scene scene = new Scene(root, 1000, 200);
        primaryStage.setTitle("Chapter 16");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
