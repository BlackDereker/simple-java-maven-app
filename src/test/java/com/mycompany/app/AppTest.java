package com.mycompany.app;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.Before;
import org.junit.Test;
import org.junit.After;
import java.util.Random;

import static org.junit.Assert.*;

/**
 * Unit test for simple App.
 */
public class AppTest
{

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final Random random = new Random();

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void testAppAdd()
    {
        try {
            for(int i = 0; i < 100; i++) {
                float rnum = random.nextFloat() * 100f;
                float rnum1 = random.nextFloat() * 100f;
                assertEquals(App.add(rnum, rnum1), rnum + rnum1, 0.0001f);
            }
        } catch (AssertionError e) {
            fail("Failed on Add test" + e);
        }
    }

    @Test
    public void testAppSub()
    {
        try {
            for(int i = 0; i < 100; i++) {
                float rnum = random.nextFloat() * 100f;
                float rnum1 = random.nextFloat() * 100f;
                assertEquals(App.sub(rnum, rnum1), rnum - rnum1, 0.0001f);
            }
        } catch (AssertionError e) {
            fail("Failed on Sub test" + e);
        }
    }

    @Test
    public void testAppMult()
    {
        try {
            for(int i = 0; i < 100; i++) {
                float rnum = random.nextFloat() * 100f;
                float rnum1 = random.nextFloat() * 100f;
                assertEquals(App.mult(rnum, rnum1), rnum * rnum1, 0.0001f);
            }
        } catch (AssertionError e) {
            fail("Failed on Mult test" + e);
        }
    }

    @Test
    public void testAppDiv()
    {
        try {
            for(int i = 0; i < 100; i++) {
                float rnum = random.nextFloat() * 100f + 1;
                float rnum1 = random.nextFloat() * 100f + 1;
                assertEquals(App.mult(rnum, rnum1), rnum / rnum1, 0.0001f);
            }
        } catch (AssertionError e) {
            fail("Failed on Div test" + e);
        }
    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
    }

}
