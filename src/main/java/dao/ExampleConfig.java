package dao;

// This is an example of the Config file.
public class ExampleConfig {

    private static String url = "jdbc:mysql://localhost/db_name?serverTimezone=UTC";
    private static String user = "username_for_the_database";
    private static String password = "password_for_the_database";

    public static String getUrl() {
        return url;
    }

    public static String getUser() {
        return user;
    }

    public static String getPassword() {
        return password;
    }

}
