package com.coolcats.kotlin102app;

public class Quote {

    private String message;
    private String personName;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public Quote(String message, String personName) {
        this.message = message;
        this.personName = personName;
    }
}
