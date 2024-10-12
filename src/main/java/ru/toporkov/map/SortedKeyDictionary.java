package ru.toporkov.map;

import ru.toporkov.order_list.OrderedList;

import java.lang.reflect.Array;

public class SortedKeyDictionary<T> {

    public int size;
    public OrderedList<String> slots;
    public T[] values;
    private int length;

    public SortedKeyDictionary(int sz, Class clazz) {
        size = sz;
        slots = new OrderedList<>(true);
        length = 0;
        values = (T[]) Array.newInstance(clazz, this.size);
    }

    public void put(String key, T value) {
        int index = slots.getByValue(key);

        if (index >= 0 || length == size) {
            return;
        }

        length++;
        int positionToInsert = -1 * index - 1;
        moveElementsRightByOne(values, positionToInsert);
        slots.add(key);
        values[positionToInsert] = value;
    }

    public T get(String key) {
        int index = slots.getByValue(key);
        return (index < 0) ? null : values[index];
    }

    public boolean remove(String key) {
        int index = slots.getByValue(key);

        if (index < 0) {
            return false;
        }

        slots.delete(key);
        moveElementsLeftByOne(values, index);
        values[length - 1] = null;
        length--;

        return true;
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
