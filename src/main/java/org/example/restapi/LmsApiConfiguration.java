package org.example.restapi;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;
import io.dropwizard.db.DataSourceFactory;

public class LmsApiConfiguration extends Configuration {
    private static String driverClass;
    private static String user;
    private static String password;
    private static String url;

    public static String getDriverClass() {
        return driverClass;
    }

    public static void setDriverClass(String driverClass) {
        LmsApiConfiguration.driverClass = driverClass;
    }

    public static String getUser() {
        return user;
    }

    public static void setUser(String user) {
        LmsApiConfiguration.user = user;
    }

    public static String getPassword() {
        return password;
    }

    public static void setPassword(String password) {
        LmsApiConfiguration.password = password;
    }

    public static String getUrl() {
        return url;
    }

    public static void setUrl(String url) {
        LmsApiConfiguration.url = url;
    }
    @JsonProperty("database")
    private DataSourceFactory database = new DataSourceFactory();


        public  DataSourceFactory getDataSourceFactory() {
            return database;
        }
}

