package com.prosegrinder.bookworm.restservice;

import com.prosegrinder.bookworm.util.Dictionary2;

import ca.mestevens.java.configuration.TypesafeConfiguration;
// import io.dropwizard.Configuration;

public class RestConfiguration extends TypesafeConfiguration {

  private Dictionary2 dictionary = Dictionary2
      .getDictionary(this.getConfig().getConfig("com.prosegrinder.bookworm.util.dictionary"));

  public int getExtractionCharacterLimit() {
    return this.getConfig().getConfig("com.prosegrinder.bookworm.restservice.extraction")
        .getInt("characterLimit");
  }

  public Dictionary2 getDictionary() {
    return this.dictionary;
  }
}
