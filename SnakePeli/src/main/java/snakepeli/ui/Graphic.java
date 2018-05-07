package snakepeli.ui;

import snakepeli.db.HighScore;
import snakepeli.db.Database;
import snakepeli.domain.Direction;
import snakepeli.domain.Apple;
import snakepeli.domain.Game;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Graphic extends Application {

    private Label score = new Label("Score: 0");
    static boolean valmis = false;
    static Integer help;
    private String sb = "";
    private List<HighScore> scoreList;

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

        try {
            FileInputStream inputstream = new FileInputStream(Paths.get("Photos/Snake.png").toAbsolutePath().toString());
            Image image = new Image(inputstream);
            BackgroundImage bgImg = new BackgroundImage(image,
                    BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
                    BackgroundPosition.DEFAULT,
                    new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false));
            Background b = new Background(bgImg);
            startscreen.setBackground(b);
        } catch (FileNotFoundException e) {
            System.out.println("ERROR: " + e);
        }

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

        Pane endscreen = new Pane();
        endscreen.setPrefSize(600, 600);
        endscreen.setBackground(new Background(new BackgroundFill(Color.BLACK, null, new Insets(5))));

        Pane highscorescreen = new Pane();
        highscorescreen.setPrefSize(600, 600);
        highscorescreen.setBackground(new Background(new BackgroundFill(Color.BLACK, null, new Insets(5))));

        Text finale = new Text();
        finale.setText("Final score: " + game.getScore());
        finale.setFont(Font.font("Verdana", 70));
        finale.setFill(Color.WHITE);

        Button newGame = new Button("New Game");
        newGame.setPrefSize(230, 120);
        Button highScore = new Button("High Score");
        highScore.setPrefSize(230, 120);

        Text nameHere = new Text();
        nameHere.setText("Name: ");
        nameHere.setFill(Color.WHITE);
        TextField textField = new TextField();
        Button submit = new Button("Submit");

        VBox finaleText = new VBox();
        HBox submits = new HBox();
        VBox finaleButtons = new VBox();
        finaleText.getChildren().add(finale);

        submits.getChildren().addAll(nameHere, textField, submit);
        submits.setLayoutX(185);
        submits.setLayoutY(200);

        finaleButtons.setSpacing(10);
        finaleButtons.getChildren().addAll(newGame, highScore);
        finaleButtons.setLayoutX(190);
        finaleButtons.setLayoutY(240);

        endscreen.getChildren().addAll(finaleText, submits, finaleButtons);

        Label topScores = new Label(sb);
        topScores.setTextFill(Color.WHITE);
        topScores.setFont(Font.font("Verdana", 30));
        Label texTop = new Label("TOP 10 Scores.");
        texTop.setTextFill(Color.WHITE);
        texTop.setFont(Font.font("Verdana", 70));
        Button goBack = new Button("Main Menu");
        goBack.setPrefSize(230, 80);
        goBack.setLayoutX(190);
        goBack.setLayoutY(500);

        VBox scoreBox = new VBox();
        scoreBox.getChildren().addAll(texTop, topScores);
        scoreBox.setLayoutX(10);
        scoreBox.setLayoutY(5);

        highscorescreen.getChildren().add(scoreBox);
        highscorescreen.getChildren().add(goBack);

        Scene gameScene = new Scene(placement);
        Scene highscoreScene = new Scene(highscorescreen);
        Scene startScene = new Scene(startscreen);
        Scene endScene = new Scene(endscreen);

        gameScene.setOnKeyPressed((event) -> {
            switch (event.getCode()) {
                case UP:
                    game.getSnake().setDirection(Direction.UP);
                    break;
                case DOWN:
                    game.getSnake().setDirection(Direction.DOWN);
                    break;
                case RIGHT:
                    game.getSnake().setDirection(Direction.RIGHT);
                    break;
                case LEFT:
                    game.getSnake().setDirection(Direction.LEFT);
                    break;
                default:
                    break;
            }
        });

        //   Scene scene2 = new Scene(start);
        window.setScene(startScene);

        startGame.setOnAction(event -> {
            window.setScene(gameScene);
            timer.start();
            timer2.start();
            if (submit.isDisable()) {
                submit.setDisable(false);
            }
        });
        newGame.setOnAction(even -> {
            window.setScene(gameScene);
            timer.start();
            timer2.start();
            if (submit.isDisable()) {
                submit.setDisable(false);
            }
        });
        alku.setOnAction(event -> {
            finale.setText("Final score: " + game.getScore());
            help = game.getScore();
            window.setScene(endScene);
            game.setScore(0);
            game.newSnake();
        });
        submit.setOnAction(event -> {
            if (textField.getText().equals("CLOSE AND CLEAR")) {
                try {
                    game.getScores().dropTable();
                    Platform.exit();
                    System.exit(0);

                } catch (SQLException ex) {
                    Logger.getLogger(Graphic.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else if (!textField.getText().equals("")) {
                HighScore highscore = new HighScore(textField.getText(), help);
                try {
                    game.getScores().saveOrUpdate(highscore);
                } catch (SQLException ex) {
                    Logger.getLogger(Graphic.class.getName()).log(Level.SEVERE, null, ex);
                }
                submit.setDisable(true);
                textField.clear();
            }

        });
        hg.setOnAction(event -> {
            sb = "";
            try {
                scoreList = game.getScores().findTop();
                for (int i = 0; i < scoreList.size(); i++) {

                    sb += (i + 1 + ". " + scoreList.get(i).getPlayer() + "  ----  " + scoreList.get(i).getPoints() + " \n");
                }
                topScores.setText(sb);
            } catch (SQLException ex) {
                Logger.getLogger(Graphic.class.getName()).log(Level.SEVERE, null, ex);
            }
            window.setScene(highscoreScene);
        });

        highScore.setOnAction(event -> {
            sb = "";
            try {
                scoreList = game.getScores().findTop();
                for (int i = 0; i < scoreList.size(); i++) {
                    sb += (i + 1 + ". " + scoreList.get(i).getPlayer() + "  ----  " + scoreList.get(i).getPoints() + " \n");
                }
                topScores.setText(sb);
            } catch (SQLException ex) {
                Logger.getLogger(Graphic.class.getName()).log(Level.SEVERE, null, ex);
            }
            window.setScene(highscoreScene);
        });

        goBack.setOnAction(event -> {

            window.setScene(startScene);
        });

        window.show();

    }

    public static void main(String[] args) {
        launch(Graphic.class);
    }

}
