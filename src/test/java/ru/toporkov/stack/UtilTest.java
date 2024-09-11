package ru.toporkov.stack;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static ru.toporkov.stack.Util.calculateReverse;
import static ru.toporkov.stack.Util.isBalanced;

class UtilTest {

    @Test
    void isBalanced_empty() {
        String brackets = "";
        assertTrue(isBalanced(brackets));
    }

    @Test
    void isBalanced_one_balanced_pair() {
        String brackets = "()";
        assertTrue(isBalanced(brackets));
    }

    @Test
    void isBalanced_one_not_balanced_pair() {
        String brackets = ")(";
        assertFalse(isBalanced(brackets));
    }

    @Test
    void isBalanced_balanced_sequence_deep() {
        String brackets = "((([]))){}{}";
        assertTrue(isBalanced(brackets));
    }

    @Test
    void isBalanced_balanced_sequence_breadth() {
        String brackets = "{}()([()])";
        assertTrue(isBalanced(brackets));
    }

    @Test
    void isBalanced_balanced_sequence() {
        String brackets = "{()(((())))()((()))}";
        assertTrue(isBalanced(brackets));
    }

    @Test
    void isBalanced_not_balanced_sequence_deep() {
        String brackets = "((())))";
        assertFalse(isBalanced(brackets));
    }

    @Test
    void isBalanced_not_balanced_sequence_breadth() {
        String brackets = "()()())";
        assertFalse(isBalanced(brackets));
    }

    @Test
    void isBalanced_not_balanced_sequence() {
        String brackets = "{()()()((())))())";
        assertFalse(isBalanced(brackets));
    }

    @Test
    void isBalanced_not_balanced_sequence_2() {
        String brackets = "((())}";
        assertFalse(isBalanced(brackets));
    }

    @Test
    void calculateRevers_interesting_example() {
        Stack<String> stack = new Stack<>();
        stack.push("=");
        stack.push("+");
        stack.push("9");
        stack.push("*");
        stack.push("5");
        stack.push("+");
        stack.push("2");
        stack.push("8");

        assertEquals(59, calculateReverse(stack));
    }

    @Test
    void calculateRevers_two_elements() {
        Stack<String> stack = new Stack<>();
        stack.push("=");
        stack.push("+");
        stack.push("9");
        stack.push("5");

        assertEquals(14, calculateReverse(stack));
    }

    @Test
    void calculateRevers_single_element() {
        Stack<String> stack = new Stack<>();
        stack.push("=");
        stack.push("9");

        assertEquals(9, calculateReverse(stack));
    }

    @Test
    void calculateRevers_empty_stack() {
        Stack<String> stack = new Stack<>();
        stack.push("=");

        assertNull(calculateReverse(stack));
    }
}