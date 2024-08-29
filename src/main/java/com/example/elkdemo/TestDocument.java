package com.example.elkdemo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "testCollection")
public class TestDocument {
    @Id
    private String id;
    private String message;

    public String getId() {
      return this.id;
    }

    public String getMessage() {
      return this.message;
    }

    public void setId(String id) {
      this.id = id;
    }

    public void setMessage(String message) {
      this.message = message;
    }
}

