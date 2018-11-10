import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Lab8Problem1 extends Application {

    @Override
    public void start(Stage primaryStage) {
        Group root = new Group();
        Scene scene = new Scene(root, 800, 600, Color.LIGHTBLUE);

        //Window
        Rectangle window = new Rectangle(600,200,100,150);
        window.setFill(Color.LIGHTGRAY);
        window.setStroke(Color.BLACK);
        window.setStrokeWidth(2);
        Line wl1 = new Line(600,275,700,275);
        wl1.setStroke(Color.BLACK);
        wl1.setStrokeWidth(2);
        Line wl2 = new Line(650,200,650,350);
        wl2.setStroke(Color.BLACK);
        wl2.setStrokeWidth(2);

        //Bed
        Rectangle bf1 = new Rectangle(50,450,25,75);
        bf1.setFill(Color.SANDYBROWN);
        Rectangle bf2 = new Rectangle(250,450,25,75);
        bf2.setFill(Color.SANDYBROWN);
        Rectangle mattress = new Rectangle(50,450,225,25);
        mattress.setFill(Color.SLATEGREY);
        Rectangle pillow = new Rectangle(50,435,30,15);
        pillow.setFill(Color.WHITE);
        Rectangle cover = new Rectangle(80,440,195,10);
        cover.setFill(Color.DARKRED);

        //Kid
        Line l1 = new Line(400,450,420,420);
        Line l2 = new Line(420,420,440,450);
        Line body = new Line(420,420,420,370);
        Line a1 = new Line(420,380,430,400);
        Line a2 = new Line(420,380,410,400);
        Circle head = new Circle(420,360,10);
        head.setFill(Color.TRANSPARENT);
        head.setStroke(Color.BLACK);
        Text text = new Text(440,350,"Hmm, I'm really tired.\nI'm gonna take a nap.");

        //Painting
        Rectangle canvas = new Rectangle(40,300,50,75);
        Circle c1 = new Circle(45,305,5);
        Circle c2 = new Circle(67,320,15);
        Circle c3 = new Circle(55,340,12);
        Circle c4 = new Circle(80,355,8);
        Circle c5 = new Circle(60,365,6);
        canvas.setFill(Color.WHITE);
        canvas.setStroke(Color.BLACK);

        // Floor
        Rectangle floor = new Rectangle(0,400,800,200);
        floor.setFill(Color.LIGHTSKYBLUE);

        root.getChildren().addAll(floor, window, wl1, wl2, bf1, bf2, mattress, pillow, cover, l1, l2, body, a1, a2, head, text, canvas, c1, c2, c3, c4, c5);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}