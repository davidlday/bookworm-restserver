package com.prosegrinder.bookworm.restservice.resources;

import com.prosegrinder.bookworm.restservice.api.Extraction;
import com.codahale.metrics.annotation.Timed;
import org.apache.tika.exception.TikaException;
import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;
import org.xml.sax.SAXException;

import java.io.InputStream;
import java.io.IOException;
import javax.validation.constraints.NotNull;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/extraction")
@Consumes(MediaType.MULTIPART_FORM_DATA)
@Produces(MediaType.APPLICATION_JSON)
public class ExtractionResource {

  @POST
  @Timed
  public final Extraction getExtraction(
      @NotNull @FormDataParam("file") final InputStream uploadedInputStream,
      @NotNull @FormDataParam("file")
          final FormDataContentDisposition fileDetail)
      throws IOException, SAXException, TikaException  {
    return new Extraction(uploadedInputStream, fileDetail);
  }

}




