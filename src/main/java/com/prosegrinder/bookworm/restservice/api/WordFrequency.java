package com.prosegrinder.bookworm.restservice.api;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class WordFrequency {
  private final String word;
  private final Integer count;

  @JsonCreator
  public WordFrequency(@JsonProperty String word, @JsonProperty Integer count) {
      this.word = word;
      this.count = count;
  }

  @JsonProperty
  public String getWord() {
      return word;
  }

  @JsonProperty
  public Integer getCount() {
      return count;
  }

}
