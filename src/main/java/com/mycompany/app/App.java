package com.mycompany.app;

/**
 * Hello world!
 */
public class App
{

    private final String message = "Hello World!";

    public static void main(String[] args) {
        System.err.println(new App().getMessage());
    }

    private final String getMessage() {
        return message;
    }

}
