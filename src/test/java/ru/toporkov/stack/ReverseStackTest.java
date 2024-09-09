package ru.toporkov.stack;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class ReverseStackTest {

    ReverseStack<Integer> stack;

    @Test
    void push_and_pop() {
        stack = new ReverseStack<>();

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
        stack = new ReverseStack<>();
        stack.push(1);

        assertEquals(1, stack.size());
        assertEquals(1, stack.peek());
        assertEquals(1, stack.pop());
        assertEquals(0, stack.size());
    }

    @Test
    void peek_empty_stack() {
        stack = new ReverseStack<>();
        assertNull(stack.peek());
    }

    @Test
    void pop_empty_stack() {
        stack = new ReverseStack<>();
        assertNull(stack.pop());
    }
}