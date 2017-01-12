package com.prosegrinder.bookworm.restservice.api;

import com.fasterxml.jackson.annotation.JsonProperty;
// import com.prosegrinder.bookworm.restservice.api.WordFrequency;
import com.prosegrinder.bookworm.util.Prose;
import com.prosegrinder.bookworm.util.Word;
import com.prosegrinder.bookworm.util.ReadabilityScores;
import io.dropwizard.jackson.JsonSnakeCase;
import org.hibernate.validator.constraints.Length;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

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

  @JsonProperty
  public List<WordFrequency> getWordFrequency() {
    return prose.getWordFrequency().entrySet().stream()
        .map(entry -> new WordFrequency(entry.getKey().toString(), entry.getValue()))
        .collect(Collectors.toList());
  }

  @JsonProperty
  public Set<String> getUniqueWords() {
    return prose.getUniqueWords().stream()
        .map(word -> word.toString())
        .collect(Collectors.toSet());
  }

  @JsonProperty
  public Integer getUniqueWordCount() {
    return prose.getUniqueWordCount();
  }

  @JsonProperty
  public Integer getSentenceCount() {
    return prose.getSentenceCount();
  }

  @JsonProperty
  public Integer getParagraphCount() {
    return prose.getParagraphCount();
  }

  @JsonProperty
  public String getPov() {
    return prose.getPov().toString();
  }

}
