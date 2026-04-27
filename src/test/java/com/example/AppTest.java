package com.example;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
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
        
        container.add(2);
        container.add(1);
        container.add(3);
        container.add(5);
        Integer found2 = container.getInOrder(2);
        Integer found3 = container.getInOrder(5);
        Integer found4 = container.getInOrder(-1);
        Integer found5 = container.getInOrder(1);


        assertNull(found1, "Список пуст");
        assertNotNull(found2, "Элемент 42 должен быть найден");
        assertEquals(3, found2, "Найденный элемент должен быть равен 3");
        assertNull(found3, "Выход за границы списка");
        assertNull(found4, "Отрицательное значение");
        assertEquals(5, found5, "Найденный элемент должен быть равен 5");
    }

    @Test
    public void testAddAndDeleteFirstByValue() {
        Container container = new Container();
        assertDoesNotThrow(() -> container.deleteFirstByValue(2), "Попытка удаления в пустом контейнере не должна вызывать исключений");

        container.add(2);
        container.add(3);
        container.add(4);
        container.add(2);
        container.deleteFirstByValue(2);

        assertEquals(4, container.getInOrder(1), "Найденный элемент должен быть равен 4, 2 должна удалиться");
        assertEquals(2, container.getInOrder(3), "Найденный элемент должен быть равен 2, она не первая");
    }

    @Test
    public void testAddAndDeleteLastByValue() {
        Container container = new Container();
        assertDoesNotThrow(() -> container.deleteLastByValue(10), "Попытка удаления в пустом контейнере не должна вызывать исключений");


        container.add(5);
        container.deleteLastByValue(10);
        container.add(10);
        container.add(10);
        container.add(20);
        container.deleteLastByValue(10);
        
        assertEquals(20, container.getInOrder(1), "Первый элемент должен остаться 20");
        assertEquals(10, container.getInOrder(2), "Второй элемент должен остаться 10");
        assertEquals(5, container.getInOrder(3), "Третий элемент должен стать 5");
        assertNull(container.getInOrder(4), "Четвертого элемента быть не должно");
    }

    @Test
    public void testAddAndDeleteAllByValue() {
        Container container = new Container();
        assertDoesNotThrow(() -> container.deleteAllByValue(1), "Попытка удаления в пустом контейнере не должна вызывать исключений");


        container.add(1);
        container.add(2);
        container.add(1);
        container.add(3);
        container.add(1);
        container.deleteAllByValue(1);
        
        assertEquals(3, container.getInOrder(1), "Первый элемент должен стать 3");
        assertEquals(2, container.getInOrder(2), "Второй элемент должен стать 2");
        assertNull(container.getInOrder(3), "Список должен сократиться до 2 элементов");
        
        Container container2 = new Container();
        container2.add(7);
        container2.add(7);
        container2.add(7);
        container2.deleteAllByValue(7);
        assertTrue(container2.isEmpty(), "Список должен стать пустым после удаления всех вхождений");
    }

    @Test
    public void testAddAndDeleteInOrder() {
        Container container = new Container();
        assertDoesNotThrow(() -> container.deleteInOrder(2), "Попытка удаления в пустом контейнере не должна вызывать исключений");

        container.add(10);
        container.add(20);
        container.add(30);
        container.add(40);
        container.deleteInOrder(2);

        assertEquals(40, container.getInOrder(1), "Первый элемент должен остаться 40");
        assertEquals(20, container.getInOrder(2), "Второй элемент должен стать 20");
        assertEquals(10, container.getInOrder(3), "Третий элемент должен стать 10");
        assertNull(container.getInOrder(4), "Четвертого элемента быть не должно");
        
        container.deleteInOrder(1);
        assertEquals(20, container.getInOrder(1), "Новая голова должна стать 20");
        assertEquals(10, container.getInOrder(2), "Второй элемент должен остаться 10");
        assertDoesNotThrow(() -> container.deleteInOrder(100), "Удаление по несуществующему индексу не должно вызывать исключений");
        assertEquals(20, container.getInOrder(1), "Список должен остаться неизменным после некорректного индекса");
    }

    @Test
    public void testIsEmptyAndClear() {
        Container container = new Container();
        assertTrue(container.isEmpty(), "Список должен быть пуст изначально");
        
        container.add(10);
        container.add(20);
        assertFalse(container.isEmpty(), "Список не должен быть пуст после добавления");
        
        container.clear();
        assertTrue(container.isEmpty(), "Список должен стать пустым после clear()");
        assertNull(container.getInOrder(1), "После очистки поиск по индексу 1 должен вернуть null");
    }
}
