package com.prosegrinder.bookworm.restservice.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.prosegrinder.bookworm.util.Prose;
import com.prosegrinder.bookworm.util.ReadabilityScores;
import io.dropwizard.jackson.JsonSnakeCase;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@JsonSnakeCase
public class Analysis {

  private final Prose prose;
  private final ReadabilityScores scores;

  public Analysis(final String text) {
    this.prose = new Prose(text);
    this.scores = new ReadabilityScores(this.prose);
  }

  @JsonProperty
  public final Double getAvgSyllablesPerWord() {
    return prose.getAverageSyllablesPerWord();
  }

  @JsonProperty
  public final Double getAvgWordsPerSentence() {
    return prose.getAverageWordsPerSentence();
  }

  @JsonProperty
  public final Integer getBytes() {
    return prose.getInitialText().getBytes().length;
  }

  @JsonProperty
  public final Integer getComplexWordCount() {
    return prose.getComplexWordCount();
  }

  @JsonProperty
  public final Integer getDialogueSyllableCount() {
    return prose.getDialogueSyllableCount();
  }

  @JsonProperty
  public final Double getDialogueSyllablePercentage() {
    return (double) prose.getDialogueSyllableCount()
        / (double) prose.getSyllableCount() * 100;
  }

  @JsonProperty
  public final Integer getDialogueUniqueWordCount() {
    return prose.getDialogueWordFrequency().keySet().size();
  }

  @JsonProperty
  public final Integer getDialogueWordCount() {
    return prose.getDialogueWordCount();
  }

  @JsonProperty
  public final List<WordFrequency> getDialogueWordFrequency() {
    return prose.getDialogueWordFrequency().entrySet().stream()
        .map(entry ->
            new WordFrequency(entry.getKey().toString(), entry.getValue()))
        .collect(Collectors.toList());
  }

  @JsonProperty
  public final Double getDialogueWordPercentage() {
    return (double) prose.getDialogueWordCount()
        / (double) prose.getWordCount() * 100;
  }

  @JsonProperty
  public final Integer getLongWordCount() {
    return prose.getLongWordCount();
  }

  @JsonProperty
  public final Integer getNarrativeSyllableCount() {
    return prose.getNarrativeSyllableCount();
  }

//   @JsonProperty
//   public final Double getNarrativeSyllablePercentage() {
//     return (double) prose.getNarrativeSyllableCount()
//         / (double) prose.getSyllableCount() * 100;
//   }

  @JsonProperty
  public final Integer getNarrativeUniqueWordCount() {
    return prose.getNarrativeWordFrequency().keySet().size();
  }

  @JsonProperty
  public final Integer getNarrativeWordCount() {
    return prose.getNarrativeWordCount();
  }

  @JsonProperty
  public final List<WordFrequency> getNarrativeWordFrequency() {
    return prose.getNarrativeWordFrequency().entrySet().stream()
        .map(entry ->
            new WordFrequency(entry.getKey().toString(), entry.getValue()))
        .collect(Collectors.toList());
  }

//   @JsonProperty
//   public final Double getNarrativeWordPercentage() {
//     return (double) prose.getNarrativeWordCount()
//         / (double) prose.getWordCount() * 100;
//   }

  @JsonProperty
  public final Integer getParagraphCount() {
    return prose.getParagraphCount();
  }

  @JsonProperty
  public final String getPov() {
    return prose.getPov().toString();
  }

  @JsonProperty
  public final Integer getSentenceCount() {
    return prose.getSentenceCount();
  }

  @JsonProperty
  public final Integer getSyllableCount() {
    return prose.getSyllableCount();
  }

  @JsonProperty
  public final Integer getUniqueWordCount() {
    return prose.getUniqueWordCount();
  }

  @JsonProperty
  public final Set<String> getUniqueWords() {
    return prose.getUniqueWords().stream()
        .map(word -> word.toString())
        .collect(Collectors.toSet());
  }

  @JsonProperty
  public final Integer getWordCount() {
    return prose.getWordCount();
  }

  @JsonProperty
  public final List<WordFrequency> getWordFrequency() {
    return prose.getWordFrequency().entrySet().stream()
        .map(entry ->
            new WordFrequency(entry.getKey().toString(), entry.getValue()))
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
  public final Double getRix() {
    return scores.getRix();
  }

  @JsonProperty
  public final Double getSmogIndex() {
    return scores.getSmog();
  }

  @JsonProperty
  public final PovIndicatorFrequency getPovIndicatorFrequency() {
    return new PovIndicatorFrequency(this.prose);
  }

}
