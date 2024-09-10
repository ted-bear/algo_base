package ru.toporkov.stack;

import java.util.LinkedList;
import java.util.List;

public class Stack<T extends Comparable<T>> {

    private List<T> list;
    private List<T> minList;
    private int size;

    public Stack() {
        list = new LinkedList<>();
        minList = new LinkedList<>();
    }

    public int size() {
        return size;
    }

    public T pop() {
        if (size() != 0) {
            T last = list.getLast();
            list.removeLast();
            minList.removeLast();
            size--;
            return last;
        }
        return null;
    }

    public void push(T val) {
        size++;
        list.add(val);
        updateMin(val);
    }

    public T peek() {
        return size() == 0 ? null : list.getLast();
    }

    public T getMin() {
        if (!list.isEmpty()) {
            return minList.getLast();
        }

        return null;
    }

    private void updateMin(T newElement) {
        if (minList.isEmpty()) {
            minList.add(newElement);
        } else {
            T currentMin = minList.getLast();
            int compareRes = currentMin.compareTo(newElement);
            minList.add(compareRes < 0 ? currentMin : newElement);
        }
    }
}
