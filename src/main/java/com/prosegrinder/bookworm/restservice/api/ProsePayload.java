package com.prosegrinder.bookworm.restservice.api;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ProsePayload {
  private final String text;

  @JsonCreator
  public ProsePayload(@JsonProperty("prose") String text) {
      this.text = text;
  }

  @JsonProperty("prose")
  public String getText() {
      return text;
  }
}
