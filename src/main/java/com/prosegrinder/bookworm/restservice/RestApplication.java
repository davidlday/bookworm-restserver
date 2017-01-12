package com.prosegrinder.bookworm.restservice;

import com.prosegrinder.bookworm.restservice.resources.AnalysisResource;
import com.prosegrinder.bookworm.util.SyllableDictionary;
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
    // Ensure the SyllableDictionary singleton is instantiated.
    SyllableDictionary.getInstance();
  }

  @Override
  public void run(final RestConfiguration configuration,
                  final Environment environment) {
    final AnalysisResource analysis = new AnalysisResource();
    environment.jersey().register(analysis);
  }

}
