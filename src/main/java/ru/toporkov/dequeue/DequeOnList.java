package ru.toporkov.dequeue;

import java.util.LinkedList;
import java.util.List;

public class DequeOnList<T> {

    private List<T> list;

    public DequeOnList() {
        list = new LinkedList<>();
    }

    public void addFront(T item) {
        list.addFirst(item);
    }

    public void addTail(T item) {
        list.addLast(item);
    }

    public T removeFront() {
        return size() == 0 ? null : list.removeFirst();
    }

    public T removeTail() {
        return size() == 0 ? null : list.removeLast();
    }

    public int size() {
        return list.size();
    }
}
