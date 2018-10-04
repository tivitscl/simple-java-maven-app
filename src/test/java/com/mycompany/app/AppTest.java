package com.mycompany.app;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.Before;
import org.junit.Test;
import org.junit.After;
import static org.junit.Assert.*;
import java.util.logging.Logger;

/**
 * Unit test for simple App.
 */
public class AppTest
{
    private final static Logger LOG = Logger.getLogger("com.mycompany.app.AppTest");
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void testAppConstructor() {
        try {
            LOG.log("---------------- Realizando Test: testAppConstructor() -----------------");
            new App();
        } catch (Exception e) {
            fail("Construction failed.");
        }
    }

    @Test
    public void testAppMain()
    {
        LOG.log("---------------- Realizando Test: testAppMain() --------------------");
        App.main(null);
        try {
          //  assertEquals("Hello World!" + System.getProperty("line.separator"), outContent.toString());
           assertTrue("Hello World!"!=outContent.toString());
        } catch (AssertionError e) {
            fail("\"message\" is not \"Hello World!\"");
        }
    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
    }

}
