package server.persistence;

import server.Constants;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateDbs {

    public static void createDatabases() {
        String sqlCreateUserTable = "CREATE TABLE IF NOT EXISTS users (id integer PRIMARY KEY, username text NOT NULL, password text NOT NULL);";
        try (Connection conn = System.getProperty("os.name").contains("Windows")
                ? DriverManager.getConnection(Constants.DATABASE_URL_WINDOWS)
                : DriverManager.getConnection(Constants.DATABASE_URL_LINUX)) {
            Statement stmt = conn.createStatement();
            stmt.execute(sqlCreateUserTable);
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
