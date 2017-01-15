package com.prosegrinder.bookworm.restservice.api;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ProsePayload {
  private final String prose;

  @JsonCreator
  public ProsePayload(@JsonProperty("prose") final String text) {
      this.prose = text;
  }

  @JsonProperty("prose")
  public final String getText() {
      return prose;
  }
}
