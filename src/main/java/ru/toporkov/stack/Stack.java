package ru.toporkov.stack;

import java.util.LinkedList;
import java.util.List;

public class Stack<T> {

    private List<T> list;
    private int size;

    public Stack() {
        list = new LinkedList<>();
    }

    public int size() {
        return size;
    }

    public T pop() {
        if (size() != 0) {
            T last = list.getLast();
            list.removeLast();
            size--;
            return last;
        }
        return null;
    }

    public void push(T val) {
        size++;
        list.add(val);
    }

    public T peek() {
        return size() == 0 ? null : list.getLast();
    }
}
