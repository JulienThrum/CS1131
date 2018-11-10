import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 * @author Julien Thrum
 */
public class Snake extends Application {
    double speed = 55; //refresh rate in millis for timelines

    enum Direction {kLeft, kUp, kDown, kRight}

    @Override
    public void start(Stage primaryStage) throws Exception {
        //setup menu
        BorderPane menuRoot = new BorderPane();
        Scene menuScene = new Scene(menuRoot, 500, 300);
        HBox buttonLayout = new HBox();
        buttonLayout.setAlignment(Pos.CENTER);
        Button classicMode = new Button("Classic");
        Button multiMode = new Button("Multiplayer");
        Button PCMode = new Button("ComputerSnake");
        buttonLayout.getChildren().addAll(classicMode, multiMode, PCMode);
        buttonLayout.setSpacing(10);
        menuRoot.setCenter(buttonLayout);

        classicMode.setOnMouseClicked(e -> {
            ClassicSnake classicObj = new ClassicSnake(speed);
            classicObj.playClassicMode(primaryStage);
        });

        multiMode.setOnMouseClicked(e -> {
            MultiplayerSnake multiObj = new MultiplayerSnake(speed);
            multiObj.playMultiMode(primaryStage);
        });

        PCMode.setOnMouseClicked(e->{
            ComputerSnake PCObj = new ComputerSnake(speed);
            PCObj.playComputerMode(primaryStage);
        });

        primaryStage.setScene(menuScene);
        primaryStage.setTitle("Snake Game Menu");
        primaryStage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
