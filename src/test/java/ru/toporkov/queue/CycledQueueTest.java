package ru.toporkov.queue;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CycledQueueTest {

    CycledQueue<Integer> queue;

    @Test
    void enqueue_one() {
        queue = new CycledQueue<>(Integer.class, 1);
        queue.enqueue(1);

        assertEquals(1, queue.size());
        assertEquals(0, queue.start);
    }

    @Test
    void enqueue_many_els() {
        queue = new CycledQueue<>(Integer.class, 4);
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);

        assertEquals(4, queue.size());
        assertEquals(0, queue.start);
    }

    @Test
    void enqueue_many_els_with_cycle() {
        queue = new CycledQueue<>(Integer.class, 4);
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);

        assertEquals(4, queue.size());
        assertEquals(0, queue.start);

        assertEquals(1, queue.dequeue());
        assertEquals(2, queue.dequeue());

        assertEquals(2, queue.size());
        assertEquals(2, queue.start);

        queue.enqueue(5);
        queue.enqueue(6);
    }

    @Test
    void dequeue_from_empty_queue() {
        queue = new CycledQueue<>(Integer.class, 4);

        assertThrows(RuntimeException.class, () -> queue.dequeue());
    }

    @Test
    void dequeue_one_element() {
        queue = new CycledQueue<>(Integer.class, 1);
        queue.enqueue(1);

        assertEquals(1, queue.dequeue());
    }

    @Test
    void dequeue_after_cycle() {
        queue = new CycledQueue<>(Integer.class, 4);
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);

        assertEquals(1, queue.dequeue());
        assertEquals(2, queue.dequeue());
        assertEquals(3, queue.dequeue());

        queue.enqueue(5);
        queue.enqueue(6);
        queue.enqueue(7);

        assertEquals(4, queue.dequeue());
        assertEquals(5, queue.dequeue());
        assertEquals(2, queue.size());
    }
}