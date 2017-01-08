package com.prosegrinder;

import com.prosegrinder.bookworm.util.Prose;
import com.prosegrinder.bookworm.util.ReadabilityScores;
import static spark.Spark.get;
import static spark.Spark.post;
import spark.Request;
import spark.Response;
import spark.Route;

public class BookwormRestServer {
    public static void main(String[] args) {
        post("/echo", (request, response) -> {
          response.status(200);
          response.type("application/json");
          return request.body();
        });

        post("/params", (req, res) -> {
          return req.params();
        });

        post("/queryParams", (req, res) -> {
          return req.queryParams();
        });

//         post("/cat", (req, res) -> {
//           MultipartConfigElement multipartConfigElement = new MultipartConfigElement("/tmp");
//           request.raw().setAttribute("org.eclipse.jetty.multipartConfig", multipartConfigElement);
//           return req.params("text");
//         });

        post("/analysis", (req, res) -> {
          Prose prose = new Prose(req.queryParams("prose"));
          ReadabilityScores scores = new ReadabilityScores(prose);
          return prose.toString();
        });

        post("/extraction", (req, res) -> "Extracted!");
    }
}
