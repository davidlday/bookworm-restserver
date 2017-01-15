package com.prosegrinder.bookworm.restservice.api;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class WordFrequency {
  private final String word;
  private final Integer count;

  @JsonCreator
  public WordFrequency(@JsonProperty final String text,
      @JsonProperty final Integer frequency) {
    this.word = text;
    this.count = frequency;
  }

  @JsonProperty
  public final String getWord() {
      return this.word;
  }

  @JsonProperty
  public final Integer getCount() {
      return this.count;
  }

}
