package org.example.utils;


import io.dropwizard.db.DataSourceFactory;
import org.example.restapi.LmsApiConfiguration;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBUtils {

    private static Connection connection = null;

    public static Connection getConnection() {

        if (connection != null){
            return connection;}
        else {
            try {
                Properties prop = new Properties();
//                InputStream inputStream = DBUtils.class.getClassLoader().getResourceAsStream("./config.properties");
//                prop.load(inputStream);
//                String driver = prop.getProperty("driver");
//                String url = prop.getProperty("url");
//                String user = prop.getProperty("user");
//                String password = prop.getProperty("password");
//                Class.forName(driver);

               String user= LmsApiConfiguration.getUser();
               String url = LmsApiConfiguration.getUrl();
               String password = LmsApiConfiguration.getPassword();
               String driverClass = LmsApiConfiguration.getDriverClass();
               Class.forName(driverClass);
                connection = DriverManager.getConnection(url, user, password);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }

            return connection;
        }

    }


}