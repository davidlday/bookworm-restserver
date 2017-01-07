package com.prosegrinder;

import static spark.Spark.*;
import com.prosegrinder.bookworm.util.Prose;
import com.prosegrinder.bookworm.util.ReadabilityScores;

public class BookwormRestServer {
    public static void main(String[] args) {
        get("/info", (req, res) -> "Info!");

        post("/analysis", (req, res) -> {
          Prose prose = new Prose(req.queryParams("prose"));
          ReadabilityScores scores = new ReadabilityScores(prose);
          return "Analyzed!";
        });

        post("/extraction", (req, res) -> "Extracted!");
    }
}
