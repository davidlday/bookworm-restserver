package com.prosegrinder.bookworm.restservice.api;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.dropwizard.jackson.JsonSnakeCase;

import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.AutoDetectParser;
import org.apache.tika.sax.BodyContentHandler;
import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.xml.sax.SAXException;

import java.io.InputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@JsonSnakeCase
public class Extraction {

  private final String text;
  private final Map<String, String> md = new HashMap<String, String>();
  private final FormDataContentDisposition contentDisposition;

  @Deprecated
  public Extraction(final InputStream inputStream, final FormDataContentDisposition fileDetail)
      throws IOException, SAXException, TikaException {
    this(inputStream, fileDetail, 1000000);
  }

  public Extraction(final InputStream inputStream, final FormDataContentDisposition fileDetail,
      final Integer writeLimit) throws IOException, SAXException, TikaException {
    this.contentDisposition = fileDetail;

    AutoDetectParser parser = new AutoDetectParser();
    BodyContentHandler handler = new BodyContentHandler(writeLimit);
    Metadata metadata = new Metadata();
    parser.parse(inputStream, handler, metadata);
    this.text = handler.toString();

    String[] metadataNames = metadata.names();
    for (String name : metadataNames) {
      this.md.put(name, metadata.get(name));
    }
  }

  @JsonProperty
  public final String getText() {
    return this.text;
  }

  // @JsonProperty
  // public final Map<String, String> getMetadata() {
  // return this.md;
  // }

  // @JsonProperty
  // public final FormDataContentDisposition getContentDisposition() {
  // return this.contentDisposition;
  // }

  @JsonProperty
  public final String getFileName() {
    return this.contentDisposition.getFileName();
  }

}
