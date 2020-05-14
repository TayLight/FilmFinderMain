package com.filmlibrary;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionPool {
    private static final String DATASOURCE_NAME = "java:/FilmDS";
    private static DataSource dataSource;

    static {
        try {
            Context initContext = new InitialContext();
            //Context envContext = (Context) initContext.lookup("java:comp/env");
            dataSource = (DataSource) initContext.lookup(DATASOURCE_NAME);
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }

    public ConnectionPool() {
    }

    public Connection getConnection() {
        try {
            return dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
