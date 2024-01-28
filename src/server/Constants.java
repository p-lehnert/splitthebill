package server;

public class Constants {

    public static final String DATABASE_URL_WINDOWS = "jdbc:sqlite:C:\\Users\\" + System.getProperty("user.name") + "\\Documents\\splithebill\\splitthebill.db";

    public static final String DATABASE_URL_LINUX = "jdbc:sqlite:/home/" + System.getProperty("user.name") + "/splitthebill/splitthebill.db";
}
