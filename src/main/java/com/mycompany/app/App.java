package com.mycompany.app;
import java.util.logging.Logger;

/**
 * Hello world!
 */
public class App
{
    private static final  Logger LOG = Logger.getLogger("com.mycompany.app.App");
    private static final String message = "Hello World!";

    public static void main(String[] args) {
        getMessage();
        LOG.info("Hello World!");
    }

    private final String getMessage() {
        return message;
    }

}
