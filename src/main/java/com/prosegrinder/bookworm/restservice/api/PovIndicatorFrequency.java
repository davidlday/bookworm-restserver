package com.prosegrinder.bookworm.restservice.api;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.prosegrinder.bookworm.restservice.api.PovWordFrequency;
import com.prosegrinder.bookworm.util.Word;
import com.prosegrinder.bookworm.util.Prose;

import java.util.ArrayList;
import java.util.List;

public class PovIndicatorFrequency {

  private final PovWordFrequency first;
  private final PovWordFrequency second;
  private final PovWordFrequency third;
  private final Integer grandTotalFrequency;

  @JsonCreator
  public PovIndicatorFrequency(@JsonProperty Prose prose) {
    this.first = new PovWordFrequency();
    this.second = new PovWordFrequency();
    this.third = new PovWordFrequency();
    this.grandTotalFrequency = 0;
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
