package domain;

import java.io.FileReader;
import java.util.Properties;

public class ConfigureField {

    private static String url;
    private static String username;
    private static String password;
    private static Integer connectionCount;
    private static String path;

    public static String getPath() {
        return path;
    }

    public static String getUrl() {
        return url;
    }

    public static String getUsername() {
        return username;
    }

    public static String getPassword() {
        return password;
    }

    public static Integer getConnectionCount() {
        return connectionCount;
    }

    static {
        try {
            url="jdbc:mysql://localhost:3306/mydesign?serverTimezone=CST";
            username="root";
            password="root";
            connectionCount=5;
            path="com.mysql.cj.jdbc.Driver";
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
