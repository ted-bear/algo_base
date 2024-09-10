package ru.toporkov.stack;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class StackTest {

    Stack<Integer> stack;

    @Test
    void push_and_pop() {
        stack = new Stack<>();

        for (int i = 0; i < 10; i++) {
            stack.push(i + 1);
        }

        assertEquals(10, stack.size());

        for (int i = 10; i > 0; i--) {
            assertEquals(i, stack.pop());
        }

        assertEquals(0, stack.size());
    }

    @Test
    void push_and_pop_single_element() {
        stack = new Stack<>();
        stack.push(1);

        assertEquals(1, stack.size());
        assertEquals(1, stack.peek());
        assertEquals(1, stack.pop());
        assertEquals(0, stack.size());
    }

    @Test
    void peek_empty_stack() {
        stack = new Stack<>();
        assertNull(stack.peek());
    }

    @Test
    void pop_empty_stack() {
        stack = new Stack<>();
        assertNull(stack.pop());
    }

    @Test
    void getMin_empty_stack() {
        stack = new Stack<>();
        assertNull(stack.getMin());
    }

    @Test
    void getMin_single_element() {
        stack = new Stack<>();
        stack.push(2);
        assertEquals(2, stack.getMin());
    }

    @Test
    void getMin_single_negative_element() {
        stack = new Stack<>();
        stack.push(-2);
        assertEquals(-2, stack.getMin());
    }

    @Test
    void getMin_pair_elements() {
        stack = new Stack<>();
        stack.push(2);

        assertEquals(2, stack.getMin());

        stack.push(1);

        assertEquals(1, stack.getMin());
    }

    @Test
    void getMin_pair_elements_and_delete() {
        stack = new Stack<>();
        stack.push(2);

        assertEquals(2, stack.getMin());

        stack.push(1);

        assertEquals(1, stack.getMin());

        assertEquals(1, stack.pop());

        assertEquals(2, stack.getMin());
    }

    @Test
    void getMin_pair_neg_elements_and_delete() {
        stack = new Stack<>();
        stack.push(-2);

        assertEquals(-2, stack.getMin());

        stack.push(-1);

        assertEquals(-2, stack.getMin());

        assertEquals(-1, stack.pop());

        assertEquals(-2, stack.getMin());
    }

    @Test
    void getMean_pair_neg_elements_and_delete() {
        stack = new Stack<>();
        stack.push(-2);
        stack.push(-1);

        assertEquals(-1.5, stack.getMean());
    }

    @Test
    void getMean_empty() {
        stack = new Stack<>();

        assertNull(stack.getMean());
    }

    @Test
    void getMean_single_el() {
        stack = new Stack<>();
        stack.push(21);

        assertEquals(21, stack.getMean());
    }

    @Test
    void getMean_multiple_elements() {
        stack = new Stack<>();

        for (int i = 1; i < 11; i++) {
            stack.push(i);
        }

        assertEquals(5.5, stack.getMean());
    }
}