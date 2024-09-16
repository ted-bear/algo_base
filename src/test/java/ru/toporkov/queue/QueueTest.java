package ru.toporkov.queue;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class QueueTest {

    Queue<Integer> queue;

    @Test
    void enqueue_one_element() {
        queue = new Queue<>();
        queue.enqueue(1);

        assertEquals(1, queue.size());
    }

    @Test
    void dequeue_from_empty() {
        queue = new Queue<>();

        assertEquals(0, queue.size());
        assertNull(queue.dequeue());
    }
}