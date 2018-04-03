package Graphic;

import Snake.*;
import javafx.*;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Graphic extends Application {

    private Label score = new Label("Score: 0");

    @Override
    public void start(Stage window) throws Exception {
        int squareSize = 20;
        int squares = 30;

        Canvas canvas = new Canvas(squareSize * squares, squareSize * squares);
        GraphicsContext draw = canvas.getGraphicsContext2D();
        
        Canvas canvas2 = new Canvas(squareSize * squares, squareSize * squares);

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
                draw.fillRect(apple.getX() * squareSize, apple.getY() * squareSize, squareSize, squareSize);
            }
        };
        AnimationTimer timer2 = new AnimationTimer() {
            private long previous;

            @Override
            public void handle(long present) {
                if (present - previous < 1_000_000_000 / 20) {
                    return;
                }
                previous = present;

                game.update();
                score.setText("Score: " + game.getScore());
                if (game.end()) {
                    stop();
                }
            }
        };

        BorderPane placement = new BorderPane();
        placement.setCenter(canvas);
        placement.setTop(score);
        Scene gameScene = new Scene(placement);
        
        
        FlowPane startscreen = new FlowPane();
        Button startGame = new Button("New Game");
        Button hg = new Button("High Score");
        
        
        startscreen.getChildren().add(startGame);
        startscreen.getChildren().add(hg);
        Scene startScene = new Scene(startscreen);

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
