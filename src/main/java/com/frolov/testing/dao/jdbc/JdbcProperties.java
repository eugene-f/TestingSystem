package com.frolov.testing.dao.jdbc;

import java.util.ResourceBundle;

public abstract class JdbcProperties {

    private static final ResourceBundle database = ResourceBundle.getBundle("database");
    private static final String DRIVER = database.getString("driver");
    private static final String URL = database.getString("url");
    private static final String USERNAME = database.getString("username");
    private static final String PASSWORD = database.getString("password");

    public static ResourceBundle getDatabase() {
        return database;
    }

    public static String getDRIVER() {
        return DRIVER;
    }

    public static String getURL() {
        return URL;
    }

    public static String getUSERNAME() {
        return USERNAME;
    }

    public static String getPASSWORD() {
        return PASSWORD;
    }

}
