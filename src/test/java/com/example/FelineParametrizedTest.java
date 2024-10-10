package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class FelineParametrizedTest {

    Feline feline = new Feline();

    private final int expected;
    private final int count;

    public FelineParametrizedTest(int expected, int count) {
        this.expected = expected;
        this.count = count;
    }

    @Parameterized.Parameters
    public static Object[][] getParameters() {
        return new Object[][]{
                {0, 0},
                {5, 5},
                {10, 10},
        };
    }

    @Test
    public void testGetKittens() {
        assertEquals("Неверное количество котят", expected, feline.getKittens(count));
    }
}
