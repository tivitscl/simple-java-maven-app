package com.mycompany.app;

/**
 * Hello world!
 */
public class App
{

    private final String message = "Hello World!";

    public App() {}

    public static void main(String[] args) {
        System.out.println("------------------------------------------------------");
        System.out.println(" esta es la clase de la aplicacion mostrando mensaje: ");
        System.out.println("------------------------------------------------------");
        System.out.println(new App().getMessage());
    }

    private final String getMessage() {
        return message;
    }

}
