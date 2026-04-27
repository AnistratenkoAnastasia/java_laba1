package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

/**
 * Unit test for simple App.
 */
public class AppTest {

    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue() {
        assertTrue(true);
    }

    @Test
    public void testAddAndGetInOrder() {
        Container container = new Container();
        Integer found1 = container.getInOrder(2);
        
        container.add(42);
        container.add(10);
        container.add(13);
        container.add(57);
        Integer found2 = container.getInOrder(2);
        Integer found3 = container.getInOrder(5);
        Integer found4 = container.getInOrder(-1);
        Integer found5 = container.getInOrder(1);


        assertNull(found1, "Список пуст");
        assertNotNull(found2, "Элемент 42 должен быть найден");
        assertEquals(13, found2, "Найденный элемент должен быть равен 13");
        assertNull(found3, "Выход за границы списка");
        assertNull(found4, "Отрицательное значение");
        assertEquals(57, found5, "Найденный элемент должен быть равен 57");
    }
}
