package ru.toporkov.queue;

import ru.toporkov.stack.Stack;

public class QueueOnStack<T extends Comparable<T>> {

    private final Stack<T> stack;
    private final Stack<T> additional;

    public QueueOnStack() {
        this.stack = new Stack<>();
        this.additional = new Stack<>();
    }

    public void enqueue(T item) {
        stack.push(item);
    }

    public T dequeue() {
        if (size() <= 0) {
            return null;
        }

        while (stack.size() != 0) {
            additional.push(stack.pop());
        }

        T element = additional.pop();

        while (additional.size() != 0) {
            stack.push(additional.pop());
        }

        return element;
    }

    public int size() {
        return stack.size();
    }
}
