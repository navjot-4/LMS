package org.example;
import io.dropwizard.Application;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.setup.Environment;
import org.example.restapi.*;

public class MyApplication extends Application<LmsApiConfiguration> {
    public static void main(String[] args) throws Exception {
        new MyApplication().run(args);
    }
    @Override
    public void run(LmsApiConfiguration configuration, Environment environment) throws Exception {

        DataSourceFactory dataSourceFactory = configuration.getDataSourceFactory();

        LmsApiConfiguration.setDriverClass(dataSourceFactory.getDriverClass());
        LmsApiConfiguration.setUser(dataSourceFactory.getUser());
        LmsApiConfiguration.setPassword(dataSourceFactory.getPassword());
        LmsApiConfiguration.setUrl(dataSourceFactory.getUrl());

        // Get the database URL, username, and password from the configuration

        environment.jersey().register(AdminREST.class);
        environment.jersey().register(StudentREST.class);
        environment.jersey().register(LibrarianREST.class);
        environment.jersey().register(UserREST.class);
    }
}
