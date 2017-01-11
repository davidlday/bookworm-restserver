package com.prosegrinder.bookworm.restservice;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class RestApplication extends Application<RestConfiguration> {

    public static void main(final String[] args) throws Exception {
        new RestApplication().run(args);
    }

    @Override
    public String getName() {
        return "bookworm-restservice";
    }

    @Override
    public void initialize(final Bootstrap<RestConfiguration> bootstrap) {
        // TODO: application initialization
    }

    @Override
    public void run(final RestConfiguration configuration,
                    final Environment environment) {
        // TODO: implement application
    }

}
