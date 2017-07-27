package com.prosegrinder.bookworm.restservice.resources;

import com.prosegrinder.bookworm.restservice.api.Analysis;
import com.prosegrinder.bookworm.restservice.api.ProsePayload;
import com.prosegrinder.bookworm.util.Dictionary2;

import java.io.IOException;

import com.codahale.metrics.annotation.Timed;

// import java.util.Optional;
import javax.validation.constraints.NotNull;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
// import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response.Status;

@Path("/analysis")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class AnalysisResource {

  @POST
  @Timed
  public final Analysis getAnalysis(@NotNull final ProsePayload prosePayload) throws IOException {
    try {
      return new Analysis(prosePayload.getText(), Dictionary2.getDefaultDictionary());
    } catch (IOException ioe) {
      throw new WebApplicationException(ioe.getMessage(), Status.NOT_FOUND);
    }
  }

}
