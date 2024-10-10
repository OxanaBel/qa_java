package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {

    @InjectMocks
    Cat cat;

    @Mock
    Feline feline;

    @Test
    public void testGetSound() {
        String actual = cat.getSound();
        assertEquals("Мяу", actual);
    }

    @Test
    public void testGetFood() throws Exception{
        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        when(feline.eatMeat()).thenReturn(expected);
        assertEquals(expected, cat.getFood());
    }
}
