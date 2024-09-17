package ru.toporkov.queue;

import java.lang.reflect.Array;

public class CycledQueue<T> {

    private final Class<T> clazz;
    int start;
    int size;
    private T[] storage;

    public CycledQueue(Class clzz, int length) {
        clazz = clzz;
        start = 0;
        storage = (T[]) Array.newInstance(clazz, length);
    }

    public void enqueue(T element) {
        if (size == storage.length) {
            throw new RuntimeException("Queue is full");
        }

        int lastIndex = (start + size) % storage.length;
        storage[lastIndex] = element;
        size++;
    }

    public T dequeue() {
        if (size == 0) {
            throw new RuntimeException("Queue is empty");
        }

        size--;
        T el = storage[start];
        start = getNextIndex(start);
        return el;
    }


    public int size() {
        return size;
    }

    private int getNextIndex(int pointer) {
        return pointer == storage.length - 1 ? 0 : pointer + 1;
    }
}
