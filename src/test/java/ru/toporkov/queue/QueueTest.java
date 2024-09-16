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

    @Test
    void rotate_one_element() {
        queue = new Queue<>();
        queue.enqueue(1);
        queue.enqueue(2);

        queue.rotate(1);

        assertEquals(2, queue.dequeue());
        assertEquals(1, queue.dequeue());
    }

    @Test
    void rotate_less_than_items() {
        queue = new Queue<>();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);

        queue.rotate(2);

        assertEquals(3, queue.dequeue());
        assertEquals(4, queue.dequeue());
        assertEquals(1, queue.dequeue());
        assertEquals(2, queue.dequeue());
    }

    @Test
    void rotate_equal_than_items() {
        queue = new Queue<>();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);

        queue.rotate(4);

        assertEquals(1, queue.dequeue());
        assertEquals(2, queue.dequeue());
        assertEquals(3, queue.dequeue());
        assertEquals(4, queue.dequeue());
    }

    @Test
    void rotate_more_than_items() {
        queue = new Queue<>();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);

        queue.rotate(6);

        assertEquals(3, queue.dequeue());
        assertEquals(4, queue.dequeue());
        assertEquals(1, queue.dequeue());
        assertEquals(2, queue.dequeue());
    }
}