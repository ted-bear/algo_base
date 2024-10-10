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

    public void put(String key, T value) {
        int index = getKeyIndex(key);

        if (index >= 0 || length == size) {
            return;
        }

        length++;
        int positionToInsert = -1 * index - 1;
        moveElementsRightByOne(slots, positionToInsert);
        moveElementsRightByOne(values, positionToInsert);
        slots[positionToInsert] = key;
        values[positionToInsert] = value;
    }

    public T get(String key) {
        int index = getKeyIndex(key);
        return (index < 0) ? null : values[index];
    }

    public boolean remove(String key) {
        int index = getKeyIndex(key);

        if (index < 0) {
            return false;
        }

        moveElementsLeftByOne(slots, index);
        moveElementsLeftByOne(values, index);
        values[length - 1] = null;
        slots[length - 1] = null;
        length--;

        return true;
    }

    private int getKeyIndex(String key) {
        return Arrays.binarySearch(slots, 0, length, key);
    }

    private void moveElementsRightByOne(Object[] array, int positionToInsert) {
        System.arraycopy(
                array, positionToInsert,
                array, positionToInsert + 1,
                size - positionToInsert - 1
        );
    }

    private void moveElementsLeftByOne(Object[] array, int positionToRemove) {
        System.arraycopy(
                array, positionToRemove + 1,
                array, positionToRemove,
                size - positionToRemove - 1
        );
    }
}
