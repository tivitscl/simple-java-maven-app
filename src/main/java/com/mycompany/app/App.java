package com.mycompany.app;
import java.util.logging.Logger;

/**
 * Hello world!
 */
public class App
{
    private final static Logger LOG = Logger.getLogger("com.mycompany.app.App");
    private final String message = "Hello World!";

    public static void main(String[] args) {
        LOG.log( (new App()).getMessage());
    }

    private final String getMessage() {
        return message;
    }

}
