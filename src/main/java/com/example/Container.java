package com.example;

/**
 * Контейнер для хранения произвольного количества целых чисел,
 * реализованный на основе односвязного списка.
 * <p>
 * Элементы добавляются в начало списка (метод {@code add} работает по принципу стека).
 * Индексация в методах поиска и удаления начинается с 1.
 * Потокобезопасность не гарантируется.
 */
public class Container {

    /**
     * Внутренний класс, представляющий узел односвязного списка.
     * Хранит целочисленные данные и ссылку на следующий узел.
     */
    static class Node {
        private int data;
        private Node next;
    }

    private Node head;

    /**
     * Проверяет, содержит ли контейнер элементы.
     *
     * @return {@code true}, если список пуст, иначе {@code false}
     */
    public boolean isEmpty() {
        return head == null;
    }

    /**
     * Добавляет целое число в контейнер.
     * Новый элемент помещается в начало списка и становится {@code head}.
     *
     * @param x добавляемое целое число
     */
    public void add(int x) {
        Node node = new Node();
        node.data = x;
        node.next = head;
        head = node;
    }

    /**
     * Возвращает значение элемента по его порядковому номеру в списке.
     * Нумерация элементов начинается с 1.
     *
     * @param n порядковый номер элемента (целое число &gt; 0)
     * @return значение элемента, или {@code null}, если индекс некорректен,
     *         выходит за границы списка или контейнер пуст
     */
    public Integer getInOrder(int n) {
        if (n <= 0) return null;
        if (isEmpty()) return null;
        
        Node node = head;
        for (int i = 1; i < n; ++i) {
            if (node.next == null)
                return null;
            node = node.next;
        }
        return node.data;
    }

    /**
     * Удаляет первое вхождение заданного значения из списка.
     * Поиск выполняется от начала списка к концу.
     * Если элемент не найден, состояние списка не изменяется.
     *
     * @param x значение для удаления
     */
    public void deleteFirstByValue(int x) {
        if (!isEmpty()) {
            if (head.data == x)
                head = head.next;
            else {
                Node node = head;
                boolean flag = false;
                while (node.next != null && !flag) {
                    if (node.next.data == x) {
                        node.next = node.next.next;
                        flag = true;
                    }
                    node = node.next;
                }
            }
        }
    }

    /**
     * Удаляет последнее вхождение заданного значения из списка.
     * Проход выполняется до конца списка для определения самого правого вхождения.
     *
     * @param x значение для удаления
     */
    public void deleteLastByValue(int x) {
        if (!isEmpty()) {
            Node node = head;
            Node delNode = null;
            while (node.next != null) {
                if (node.next.data == x)
                    delNode = node;
                node = node.next;
            }
            if (delNode != null)
                delNode.next = delNode.next.next;
        }
    }

    /**
     * Удаляет все вхождения заданного значения из списка.
     * Корректно обрабатывает случаи, когда одинаковые элементы идут подряд.
     *
     * @param x значение для удаления
     */
    public void deleteAllByValue(int x) {
        while (head != null && head.data == x)
            head = head.next;

        if (!isEmpty()) {
            Node node = head;
            while (node.next != null) {
                if (node.next.data == x)
                    node.next = node.next.next;
                else node = node.next;
            }
        }
    }

    /**
     * Удаляет элемент по его порядковому номеру в списке.
     * Нумерация начинается с 1.
     * Если индекс выходит за границы списка или некорректен, операция игнорируется.
     *
     * @param n порядковый номер элемента для удаления (целое число &gt; 0)
     */
    public void deleteInOrder(int n) {
        if (!isEmpty()) {
            if (n > 0) {
                if (n == 1)
                    head = head.next;
                else {
                    Node node = head;
                    for (int i = 1; i < n - 1; ++i) {
                        if (node != null)
                            node = node.next;
                    }
                    if (node != null)
                        node.next = node.next.next;
                }
            }
        }
    }

    /**
     * Полностью очищает контейнер, удаляя все элементы.
     * Освобождает ссылки на узлы, позволяя сборщику мусора reclaim память.
     * После вызова {@link #isEmpty()} вернёт {@code true}.
     */
    public void clear() {
        head = null;
    }
}