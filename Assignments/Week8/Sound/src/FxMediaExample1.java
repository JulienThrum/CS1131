import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.media.AudioClip;
import javafx.stage.Stage;

public class FxMediaExample1 extends Application
{
	private AudioClip audioClip;

	public static void main(String[] args)
	{
		Application.launch(args);
	}

	@Override
	public void init()
	{
		// Create an AudioClip, which loads the audio data synchronously
//		final URL resource = getClass().getResource("haunting.mp3");
		final URL resource;
		try {
			resource = new File ( "haunting.mp3").toURI ( ).toURL ( );
		audioClip = new AudioClip(resource.toExternalForm());
		} catch ( MalformedURLException e ) {
			e.printStackTrace ( );
		}
	}

	@Override
	public void start(Stage stage)
	{
		// Create the Buttons
		Button playButton = new Button("Play");
		Button stopButton = new Button("Stop");

		// Create the Event Handlers for the Button
		playButton.setOnAction(new EventHandler <ActionEvent>()
		{
			public void handle(ActionEvent event)
			{
				audioClip.setCycleCount ( 1 );
				audioClip.play();
			}
		});

		stopButton.setOnAction(new EventHandler <ActionEvent>()
		{
			public void handle(ActionEvent event)
			{
				audioClip.stop();
			}
		});

		// Create the GridPane
		GridPane sliderPane = new GridPane();
		// Set horizontal and vertical Spacing
		sliderPane.setHgap(5);
		sliderPane.setVgap(10);

		// Create the HBox
		HBox buttonBox = new HBox(5, playButton, stopButton);

		VBox root = new VBox(5,sliderPane, buttonBox);
		// Set the Sie of the VBox
		root.setPrefWidth(300);
		root.setPrefHeight(50);

		// Set the Style-properties of the HBox
		root.setStyle("-fx-padding: 10;" +
		              "-fx-border-style: solid inside;" +
		              "-fx-border-width: 2;" +
		              "-fx-border-insets: 5;" +
		              "-fx-border-radius: 5;" +
		              "-fx-border-color: blue;");

		// Create the Scene
		Scene scene = new Scene(root);
		// Add the scene to the Stage
		stage.setScene(scene);
		// Set the title of the Stage
		stage.setTitle("An AucioClip Example");
		// Display the Stage
		stage.show();
	}
}