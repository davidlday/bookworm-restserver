package com.prosegrinder.bookworm.restservice;

import ca.mestevens.java.configuration.TypesafeConfiguration;
// import io.dropwizard.Configuration;

public class RestConfiguration extends TypesafeConfiguration {

  public int getExtractionCharacterLimit() {
    return this.getConfig().getConfig("com.prosegrinder.bookworm.restservice.extraction")
        .getInt("characterLimit");
  }
  
}
