package com.prosegrinder.bookworm.restservice;

import com.prosegrinder.bookworm.util.Dictionary2;
import com.typesafe.config.Config;

import ca.mestevens.java.configuration.TypesafeConfiguration;

public class RestConfiguration extends TypesafeConfiguration {

  public final int getExtractionCharacterLimit() {
    return this.getConfig().getConfig("com.prosegrinder.bookworm.restservice.extraction")
        .getInt("characterLimit");
  }

  public final Dictionary2 getDictionary() {
    Config config = this.getConfig().getConfig("com.prosegrinder.bookworm.util.dictionary");
    String cmudictFile = config.getString("cmudict.file");
    Long maxWordCacheSize = config.getLong("wordCache.maxentries");
    Long ttlSecondsNonWordCache = config.getLong("nonWordCache.ttlSeconds");
    Boolean cacheNumbers = config.getBoolean("nonWordCache.cacheNumbers");
    Dictionary2 dictionary =
        new Dictionary2(cmudictFile, maxWordCacheSize, ttlSecondsNonWordCache, cacheNumbers);
    return dictionary;
  }
  
}
