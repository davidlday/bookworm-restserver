package com.prosegrinder.bookworm;

import com.prosegrinder.bookworm.util.Prose;
import com.prosegrinder.bookworm.util.ReadabilityScores;
import static spark.Spark.get;
import static spark.Spark.post;
import spark.Request;
import spark.Response;
import spark.Route;

public class RestServer {
    public static void main(String[] args) {
        post("/echo", (request, response) -> {
          response.status(200);
          response.type("application/json");
          return request.body();
        });

//         post("/cat", (request, response) -> {
//           MultipartConfigElement multipartConfigElement = new MultipartConfigElement("/tmp");
//           request.raw().setAttribute("org.eclipse.jetty.multipartConfig", multipartConfigElement);
//           return req.params("text");
//         });

        post("/analysis", (request, response) -> {
          Prose prose = new Prose(request.queryParams("prose"));
          ReadabilityScores scores = new ReadabilityScores(prose);
          response.status(200);
          response.type("application/json");
          return prose.toString();
        });

        post("/extraction", (request, response) -> "Extracted!");
    }
}
