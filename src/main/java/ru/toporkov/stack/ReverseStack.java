package ru.toporkov.stack;

import java.util.LinkedList;
import java.util.List;

public class ReverseStack<T> {

    private List<T> list;
    private int size;

    public ReverseStack() {
        list = new LinkedList<>();
    }

    public int size() {
        return size;
    }

    public T pop() {
        if (size() != 0) {
            T last = list.getFirst();
            list.removeFirst();
            size--;
            return last;
        }
        return null;
    }

    public void push(T val) {
        size++;
        list.addFirst(val);
    }

    public T peek() {
        return size() == 0 ? null : list.getFirst();
    }
}