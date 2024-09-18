package ru.toporkov.dequeue;

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
}
