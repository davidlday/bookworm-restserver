package com.prosegrinder.bookworm.restservice.resources;

import com.prosegrinder.bookworm.restservice.api.Analysis;
import com.prosegrinder.bookworm.restservice.api.ProsePayload;
import com.prosegrinder.bookworm.util.Dictionary2;

import com.codahale.metrics.annotation.Timed;

// import java.util.Optional;
import javax.validation.constraints.NotNull;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
// import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/analysis")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class AnalysisResource {

  private Dictionary2 dictionary;
  
  @POST
  @Timed
  public final Analysis getAnalysis(@NotNull final ProsePayload prosePayload) {
    return new Analysis(prosePayload.getText(), this.dictionary);
  }

  public AnalysisResource(Dictionary2 dictionary) {
    this.dictionary = dictionary;
  }
}
