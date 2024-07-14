package server.persistence;

import server.Constants;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateDbs {

    static String sqlCreateUserTable = "CREATE TABLE IF NOT EXISTS users (id integer PRIMARY KEY, username text NOT NULL, password text NOT NULL);" +
            "CREATE TABLE IF NOT EXISTS groups (id integer PRIMARY KEY, username text NOT NULL, password text NOT NULL)";

    static String pathLin = "/home/" + System.getProperty("user.name") + "/splitthebill";

    static String pathWin = "C:\\Users\\" + System.getProperty("user.name") + "\\Documents\\splithebill";

    static File directory;

    public static void createDatabasesLin() {
        directory = new File(pathLin);
        directory.mkdir();
        try (Connection conn = DriverManager.getConnection(Constants.DATABASE_URL_LINUX)) {
            Statement stmt = conn.createStatement();
            stmt.execute(sqlCreateUserTable);
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void createDatabasesWin() {
        directory = new File(pathWin);
        directory.mkdir();

        try (Connection conn = DriverManager.getConnection(Constants.DATABASE_URL_WINDOWS)) {
            Statement stmt = conn.createStatement();
            stmt.execute(sqlCreateUserTable);
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
