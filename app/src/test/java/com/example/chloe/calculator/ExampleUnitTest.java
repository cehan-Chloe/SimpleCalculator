package com.example.chloe.calculator;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }
    @Test
    public void subtract_isCorrect() throws Exception{
        assertEquals(1, 2 - 1);
    }
    @Test
    public void multiple_isCorrect() throws Exception{
        assertEquals(6, 2 * 3);
    }
}