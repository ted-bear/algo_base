package ru.toporkov.map;

import java.lang.reflect.Array;
import java.util.Arrays;

public class SortedKeyDictionary<T> {

    public int size;
    public String[] slots;
    public T[] values;
    private int length;

    public SortedKeyDictionary(int sz, Class clazz) {
        size = sz;
        slots = new String[size];
        length = 0;
        values = (T[]) Array.newInstance(clazz, this.size);
    }

    public boolean isKey(String key) {
        int index = Arrays.binarySearch(slots, 0, length, key);
        return index >= 0;
    }

    public void put(String key, T value) {
        int index = Arrays.binarySearch(slots, 0, length, key);

        if (index >= 0 || length == size) {
            return;
        }

        length++;
        int positionToInsert = -1 * index - 1;
        moveElements(slots, positionToInsert);
        moveElements(values, positionToInsert);
        slots[positionToInsert] = key;
        values[positionToInsert] = value;
    }

    public T get(String key) {
        int index = Arrays.binarySearch(slots, 0, length, key);
        return (index < 0) ? null : values[index];
    }

    private void moveElements(Object[] array, int positionToInsert) {
        System.arraycopy(
                array, positionToInsert,
                array, positionToInsert + 1,
                size - positionToInsert - 1
        );
    }
}
