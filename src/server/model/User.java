package server.model;

public class User {

    private static int instances;

    private final int id;

    private String username;

    private String password;

    public User() {
        instances++;
        id = instances;
    }

    public User(String username, String password) {
        instances++;
        id = instances;
        this.username = username;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}