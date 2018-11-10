// IMPORTS
// These are some classes that may be useful for completing the project.
// You may have to add others.

import java.util.List;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

/**
 * The main class for Week8Program. Week8Program constructs the JavaFX window and
 * handles interactions with the dynamic components contained therein.
 */
public class Week8Program extends Application {
    // INSTANCE VARIABLES
    // These variables are included to get you started.
    private Stage primaryStage = null;
    private BorderPane root = null;
    private WebView webView = null;
    private WebEngine webEngine = null;
    private TextField statusbar = null;

    private Button backButton = null;
    private Button forwardButton = null;
    private Button helpButton = null;
    private TextField addressBar = null;

//    private boolean addressBarClearText = true;
    // HELPER METHODS

    /**
     * Retrieves the value of a command line argument specified by the index.
     *
     * @param index - position of the argument in the args list.
     * @return The value of the command line argument.
     */
    private String getParameter(int index) {
        Parameters params = getParameters();
        List<String> parameters = params.getRaw();
        return !parameters.isEmpty() ? parameters.get(index) : "";
    }

    /**
     * Generates the status bar layout and text field.
     *
     * @return statusbarPane - the HBox layout that contains the statusbar.
     */
    private HBox makeStatusBar() {
        HBox statusbarPane = new HBox();
        statusbarPane.setPadding(new Insets(5, 4, 5, 4));
        statusbarPane.setSpacing(10);
        statusbarPane.setStyle("-fx-background-color: #336699;");
        statusbar = new TextField();
        HBox.setHgrow(statusbar, Priority.ALWAYS);
        statusbarPane.getChildren().addAll(statusbar);
        return statusbarPane;
    }

    // REQUIRED METHODS

    /**
     * The main entry point for all JavaFX applications. The start method is
     * called after the init method has returned, and after the system is ready
     * for the application to begin running.
     * <p>
     * NOTE: This method is called on the JavaFX Application Thread.
     *
     * @param primaryStage - the primary stage for this application, onto which
     *                     the application scene can be set.
     */
    @Override
    public void start(Stage primaryStage) {
        root = new BorderPane();

        //webview
        webView = new WebView();
        webEngine = webView.getEngine();
        root.setCenter(webView);

        //status bar
        root.setBottom(makeStatusBar());

        //stuff above HTML viewer
        backButton = new Button("<-");
        forwardButton = new Button("->");
        helpButton = new Button("?");
        addressBar = new TextField();
        HBox top = new HBox();
        HBox.setHgrow(addressBar, Priority.ALWAYS);
        top.getChildren().addAll(backButton, forwardButton, addressBar, helpButton);
        top.setAlignment(Pos.CENTER);
        top.setSpacing(7);

        root.setTop(top);

        Scene scene = new Scene(root);

        primaryStage.setScene(scene);
        primaryStage.setTitle("CS 1131 Web Browser");
        primaryStage.setMaximized(true);
        primaryStage.show();

        if(getParameter(0).isEmpty()) {
            webEngine.load("https://www.google.com");
        } else {
            webEngine.load(getParameter(0));
        }

        handleEvents(primaryStage);
    }

    public void handleEvents(Stage primaryStage) {

        webEngine.setOnStatusChanged(e -> {
            addressBar.setText(webEngine.getLocation());
            if(e.getData() != null) {
                statusbar.setText(e.getData());
            }

            if(webEngine.titleProperty() != null) {
                primaryStage.setTitle(webEngine.getTitle());
            } else {
                primaryStage.setTitle(webEngine.getLocation());
            }
        });

        backButton.setOnMouseClicked(e -> {
            if(webEngine.getHistory().getCurrentIndex() > 0) {
                webEngine.getHistory().go(-1);
            }
        });

        forwardButton.setOnMouseClicked(e -> {
            if(webEngine.getHistory().getCurrentIndex() < webEngine.getHistory().getEntries().size()) {
                webEngine.getHistory().go(1);
            }
        });

        addressBar.setOnKeyPressed(e -> {
            if(e.getCode() == KeyCode.ENTER) {
                webEngine.load("https://" + addressBar.getText());
            }
        });

        helpButton.setOnMouseClicked(e -> {
            Pane helpPane = new Pane();
            Text helpText = new Text(0, 25, "Julien Thrum\tCS1131\tLab Section 1\n" +
                    "This web server is used like any other\n" +
                    "You can use your forward and backward buttons to go through the web history\n" +
                    "You can mouse over a link, and you'll see the URL appear at the bottom\n" +
                    "You can change the URL on top to bring you to a desired location\n" +
                    "\twhen you change the URL, you don't need to add\"https://\"");
            helpText.setFont(Font.font(24));
            helpText.setStroke(Color.BLACK);
            helpPane.getChildren().add(helpText);
            Scene helpScene = new Scene(helpPane, 850, 195);
            Stage helpStage = new Stage();
            helpStage.setScene(helpScene);
            helpStage.setTitle("Help Menu");
            helpStage.show();
        });
    }

    /**
     * The main( ) method is ignored in JavaFX applications.
     * main( ) serves only as fallback in case the application is launched
     * as a regular Java application, e.g., in IDEs with limited FX
     * support.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}