package ru.toporkov.dequeue;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static ru.toporkov.dequeue.DequeUtil.isPalindrome;

class DequeUtilTest {

    @Test
    void isPalindrome_empty_string() {
        boolean result = isPalindrome("");
        assertTrue(result);
    }

    @Test
    void isPalindrome_one_el_string() {
        boolean result = isPalindrome("f");
        assertTrue(result);
    }

    @Test
    void isPalindrome_two_el_palindrome_string() {
        boolean result = isPalindrome("ff");
        assertTrue(result);
    }

    @Test
    void isPalindrome_two_el_not_palindrome_string() {
        boolean result = isPalindrome("af");
        assertFalse(result);
    }

    @Test
    void isPalindrome_three_el_not_palindrome_string() {
        boolean result = isPalindrome("afb");
        assertFalse(result);
    }

    @Test
    void isPalindrome_three_el_palindrome_string() {
        boolean result = isPalindrome("afa");
        assertTrue(result);
    }

    @Test
    void isPalindrome_two_words_palindrome() {
        String input = "work krow";
        boolean result = isPalindrome(input);

        assertTrue(result);
    }

    @Test
    void isPalindrome_two_words_not_palindrome() {
        String input = "work Drow";
        boolean result = isPalindrome(input);

        assertFalse(result);
    }

    @Test
    void isPalindrome_many_els_palindrome() {
        String input = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
        boolean result = isPalindrome(input);

        assertTrue(result);
    }
}