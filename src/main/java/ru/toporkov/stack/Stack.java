package ru.toporkov.stack;

import java.util.LinkedList;
import java.util.List;

public class Stack<T extends Comparable<T>> {

    private final List<T> list;
    private final List<T> minList;
    private Double sum;
    private int size;

    public Stack() {
        list = new LinkedList<>();
        minList = new LinkedList<>();
        sum = 0.;
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
        if (val instanceof java.lang.Number) {
            sum += Double.parseDouble(val.toString());
        }
        size++;
        list.add(val);
        updateMin(val);
    }

    public Double getMean() {
        return size() == 0 ? null : sum / size();
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

            currentMin = null;
        }
    }
}
