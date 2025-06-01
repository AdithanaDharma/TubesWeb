package com.tubespbo.tubesweb.model.service;

import com.mysql.cj.jdbc.MysqlDataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBHandler {

    private static final Logger LOGGER = Logger.getLogger(DBHandler.class.getName());
    private static Connection connection = null;

    public static Connection getConnection() {
        if (connection == null) {
            try {
                MysqlDataSource dataSource = new MysqlDataSource();
                dataSource.setUser("root");
                dataSource.setPassword("");
                dataSource.setServerName("localhost");
                dataSource.setPort(3306);
                dataSource.setDatabaseName("db_tubesweb");

                connection = dataSource.getConnection();
                LOGGER.log(Level.INFO, "Database connection established successfully using DataSource.");
            } catch (SQLException ex) {
                LOGGER.log(Level.SEVERE, "Failed to connect to database. Check JDBC URL, user, and password.", ex);
            }
        }
        return connection;
    }

    public static void closeConnection(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
                connection = null;
                LOGGER.log(Level.INFO, "Database connection closed.");
            } catch (SQLException ex) {
                LOGGER.log(Level.SEVERE, "Failed to close database connection.", ex);
            }
        }
    }
}