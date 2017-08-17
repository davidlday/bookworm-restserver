package com.prosegrinder.bookworm.restservice.health;

import com.prosegrinder.bookworm.util.Dictionary2;
import com.prosegrinder.bookworm.util.Word;
import com.prosegrinder.bookworm.util.WordContainer;
import com.codahale.metrics.health.HealthCheck;

public class DictionaryHealthCheck extends HealthCheck {
  
  private final Dictionary2 dictionary;

  public DictionaryHealthCheck(Dictionary2 dictionary) {
    this.dictionary = dictionary;
  }
  
  @Override
  protected Result check() throws Exception {
    Word frowning =
        new Word(WordContainer.normalizeText("frowning"), 2, Boolean.TRUE, Boolean.FALSE);
    if (this.dictionary.getWord("frowning").equals(frowning)) {
      return Result.healthy();
    } else {
      return Result.unhealthy("Dictionary did not return a correct entry for 'frowning'.");
    }
  }

}
