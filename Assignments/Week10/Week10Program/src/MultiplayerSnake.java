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

public class MultiplayerSnake extends Application {
    private AudioClip marioCoinSound;
    private double speed;
    private ArrayList<Rectangle> body1 = null;
    private ArrayList<Rectangle> body2 = null;
    private Rectangle multiApple;
    int scoreCount1 = 0;
    Text score1 = null;
    int scoreCount2 = 0;
    Text score2 = null;
    Timeline timeline = null;

    Snake.Direction d1 = null;
    Snake.Direction d2 = null;

    //coordinate for classicApple
    int appleX;
    int appleY;

    private Pane root = null;
    Scene scene = null;

    public MultiplayerSnake(double speed) {
        this.speed = speed;
    }

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

    }

    public void playMultiMode(Stage stage) {
        init();
        setupMultiMode();
        stage.setScene(scene);
        stage.setTitle("Multiplayer Snake Game");

        System.out.println("In Multiplayer Mode");
        timeline = new Timeline(new KeyFrame(Duration.millis(speed), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                multiCheckCollisions();

                if(appleX == body1.get(body1.size() - 1).getX() && appleY == body1.get(body1.size() - 1).getY()) {
                    marioCoinSound.setCycleCount(1);
                    marioCoinSound.play();
                    root.getChildren().remove(multiApple);
                    multiAddApple();

                    addBody(body1, root, 400, 400, d1, Color.GREEN);

                    score1.setText(Integer.toString(++scoreCount1));
                } else if(appleX == body2.get(body2.size() - 1).getX() && appleY == body2.get(body2.size() - 1).getY()) {
                    marioCoinSound.setCycleCount(1);
                    marioCoinSound.play();
                    root.getChildren().remove(multiApple);
                    multiAddApple();
                    addBody(body2, root, 600, 400, d2, Color.DODGERBLUE);

                    score2.setText(Integer.toString(++scoreCount2));
                }

                //Handle snake moving
                moveSnake(body1, d1, timeline, score1, scene);
                moveSnake(body2, d2, timeline, score2, scene);

                //arrows change direction of player 1
                scene.addEventHandler(KeyEvent.KEY_PRESSED, (key) -> {
                    if(key.getCode() == KeyCode.A && d1 != Snake.Direction.kRight) {
                        d1 = Snake.Direction.kLeft;
                    } else if(key.getCode() == KeyCode.W && d1 != Snake.Direction.kDown) {
                        d1 = Snake.Direction.kUp;
                    } else if(key.getCode() == KeyCode.S && d1 != Snake.Direction.kUp) {
                        d1 = Snake.Direction.kDown;
                    } else if(key.getCode() == KeyCode.D && d1 != Snake.Direction.kLeft) {
                        d1 = Snake.Direction.kRight;
                    }
                });

                //arrows change direction of player 2
                scene.addEventHandler(KeyEvent.KEY_PRESSED, (key) -> {
                    if(key.getCode() == KeyCode.LEFT && d2 != Snake.Direction.kRight) {
                        d2 = Snake.Direction.kLeft;
                    } else if(key.getCode() == KeyCode.UP && d2 != Snake.Direction.kDown) {
                        d2 = Snake.Direction.kUp;
                    } else if(key.getCode() == KeyCode.DOWN && d2 != Snake.Direction.kUp) {
                        d2 = Snake.Direction.kDown;
                    } else if(key.getCode() == KeyCode.RIGHT && d2 != Snake.Direction.kLeft) {
                        d2 = Snake.Direction.kRight;
                    }
                });

            }
        }));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }

    private void setupMultiMode() {
        root = new Pane();
        scene = new Scene(root, 1000, 700);
        body1 = new ArrayList<Rectangle>();
        body2 = new ArrayList<Rectangle>();
        score1 = new Text(225, 425, Integer.toString(scoreCount1));
        score1.setFont(Font.font(250));
        score1.setFill(Color.LIGHTGREY);
        score2 = new Text(625, 425, Integer.toString(scoreCount2));
        score2.setFont(Font.font(250));
        score2.setFill(Color.LIGHTGREY);

        root.getChildren().addAll(score1, score2);

        addBody(body1, root, 400, 400, d1, Color.GREEN);
        addBody(body2, root, 600, 400, d2, Color.DODGERBLUE);
        multiAddApple();
    }

    private void moveLeft(ArrayList<Rectangle> r, Timeline t, Text txt) {
        double tempX;
        double tempY;

        if(r.get(r.size() - 1).getX() == 0) {
            score2.setText("");
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
            score2.setText("");
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
            score2.setText("");
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
            score2.setText("");
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

    private void addBody(ArrayList<Rectangle> b, Pane p, int startX, int startY, Snake.Direction d, Color c) {
        if(b.isEmpty()) {
            Rectangle r = new Rectangle(startX, startY, 25, 25);
            r.setFill(c);
            b.add(r);
            p.getChildren().add(b.get(b.size() - 1));
            System.out.println("Body added");
        } else {
            if(d == Snake.Direction.kLeft) {
                Rectangle r = new Rectangle(b.get(b.size() - 1).getX() - 25, b.get(b.size() - 1).getY(), 25, 25);
                r.setFill(c);
                b.add(r);
                p.getChildren().add(b.get(b.size() - 1));
            } else if(d == Snake.Direction.kUp) {
                Rectangle r = new Rectangle(b.get(b.size() - 1).getX(), b.get(b.size() - 1).getY() - 25, 25, 25);
                r.setFill(c);
                b.add(r);
                p.getChildren().add(b.get(b.size() - 1));
            } else if(d == Snake.Direction.kDown) {
                Rectangle r = new Rectangle(b.get(b.size() - 1).getX(), b.get(b.size() - 1).getY() + 25, 25, 25);
                r.setFill(c);
                b.add(r);
                p.getChildren().add(b.get(b.size() - 1));
            } else if(d == Snake.Direction.kRight) {
                Rectangle r = new Rectangle(b.get(b.size() - 1).getX() + 25, b.get(b.size() - 1).getY(), 25, 25);
                r.setFill(c);
                b.add(r);
                p.getChildren().add(b.get(b.size() - 1));
            }
        }
    }

    private void multisetXY() {
        appleX = (int) Math.floor(scene.getWidth() / 25);
        appleY = (int) Math.floor(scene.getHeight() / 25);

        appleX = (int) (Math.random() * appleX) * 25;
        appleY = (int) (Math.random() * appleY) * 25;
    }

    private void multiAddApple() {
        multisetXY();

        for(int i = 0; i < body1.size(); i++) {
            if(appleX == body1.get(i).getX() && appleY == body1.get(i).getY()) {
                multisetXY();
            }
        }

        for(int i = 0; i < body2.size(); i++) {
            if(appleX == body2.get(i).getX() && appleY == body2.get(i).getY()) {
                multisetXY();
            }
        }

        multiApple = new Rectangle(appleX, appleY, 25, 25);
        multiApple.setFill(Color.RED);
        root.getChildren().add(multiApple);
    }

    private void multiCheckCollisions() {
        for(int i = 0; i < body1.size() - 2; i++) {
            if(body1.get(body1.size() - 1).getX() == body1.get(i).getX() && body1.get(body1.size() - 1).getY() == body1.get(i).getY()) {
                score2.setText("");
                score1.setFont(Font.font(56));
                score1.setX(200);
                score1.setText("Game over\nPlayer 1 ate themselves");
                timeline.stop();
            }

            if(body2.get(body2.size() - 1).getX() == body1.get(i).getX() && body2.get(body2.size() - 1).getY() == body1.get(i).getY()) {
                score2.setText("");
                score1.setFont(Font.font(56));
                score1.setX(200);
                score1.setText("Game over\nPlayer 2 crashed into player 1");
                timeline.stop();
            }
        }

        for(int i = 0; i < body2.size() - 2; i++) {
            if(body2.get(body2.size() - 1).getX() == body2.get(i).getX() && body2.get(body2.size() - 1).getY() == body2.get(i).getY()) {
                score2.setText("");
                score1.setFont(Font.font(56));
                score1.setX(200);
                score1.setText("Game over\nPlayer 2 ate themselves");
                timeline.stop();
            }

            if(body1.get(body1.size() - 1).getX() == body2.get(i).getX() && body1.get(body1.size() - 1).getY() == body2.get(i).getY()) {
                score2.setText("");
                score1.setFont(Font.font(56));
                score1.setX(200);
                score1.setText("Game over\nPlayer 1 crashed into player 2");
                timeline.stop();
            }
        }

        if(body2.get(body2.size() - 1).getX() == body1.get(body1.size() - 1).getX() && body2.get(body2.size() - 1).getY() == body1.get(body1.size() - 1).getY()) {
            score2.setText("");
            score1.setFont(Font.font(56));
            score1.setX(200);
            score1.setText("Game over\nLol you both crashed into\neach other");
            timeline.stop();
        }
    }

    @Override
    public void init() {
        // Create an AudioClip, which loads the audio data synchronously
        final URL resource;
        try {
            resource = new File("marioCoin.mp3").toURI().toURL();
            marioCoinSound = new AudioClip(resource.toExternalForm());
        } catch(MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
