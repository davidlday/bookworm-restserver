package com.prosegrinder.bookworm.restservice.api;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.prosegrinder.bookworm.restservice.api.WordFrequency;

import java.util.ArrayList;
import java.util.List;

public class PovWordFrequency {
  private final Integer totalFrequency;
  private final List<WordFrequency> indicatorFrequency
      = new ArrayList<WordFrequency>();

  @JsonCreator
  public PovWordFrequency(@JsonProperty final Integer total,
      @JsonProperty final List<WordFrequency> indicators) {
    this.totalFrequency = total;
    this.indicatorFrequency.addAll(indicators);
  }

  @JsonProperty
  public final Integer getTotalFrequency() {
      return this.totalFrequency;
  }

  @JsonProperty
  public final List<WordFrequency> getIndicatorFrequency() {
      return this.indicatorFrequency;
  }

}
