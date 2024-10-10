package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {

    @Mock
    Feline feline;

    @Test
    public void testLion() {
        Exception exception = assertThrows(Exception.class, () ->
                new Lion("Неизвестно", feline));
        String expectedMessage = "Используйте допустимые значения пола животного - самец или самка";
        String actualMessage = exception.getMessage();
        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    public void testGetKittens() throws Exception {
        Lion lion = new Lion("Самец", feline);
        int expected = 1;
        when(feline.getKittens()).thenReturn(expected);
        assertEquals(expected, lion.getKittens());
    }

    @Test
    public void testGetFood() throws Exception {
        Lion lion = new Lion("Самец", feline);
        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        when(feline.getFood("Хищник")).thenReturn(expected);
        List<String> actual = lion.getFood();
        assertEquals(expected, actual);
    }
}
