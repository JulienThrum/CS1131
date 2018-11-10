import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application {
    private int count = 0;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        BorderPane pane = new BorderPane();

        Button button = new Button("Count \"Test\"");
        pane.setCenter(button);
        button.setOnAction(event -> {
            System.out.println("Count " + count++);
        });

        Label label = new Label("Label");
        HBox box = new HBox();
        box.getChildren().add(label);
        box.setAlignment(Pos.CENTER);
        pane.setBottom(box);

        Scene scene = new Scene(pane, 800, 600);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Title Bar");
        primaryStage.show();
    }
}
