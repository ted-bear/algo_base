package ru.toporkov.dequeue;

import java.util.LinkedList;
import java.util.List;

public class Deque<T extends Comparable<T>> {

    private final List<T> list;
    private final List<T> mins;
    private T minElement;

    public Deque() {
        list = new LinkedList<>();
        mins = new LinkedList<>();
    }

    public void addFront(T item) {
        if (size() == 0 || mins.getFirst().compareTo(item) > 0) {
            mins.addFirst(item);
        } else {
            mins.addFirst(mins.getFirst());
        }

        list.addFirst(item);
    }

    public void addTail(T item) {
        if (size() == 0 || mins.getLast().compareTo(item) > 0) {
            mins.addLast(item);
        } else {
            mins.addLast(mins.getLast());
        }

        list.addLast(item);
    }

    public T removeFront() {
        mins.removeFirst();
        return size() == 0 ? null : list.removeFirst();
    }

    public T removeTail() {
        mins.removeLast();
        return size() == 0 ? null : list.removeLast();
    }

    public int size() {
        return list.size();
    }

    public T getMin() {
        if (size() == 0) {
            return null;
        }

        T firstMin = mins.getFirst();
        T lastMin = mins.getLast();
        return firstMin.compareTo(lastMin) > 0 ? lastMin : firstMin;
    }
}
