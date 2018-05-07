
package snakepeli.db;



public class HighScore {
    private Integer id;
    private String player;
    private Integer points;
    
    public HighScore(String player, Integer points) {
        this.player = player;
        this.points = points;
    }

    public Integer getId() {
        return id;
    }

    public String getPlayer() {
        return player;
    }

    public Integer getPoints() {
        return points;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setPlayer(String player) {
        this.player = player;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }
    
}
