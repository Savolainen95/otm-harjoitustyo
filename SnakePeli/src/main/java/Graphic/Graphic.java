package Graphic;

import Snake.*;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Paths;
import javafx.*;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.embed.swing.SwingFXUtils;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javax.imageio.ImageIO;

public class Graphic extends Application {

    private Label score = new Label("Score: 0");
    static boolean valmis = false;
    @Override
    public void start(Stage window) throws Exception {
        int squareSize = 20;
        int squares = 30;

        Canvas canvas = new Canvas(squareSize * squares, squareSize * squares);
        GraphicsContext draw = canvas.getGraphicsContext2D();
        
        

        //Canvas canvas2 = new Canvas(squareSize * squares, squareSize * squares);
        // C:\Users\Savolainen\otm-harjoitustyo\SnakePeli\src\main\java\Images\Snake.png
//        Background b = new Background(bgImg);
//        canvas2.setBackground(b);
        Game game = new Game(squares, squares);

        AnimationTimer timer = new AnimationTimer() {
            private long previous;

            @Override
            public void handle(long present) {
                if (present - previous < 1_000_000_000 / 30) {
                    return;
                }

                draw.setFill(Color.BLACK);
                draw.setStroke(Color.GREY);
                draw.fillRect(0, 0, squareSize * squares, squareSize * squares);

                draw.setFill(Color.GREEN);

                if (game.end()) {
                    draw.setFill(Color.GRAY);
                }

                game.getSnake().getPieces().stream().forEach(piece -> {
                    draw.fillRect(piece.getX() * squareSize, piece.getY() * squareSize, squareSize, squareSize);
                });

                draw.setFill(Color.RED);
                Apple apple = game.getApple();
                // draw.fillRect(apple.getX() * squareSize, apple.getY() * squareSize, squareSize, squareSize);
                draw.fillOval(apple.getX() * squareSize, apple.getY() * squareSize, squareSize, squareSize);
            }
        };
        AnimationTimer timer2 = new AnimationTimer() {
            private long previous;

            @Override
            public void handle(long present) {
                if (present - previous < 1_000_000_000 / 15) {
                    return;
                }
                previous = present;

                game.update();
                score.setText("Score: " + game.getScore());
                if (game.end()) {
                    score.setText("FINAL SCORE: " + game.getScore());
                    stop();
                    
                }
            }
        };

        Pane startscreen = new Pane();
        startscreen.setPrefSize(600, 600);
       // startscreen.setBackground(new Background(new BackgroundFill(Color.BLACK, null, new Insets(5))));
        
        
        try {
            FileInputStream inputstream = new FileInputStream(Paths.get("Photos/Snake.png").toAbsolutePath().toString());
            Image image = new Image(inputstream);
            BackgroundImage bgImg = new BackgroundImage(image,
                    BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
                    BackgroundPosition.DEFAULT,
                    new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false));
            Background b = new Background(bgImg);
            startscreen.setBackground(b);
        } catch (Exception e) {
            System.out.println("ERROR: "+e);
        }
        
        
//        Text text = new Text();
//        text.setText("SNAKE");
//        text.setFont(Font.font("Verdana", 70));
//        text.setFill(Color.GREENYELLOW);
        
        
        Button startGame = new Button("New Game");
        Button hg = new Button("High Score");
        startGame.setPrefSize(230, 120);
        hg.setPrefSize(230, 120);
        
        VBox vertical = new VBox();
        vertical.setSpacing(10);
        vertical.setLayoutX(185);
        vertical.setLayoutY(240);
      //  vertical.getChildren().add(text);
        vertical.getChildren().add(startGame);
        vertical.getChildren().add(hg);
      
        startscreen.getChildren().add(vertical);

        
        Button alku = new Button("New game");
        Label space = new Label("                   ");
        HBox horizontal = new HBox();
        horizontal.getChildren().addAll(score, space, alku);
        
        BorderPane placement = new BorderPane();
        placement.setCenter(canvas);
        placement.setTop(horizontal);
        Scene gameScene = new Scene(placement);

        
        
        Pane endscreen = new Pane();
        endscreen.setPrefSize(600, 600);
        endscreen.setBackground(new Background(new BackgroundFill(Color.BLACK, null, new Insets(5))));
        
        Text finale = new Text();
        finale.setText("Final score: " + game.getScore());
        finale.setFont(Font.font("Verdana", 70));
        finale.setFill(Color.GREENYELLOW);
        
        Button newGame = new Button("New Game");
        newGame.setPrefSize(230, 120);
        
        VBox finaleText = new VBox();
        finaleText.getChildren().add(finale);
        finaleText.getChildren().add(newGame);
        
        
        
        
        endscreen.getChildren().add(finaleText);
        
        
        Scene startScene = new Scene(startscreen);
        Scene endScene = new Scene(endscreen);
        
        gameScene.setOnKeyPressed((event) -> {
            if (event.getCode().equals(KeyCode.UP) && game.getSnake().getDirection() != Direction.DOWN) {
                game.getSnake().setDirection(Direction.UP);
            } else if (event.getCode().equals(KeyCode.DOWN) && game.getSnake().getDirection() != Direction.UP) {
                game.getSnake().setDirection(Direction.DOWN);
            } else if (event.getCode().equals(KeyCode.RIGHT) && game.getSnake().getDirection() != Direction.LEFT) {
                game.getSnake().setDirection(Direction.RIGHT);
            } else if (event.getCode().equals(KeyCode.LEFT) && game.getSnake().getDirection() != Direction.RIGHT) {
                game.getSnake().setDirection(Direction.LEFT);
            }
        });

        //   Scene scene2 = new Scene(start);
        window.setScene(startScene);

        startGame.setOnAction(event -> {
            window.setScene(gameScene);
            timer.start();
            timer2.start();
        });
        newGame.setOnAction(even -> {
            window.setScene(gameScene);
            timer.start();
            timer2.start();
        });
        alku.setOnAction(event -> {
            finale.setText("Final score: " + game.getScore());
            window.setScene(endScene);
            game.setScore(0);
            game.newSnake();
        });
        
        window.show();

    }

    public static void main(String[] args) {
        launch(Graphic.class);

//        Snake snake = new Snake(5, 5, Direction.RIGHT);
//        System.out.println(snake.getPieces());
//        snake.move();
//        System.out.println(snake.getPieces());
//        snake.move();
//        System.out.println(snake.getPieces());
//        snake.move();
//        System.out.println(snake.getPieces());
//        
//        
//        snake.grow();
//        System.out.println(snake.getPieces());
//        snake.grow();
//        System.out.println(snake.getPieces());
//        
//        snake.setDirection(Direction.LEFT);
//        System.out.println(snake.contactWithTail());
//        snake.move();
//        System.out.println(snake.contactWithTail());
    }

}
