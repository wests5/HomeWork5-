package com.vytrack.utilities;

import java.sql.*;

public class DBUtils {
    private final static String url = ConfigurationsReader.getProperty("JDBCString");
    private final static String username = ConfigurationsReader.getProperty("DB_username");
    private final static String password = ConfigurationsReader.getProperty("DB_password");
    private static Connection connection;
    private static Statement statement;

    static {
        try {
            connection = DriverManager.getConnection(url, username, password);
            statement = connection.createStatement();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static ResultSet runQuery(String sql){
        ResultSet resultSet = null;
        try {
            resultSet = statement.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;

    }
    public void updateQuery(String sql){

        try {
             statement.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void closeConnection(){
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
