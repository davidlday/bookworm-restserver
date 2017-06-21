package com.prosegrinder.bookworm.restservice.api;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.prosegrinder.bookworm.restservice.api.PovWordFrequency;
import com.prosegrinder.bookworm.util.Word;
import com.prosegrinder.bookworm.util.Prose;
import io.dropwizard.jackson.JsonSnakeCase;

import java.util.ArrayList;
import java.util.List;

@JsonSnakeCase
public class PovIndicatorFrequency {

  private final PovWordFrequency first;
  private final PovWordFrequency second;
  private final PovWordFrequency third;
  private final Integer grandTotalFrequency;

  @JsonCreator
  public PovIndicatorFrequency(@JsonProperty Prose prose) {
    List<WordFrequency> firstList = new ArrayList<WordFrequency>();
    List<WordFrequency> secondList = new ArrayList<WordFrequency>();
    List<WordFrequency> thirdList = new ArrayList<WordFrequency>();

    Integer firstTotal = 0;
    Integer secondTotal = 0;
    Integer thirdTotal = 0;

    for (String word: Word.POV_FIRST) {
      Integer freq = prose.getWordFrequency(new Word(word));
      firstTotal += freq;
      WordFrequency wf = new WordFrequency(word, freq);
      firstList.add(wf);
    }
    this.first = new PovWordFrequency(firstTotal, firstList);

    for (String word: Word.POV_SECOND) {
      Integer freq = prose.getWordFrequency(new Word(word));
      secondTotal += freq;
      WordFrequency wf = new WordFrequency(word, freq);
      secondList.add(wf);
    }
    this.second = new PovWordFrequency(secondTotal, secondList);

    for (String word: Word.POV_THIRD) {
      Integer freq = prose.getWordFrequency(new Word(word));
      thirdTotal += freq;
      WordFrequency wf = new WordFrequency(word, freq);
      thirdList.add(wf);
    }
    this.third = new PovWordFrequency(thirdTotal, thirdList);

    this.grandTotalFrequency = firstTotal + secondTotal + thirdTotal;
  }

  @JsonProperty
  public final Integer getGrandTotalFrequency() {
      return this.grandTotalFrequency;
  }

  @JsonProperty
  public final PovWordFrequency getFirst() {
      return this.first;
  }

  @JsonProperty
  public final PovWordFrequency getSecond() {
      return this.second;
  }

  @JsonProperty
  public final PovWordFrequency getThird() {
      return this.third;
  }

}
