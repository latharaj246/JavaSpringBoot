package com.latha.FirstSpringApplication;

public class HelloResponse {

    private String message;

    public HelloResponse(String message) {
        this.message = message;
    }

    //Setter
    public String getMessage() {
        return message;
    }

    //Getter
    public void setMessage(String message) {
        this.message = message;
    }

}
