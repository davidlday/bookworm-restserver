package com.prosegrinder.bookworm.restservice;

import com.prosegrinder.bookworm.restservice.resources.AnalysisResource;
import com.prosegrinder.bookworm.restservice.resources.ExtractionResource;

import ca.mestevens.java.configuration.bundle.TypesafeConfigurationBundle;
import io.dropwizard.Application;
import io.dropwizard.forms.MultiPartBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class RestApplication extends Application<RestConfiguration> {

  public static void main(final String[] args) throws Exception {
    new RestApplication().run(args);
  }

  @Override
  public final String getName() {
    return "bookworm-restserver";
  }

  @Override
  public final void initialize(final Bootstrap<RestConfiguration> bootstrap) {
    bootstrap.addBundle(new TypesafeConfigurationBundle());
//    bootstrap.addBundle(new TypesafeConfigurationBundle("com.prosegrinder.bookworm.restservice"));
    bootstrap.addBundle(new MultiPartBundle());
  }

  @Override
  public final void run(final RestConfiguration configuration, final Environment environment) {
    final AnalysisResource analysisResource = new AnalysisResource();
    environment.jersey().register(analysisResource);
    final ExtractionResource extractionResource = new ExtractionResource();
    environment.jersey().register(extractionResource);
  }

}
