package com.prosegrinder.bookworm.restservice.api;

import com.fasterxml.jackson.annotation.JsonProperty;
// import com.prosegrinder.bookworm.restservice.api.WordFrequency;
import com.prosegrinder.bookworm.util.Prose;
// import com.prosegrinder.bookworm.util.Word;
import com.prosegrinder.bookworm.util.ReadabilityScores;
import io.dropwizard.jackson.JsonSnakeCase;
// import org.hibernate.validator.constraints.Length;

// import java.util.ArrayList;
// import java.util.Collections;
import java.util.List;
// import java.util.Map;
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
  public Double getAvgSyllablesPerWord() {
    return prose.getAverageSyllablesPerWord();
  }

  @JsonProperty
  public Double getAvgWordsPerSentence() {
    return prose.getAverageWordsPerSentence();
  }

  @JsonProperty
  public Integer getBytes() {
    return prose.getInitialText().getBytes().length;
  }

  @JsonProperty
  public Integer getComplexWordCount() {
    return prose.getComplexWordCount();
  }

  @JsonProperty
  public Integer getDialogueSyllableCount() {
    return prose.getDialogueSyllableCount();
  }

  @JsonProperty
  public Double getDialogueSyllablePercentage() {
    return (double) prose.getDialogueSyllableCount() / (double) prose.getSyllableCount() * 100;
  }

  @JsonProperty
  public Integer getDialogueUniqueWordCount() {
    return prose.getDialogueWordFrequency().keySet().size();
  }

  @JsonProperty
  public Integer getDialogueWordCount() {
    return prose.getDialogueWordCount();
  }

  @JsonProperty
  public List<WordFrequency> getDialogueWordFrequency() {
    return prose.getDialogueWordFrequency().entrySet().stream()
        .map(entry -> new WordFrequency(entry.getKey().toString(), entry.getValue()))
        .collect(Collectors.toList());
  }

  @JsonProperty
  public Double getDialogueWordPercentage() {
    return (double) prose.getDialogueWordCount() / (double) prose.getWordCount() * 100;
  }

  @JsonProperty
  public Integer getNarrativeSyllableCount() {
    return prose.getNarrativeSyllableCount();
  }

  @JsonProperty
  public Double getNarrativeSyllablePercentage() {
    return (double) prose.getNarrativeSyllableCount() / (double) prose.getSyllableCount() * 100;
  }

  @JsonProperty
  public Integer getNarrativeUniqueWordCount() {
    return prose.getNarrativeWordFrequency().keySet().size();
  }

  @JsonProperty
  public Integer getNarrativeWordCount() {
    return prose.getNarrativeWordCount();
  }

  @JsonProperty
  public List<WordFrequency> getNarrativeWordFrequency() {
    return prose.getNarrativeWordFrequency().entrySet().stream()
        .map(entry -> new WordFrequency(entry.getKey().toString(), entry.getValue()))
        .collect(Collectors.toList());
  }

  @JsonProperty
  public Double getNarrativeWordPercentage() {
    return (double) prose.getNarrativeWordCount() / (double) prose.getWordCount() * 100;
  }

  @JsonProperty
  public Integer getParagraphCount() {
    return prose.getParagraphCount();
  }

  @JsonProperty
  public String getPov() {
    return prose.getPov().toString();
  }

  @JsonProperty
  public Integer getSentenceCount() {
    return prose.getSentenceCount();
  }

  @JsonProperty
  public Integer getSyllableCount() {
    return prose.getSyllableCount();
  }

  @JsonProperty
  public Integer getUniqueWordCount() {
    return prose.getUniqueWordCount();
  }

  @JsonProperty
  public Set<String> getUniqueWords() {
    return prose.getUniqueWords().stream()
        .map(word -> word.toString())
        .collect(Collectors.toSet());
  }

  @JsonProperty
  public Integer getWordCount() {
    return prose.getWordCount();
  }

  @JsonProperty
  public List<WordFrequency> getWordFrequency() {
    return prose.getWordFrequency().entrySet().stream()
        .map(entry -> new WordFrequency(entry.getKey().toString(), entry.getValue()))
        .collect(Collectors.toList());
  }

  // Readability Scores

  @JsonProperty
  public final Double getAutomatedReadabilityIndex() {
    return scores.getAutomatedReadabilityIndex();
  }

  @JsonProperty
  public final Double getColemanLiauIndex() {
    return scores.getColemanLiauIndex();
  }

  @JsonProperty
  public final Double getFleschKincaidGradeLevel() {
    return scores.getFleschKincaidGradeLevel();
  }

  @JsonProperty
  public final Double getFleschReadingEase() {
    return scores.getFleschReadingEase();
  }

  @JsonProperty
  public final Double getGunningFogIndex() {
    return scores.getGunningFogIndex();
  }

  @JsonProperty
  public final Double getLix() {
    return scores.getLix();
  }

  @JsonProperty
  public final Double getSmog() {
    return scores.getSmog();
  }


}
