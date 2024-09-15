package ru.toporkov.queue;

import java.util.LinkedList;
import java.util.List;

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
}
