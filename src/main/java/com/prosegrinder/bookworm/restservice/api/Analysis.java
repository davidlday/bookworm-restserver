package com.prosegrinder.bookworm.restservice.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.prosegrinder.bookworm.util.Prose;
import com.prosegrinder.bookworm.util.ReadabilityScores;
import io.dropwizard.jackson.JsonSnakeCase;
import org.hibernate.validator.constraints.Length;

@JsonSnakeCase
public class Analysis {

  private Prose prose;
  private ReadabilityScores scores;

  public Analysis() {
    // Jackson deserialization
  }

  public Analysis(String text) {
    prose = new Prose(text);
    scores = new ReadabilityScores(prose);
  }

  @JsonProperty
  public Integer getWordCount() {
    return prose.getWordCount();
  }

  @JsonProperty
  public Integer getSyllableCount() {
    return prose.getSyllableCount();
  }

}
