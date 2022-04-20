package com.codestates.week2ass1.models;

public class Models {
    private String name;
    private String job;
    private String message;

    public Models() {
    }

    public Models(String name, String job, String message) {
        this.name = name;
        this.job = job;
        this.message = message;
    }

    public String getName() {
        return this.name;
    }

    public String getJob() {
        return this.job;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public void setName(String name) {
        this.name = name;
    }
}