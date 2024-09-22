package ru.toporkov.dequeue;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class DequeTest {

    Deque<Integer> deque;

    @Test
    void getMin_from_empty() {
        deque = new Deque<>();

        assertNull(deque.getMin());
    }

    @Test
    void getMin_single_element() {
        deque = new Deque<>();
        deque.addFront(10);

        assertEquals(10, deque.getMin());
    }

    @Test
    void getMin_pair_elements() {
        deque = new Deque<>();
        deque.addTail(12);
        deque.addFront(10);

        assertEquals(10, deque.getMin());
    }

    @Test
    void getMin_many_elements() {
        deque = new Deque<>();
        deque.addTail(12);
        deque.addFront(10);
        deque.addFront(20);
        deque.addFront(17);
        deque.addFront(41);

        assertEquals(10, deque.getMin());
    }

    @Test
    void getMin_many_with_one_negative_elements() {
        deque = new Deque<>();
        deque.addTail(12);
        deque.addFront(10);
        deque.addFront(-1);
        deque.addFront(20);
        deque.addFront(17);
        deque.addFront(41);

        assertEquals(-1, deque.getMin());
    }

    @Test
    void getMin_pair_elements_zero_and_negative() {
        deque = new Deque<>();
        deque.addFront(-1);
        deque.addFront(0);

        assertEquals(-1, deque.getMin());
    }
}