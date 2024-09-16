package ru.toporkov.queue;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Queue<T> {

    private final List<T> list;

    public Queue() {
        list = new LinkedList<>();
    }

    // enqueue method works for O(1)
    public void enqueue(T item) {
        list.addLast(item);
    }

    // dequeue method works for O(1)
    public T dequeue() {
        if (size() > 0) {
            return list.removeFirst();
        }

        return null;
    }

    public int size() {
        return list.size();
    }

    public void rotate(int n) {
        if (n % size() == 0) {
            return;
        }

        n = n % size();

        for (int i = 0; i < n; i++) {
            enqueue(dequeue());
        }
    }

    public void reverse() {
        if (size() <= 1) {
            return;
        }

        Stack<T> stack = new Stack<>();

        while (size() != 0) {
            stack.push(dequeue());
        }

        while (!stack.empty()) {
            enqueue(stack.pop());
        }
    }
}
