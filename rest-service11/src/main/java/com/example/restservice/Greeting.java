package com.example.restservice;
// from https://spring.io/guides/gs/rest-service/
public class Greeting {

    private final long id;
    private final String content;

    public Greeting(long id, String content) {
        this.id = id;
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }
}

//to run: typ "./gradlew bootRun" into terminal