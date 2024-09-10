package ru.toporkov.stack;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
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
}