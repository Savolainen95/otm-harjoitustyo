package snakepeli.db;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Database {

    private String database;
    
    public Database(String database) {
        this.database = database;
        this.init();
    }
    /**
     * Gets connection to database.
     * @return Connection
     * @throws SQLException 
     */
    public Connection getConnection() throws SQLException {
        String dbUrl = System.getenv("JDBC_DATABASE_URL");
        if (dbUrl != null && dbUrl.length() > 0) {
            return DriverManager.getConnection(dbUrl);
        }
        return DriverManager.getConnection(database);
    }
    /**
     * Makes new database if old one doesn't exist.
     */
    public void init() {
        List<String> commands = this.sqliteCommands();

        // "try with resources" close the resources in the end
        try (Connection conn = getConnection()) {
            Statement st = conn.createStatement();

            for (String com : commands) {
                System.out.println("Running command >> " + com);
                st.executeUpdate(com);
            }

        } catch (Throwable t) {
            // if db is initialized -> failed to run commands and stop
            System.out.println("Error >> " + t.getMessage());
        }
    }
    /**
     * Creates table if making new database;
     * @return List that goes to database.
     */
    private List<String> sqliteCommands() {
        ArrayList<String> list = new ArrayList<>();

        list.add("CREATE TABLE HighScores ("
                + "id integer PRIMARY KEY, "
                + "player varchar(50), "
                + "points integer);");
        return list;
    }
}
