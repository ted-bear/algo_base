package ru.toporkov.cache;

import java.lang.reflect.Array;
import java.util.Objects;

public class NativeCache<T> {

    private final String[] slots;
    private final T[] values;
    private final int[] hits;
    private int size;

    public NativeCache(int sz, Class clazz) {
        size = 0;
        slots = new String[sz];
        values = (T[]) Array.newInstance(clazz, sz);
        hits = new int[sz];
    }

    public void put(String key, T value) {
        if (size == slots.length) {
            removeLessFrequent();
        }

        int index = seekSlot(key);
        slots[index] = key;
        values[index] = value;
    }

    public T get(String key) {
        int firstIndex = hashFun(key);

        if (Objects.equals(slots[firstIndex], key)) {
            hits[firstIndex]++;
            size++;
            return values[firstIndex];
        }

        int index = getIndex(firstIndex);

        while (index != firstIndex) {
            if (Objects.equals(slots[index], key)) {
                hits[index]++;
                size++;
                return values[index];
            }
            index = getIndex(index);
        }

        return null;
    }

    public int getSize() {
        return size;
    }

    private void removeLessFrequent() {
        int minFrequencyIndex = 0;

        for (int i = 1; i < size; i++) {
            if (hits[i] < hits[minFrequencyIndex]) {
                minFrequencyIndex = i;
            }
        }

        slots[minFrequencyIndex] = null;
        values[minFrequencyIndex] = null;
        hits[minFrequencyIndex] = 0;
    }

    private int seekSlot(String key) {
        int firstIndex = hashFun(key);

        if (slots[firstIndex] == null) {
            return firstIndex;
        }

        int index = getIndex(firstIndex);

        while (index != firstIndex) {
            if (slots[index] == null) {
                return index;
            }
            index = getIndex(index);
        }

        return index;
    }

    private int hashFun(String key) {
        int charSum = Math.abs(key.hashCode());
        return charSum % size;
    }

    private int getIndex(int index) {
        return index + 1 < size ?
                index + 1 : 0;
    }
}
