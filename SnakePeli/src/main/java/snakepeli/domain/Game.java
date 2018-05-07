package snakepeli.domain;

import snakepeli.db.HighScoreDao;
import snakepeli.db.Database;

public class Game {

    private final int height;
    private final int width;
    private Snake snake;
    private Apple apple;
    private int score = 0;
    private Database database;
    private HighScoreDao scores;

    public Game(int x, int y) {
        this.width = x;
        this.height = y;
        this.snake = new Snake(width / 2, height / 2, Direction.DOWN);
        this.apple = new Apple((int) ((width - 1) * Math.random()), (int) ((height - 1) * Math.random()));
        this.database = new Database("jdbc:sqlite:HighScores.db");
        this.scores = new HighScoreDao(this.database);
        

    }
    
    public Snake getSnake() {
        return this.snake;
    }

    public void setSnake(Snake snake) {
        this.snake = snake;
    }
    /**
     * Replaces old Snake with a new Snake.
     */
    @SuppressWarnings("empty-statement")
    public void newSnake() {
        this.snake = new Snake(this.width / 2, this.height / 2, Direction.DOWN);;
    }

    public Apple getApple() {
        return this.apple;
    }

    public void setApple(Apple apple) {
        this.apple = apple;
    }
    /**
     * Returns true if game is suposed to end.
     * @return true if game is suposed to end, false otherwise.
     */
    public boolean end() {
        return snake.contactWithTail(width, height);
    }
    /**
     * If snake contacts with apple it grows score. Then it makes new apple and grows the snakes grow integer.
     * Then it moves the snake.
     * 
     */
    public void update() {

        if (snake.contact(this.apple)) {

            growScore();

            this.apple = new Apple((int) ((width - 1) * Math.random()), (int) ((height - 1) * Math.random()));
            this.snake.grow();
        }
        this.snake.move();
    }
    

    public int getScore() {
        return this.score;
    }
    /**
     * Method grows score by one.
     */
    public void growScore() {
        this.score++;
    }

    public void setScore(Integer x) {
        this.score = x;
    }

    public HighScoreDao getScores() {
        return scores;
    }
}
