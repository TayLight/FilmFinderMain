package com.filmlibrary;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBUtil {
    private static Connection connection = null;

    public static Connection getConnection() {
        if (connection != null) return connection;
        else {
            try {
                InputStream foo = DBUtil.class.getClassLoader().getResourceAsStream("db.properties");
                Properties properties = new Properties();
                properties.load(foo);
                String driver = properties.getProperty("driver");
                String url =properties.getProperty("url");
                Class.forName(driver);
                connection = DriverManager.getConnection(url,properties);
            } catch (ClassNotFoundException | SQLException | IOException e) {
                e.printStackTrace();
            }
            return connection;//
        }
    }

    public static void main(String[] argv) {

    }
}
