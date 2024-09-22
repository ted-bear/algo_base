package ru.toporkov.dequeue;

import java.util.Map;
import java.util.Set;

public class DequeUtil {

    public static boolean isPalindrome(String input) {
        Deque<Character> deque = new Deque<>();
        input = input.replaceAll(" ", "").toLowerCase();

        for (Character c : input.toCharArray()) {
            deque.addTail(c);
        }

        while (deque.size() > 1) {
            char first = deque.removeFront();
            char last = deque.removeTail();

            if (first != last) {
                return false;
            }
        }

        return true;
    }

    public static boolean isBalanced(String input) {
        Map<Character, Character> brackets = Map.of(
                '(', ')',
                '[', ']',
                '{', '}'
        );
        Set<Character> closeBrackets = Set.of(')', ']', '}');
        Deque<Character> deque = new Deque<>();

        for (Character character : input.toCharArray()) {
            if (brackets.containsKey(character)) {
                deque.addTail(character);
                continue;
            }

            if (closeBrackets.contains(character)) {
                if (deque.size() == 0) {
                    return false;
                }

                Character bracket = deque.removeTail();
                if (!brackets.get(bracket).equals(character)) {
                    return false;
                }
            }
        }

        return deque.size() == 0;
    }
}
