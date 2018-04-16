package snake;

public class Game {

    private final int height;
    private final int width;
    private Snake snake;
    private Apple apple;
    private int score = 0;

    public Game(int x, int y) {
        this.width = x;
        this.height = y;
        this.snake = new Snake(width / 2, height / 2, Direction.DOWN);
        this.apple = new Apple((int) ((width - 1) * Math.random()), (int) ((height - 1) * Math.random()));

    }

    public Snake getSnake() {
        return this.snake;
    }

    public void setSnake(Snake snake) {
        this.snake = snake;
    }

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

    public boolean end() {
        return snake.contactWithTail(width, height);
    }

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

    public void growScore() {
        this.score++;
    }

    public void setScore(Integer x) {
        this.score = 0;
    }
}