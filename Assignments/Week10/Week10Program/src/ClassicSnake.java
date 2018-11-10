import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.media.AudioClip;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class ClassicSnake extends Application {

    private AudioClip marioCoinSound;
    private double speed;
    private ArrayList<Rectangle> body = null;
    private Rectangle apple;
    int scoreCount = 0;
    Text score = null;
    Timeline timeline = null;

    Snake.Direction d = null;

    //coordinate for apple
    int appleX;
    int applyY;

    private Pane classicRoot = null;
    Scene scene = null;

    public ClassicSnake(double speed) {
        this.speed = speed;
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

    }

    public void playClassicMode(Stage stage) {
        init();
        setupClassicMode();
        stage.setScene(scene);
        stage.setTitle("Classic Snake Game");

        System.out.println("In Classic Mode");
        timeline = new Timeline(new KeyFrame(Duration.millis(speed), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(appleX == body.get(body.size() - 1).getX() && applyY == body.get(body.size() - 1).getY()) {
                    marioCoinSound.setCycleCount ( 1 );
                    marioCoinSound.play();
                    classicRoot.getChildren().remove(apple);
                    classicAddApple();
                    addBody(body, classicRoot, 500, 400, d);

                    score.setText(Integer.toString(++scoreCount));
                }

                moveSnake(body, d, timeline, score, scene);

                //arrows and WASD to change direction
                scene.addEventHandler(KeyEvent.KEY_PRESSED, (key) -> {
                    if((key.getCode() == KeyCode.LEFT || key.getCode() == KeyCode.A) && d != Snake.Direction.kRight) {
                        d = Snake.Direction.kLeft;
                    } else if((key.getCode() == KeyCode.UP || key.getCode() == KeyCode.W) && d != Snake.Direction.kDown) {
                        d = Snake.Direction.kUp;
                    } else if((key.getCode() == KeyCode.DOWN || key.getCode() == KeyCode.S) && d != Snake.Direction.kUp) {
                        d = Snake.Direction.kDown;
                    } else if((key.getCode() == KeyCode.RIGHT || key.getCode() == KeyCode.D) && d != Snake.Direction.kLeft) {
                        d = Snake.Direction.kRight;
                    }
                });

                classicCheckCollision();
            }
        }));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }

    private void setupClassicMode() {
        classicRoot = new Pane();
        scene = new Scene(classicRoot, 1000, 700);
        body = new ArrayList<Rectangle>();
        score = new Text(425, 425, Integer.toString(scoreCount));
        score.setFont(Font.font(250));
        score.setFill(Color.LIGHTGREY);

        classicRoot.getChildren().add(score);

        addBody(body, classicRoot, 500, 400, d);
        classicAddApple();
    }

    private void moveLeft(ArrayList<Rectangle> r, Timeline t, Text txt) {
        double tempX;
        double tempY;

        if(r.get(r.size() - 1).getX() == 0) {
            txt.setFont(Font.font(56));
            txt.setText("Game over");
            t.stop();
        }

        for(int i = 0; i < r.size(); i++) {
            tempX = r.get(i).getX();
            tempY = r.get(i).getY();

            r.get(i).setX(r.get(i).getX() - 25);

            if(i > 0) {
                r.get(i - 1).setX(tempX);
                r.get(i - 1).setY(tempY);
            }
        }
    }

    private void moveUp(ArrayList<Rectangle> r, Timeline t, Text txt) {
        double tempX;
        double tempY;

        if(r.get(r.size() - 1).getY() == 0) {
            txt.setFont(Font.font(56));
            txt.setText("Game over");
            t.stop();
        }

        for(int i = 0; i < r.size(); i++) {
            tempX = r.get(i).getX();
            tempY = r.get(i).getY();

            r.get(i).setY(r.get(i).getY() - 25);

            if(i > 0) {
                r.get(i - 1).setX(tempX);
                r.get(i - 1).setY(tempY);
            }
        }
    }

    private void moveDown(ArrayList<Rectangle> r, Timeline t, Text txt, Scene s) {
        double tempX;
        double tempY;

        if(r.get(r.size() - 1).getY() == Math.floor(s.getHeight() / 5) * 5 - 25) {
            txt.setFont(Font.font(56));
            txt.setText("Game over");
            t.stop();
        }

        for(int i = 0; i < r.size(); i++) {
            tempX = r.get(i).getX();
            tempY = r.get(i).getY();

            r.get(i).setY(r.get(i).getY() + 25);

            if(i > 0) {
                r.get(i - 1).setX(tempX);
                r.get(i - 1).setY(tempY);
            }
        }
    }

    private void moveRight(ArrayList<Rectangle> r, Timeline t, Text txt, Scene s) {
        double tempX;
        double tempY;

        if(r.get(r.size() - 1).getX() == Math.floor(s.getWidth() / 5) * 5 - 25) {
            txt.setFont(Font.font(56));
            txt.setText("Game over");
            t.stop();
        }

        for(int i = 0; i < r.size(); i++) {
            tempX = r.get(i).getX();
            tempY = r.get(i).getY();

            r.get(i).setX(r.get(i).getX() + 25);

            if(i > 0) {
                r.get(i - 1).setX(tempX);
                r.get(i - 1).setY(tempY);
            }
        }
    }

    private void moveSnake(ArrayList<Rectangle> b, Snake.Direction d, Timeline t, Text txt, Scene s) {
        if(d == Snake.Direction.kLeft) {
            moveLeft(b, t, txt);
        } else if(d == Snake.Direction.kUp) {
            moveUp(b, t, txt);
        } else if(d == Snake.Direction.kDown) {
            moveDown(b, t, txt, s);
        } else if(d == Snake.Direction.kRight) {
            moveRight(b, t, txt, s);
        }
    }

    private void classicAddApple() {
        classicSetApplyXY();

        for(int i = 0; i < body.size(); i++) {
            if(appleX == body.get(i).getX() && applyY == body.get(i).getY()) {
                classicSetApplyXY();
            }
        }

        apple = new Rectangle(appleX, applyY, 25, 25);
        apple.setFill(Color.RED);
        classicRoot.getChildren().add(apple);
    }

    private void classicSetApplyXY() {
        appleX = (int) Math.floor(scene.getWidth() / 25);
        applyY = (int) Math.floor(scene.getHeight() / 25);

        appleX = (int) (Math.random() * appleX) * 25;
        applyY = (int) (Math.random() * applyY) * 25;
    }

    private void addBody(ArrayList<Rectangle> b, Pane p, int startX, int startY, Snake.Direction d) {
        if(b.isEmpty()) {
            Rectangle r = new Rectangle(startX, startY, 25, 25);
            r.setFill(Color.GREEN);
            b.add(r);
            p.getChildren().add(b.get(b.size() - 1));
            System.out.println("Body added");
        } else {
            if(d == Snake.Direction.kLeft) {
                Rectangle r = new Rectangle(b.get(b.size() - 1).getX() - 25, b.get(b.size() - 1).getY(), 25, 25);
                r.setFill(Color.GREEN);
                b.add(r);
                p.getChildren().add(b.get(b.size() - 1));
            } else if(d == Snake.Direction.kUp) {
                Rectangle r = new Rectangle(b.get(b.size() - 1).getX(), b.get(b.size() - 1).getY() - 25, 25, 25);
                r.setFill(Color.GREEN);
                b.add(r);
                p.getChildren().add(b.get(b.size() - 1));
            } else if(d == Snake.Direction.kDown) {
                Rectangle r = new Rectangle(b.get(b.size() - 1).getX(), b.get(b.size() - 1).getY() + 25, 25, 25);
                r.setFill(Color.GREEN);
                b.add(r);
                p.getChildren().add(b.get(b.size() - 1));
            } else if(d == Snake.Direction.kRight) {
                Rectangle r = new Rectangle(b.get(b.size() - 1).getX() + 25, b.get(b.size() - 1).getY(), 25, 25);
                r.setFill(Color.GREEN);
                b.add(r);
                p.getChildren().add(b.get(b.size() - 1));
            }
        }
    }

    private void classicCheckCollision() {
        for(int i = 0; i < body.size() - 2; i++) {
            if(body.get(body.size() - 1).getX() == body.get(i).getX() && body.get(body.size() - 1).getY() == body.get(i).getY()) {
                score.setFont(Font.font(56));
                score.setText("Game over");
                timeline.stop();
            }
        }
    }

    @Override
    public void init() {
        // Create an AudioClip, which loads the audio data synchronously
//		final URL resource = getClass().getResource("haunting.mp3");
        final URL resource;
        try {
            resource = new File("marioCoin.mp3").toURI().toURL();
            marioCoinSound = new AudioClip(resource.toExternalForm());
        } catch(MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
