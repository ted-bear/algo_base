package ru.toporkov.dyn_array;

import java.lang.reflect.Array;

public class BankDynArray<T> {

    private static final Integer DEFAULT_CAPACITY = 16;

    public T[] array;
    public int count;
    public int capacity;
    public int operationsCount;
    Class clazz;

    public BankDynArray(Class clz) {
        clazz = clz;
        count = 0;
        operationsCount = 0;
        makeArray(DEFAULT_CAPACITY);
    }

    public void makeArray(int new_capacity) {
        T[] tempArray = (T[]) Array.newInstance(clazz, new_capacity);
        capacity = new_capacity;

        if (count > 0) {
            System.arraycopy(array, 0, tempArray, 0, count);
            operationsCount += count * 3;
        }

        array = tempArray;
    }

    /* Always works with constant time O(1) */
    public T getItem(int index) {
        validateIndex(index);
        return array[index];
    }

    /*
     * In the best way, when it is not necessary to expand array it works with O(1)
     * With expand it needs O(n)
     */
    public void append(T itm) {
        operationsCount += 3;
        expandArrayIfNeed();
        array[count] = itm;
        count++;
    }


    /*
     * In the best way, when it is not necessary to expand array it works with O(1)
     * With expand it needs O(n)
     */
    public void insert(T itm, int index) {
        if (index > count || index < 0) {
            throw new RuntimeException("Index cannot be less than 0 and more than array size");
        }

        operationsCount += 3;
        expandArrayIfNeed();

        if (index == count) {
            array[count] = itm;
        } else {
            System.arraycopy(array, index, array, index + 1, count - index);
            operationsCount += (count - index) * 3;
            array[index] = itm;
        }

        count++;
    }

    /* Runs with O(n) */
    public void remove(int index) {
        validateIndex(index);

        if (index != count - 1) {
            System.arraycopy(array, index + 1, array, index, count - index - 1);
        }

        array[count - 1] = null;
        count--;

        if (count * 2 < capacity) {
            int newSize = capacity * 2 / 3;
            newSize = newSize > 16 ? newSize : DEFAULT_CAPACITY;
            makeArray(newSize);
        }
    }

    private void validateIndex(int index) {
        if (index >= count || index < 0) {
            throw new RuntimeException("Index cannot be less than 0 and more than array size");
        }
    }

    private void expandArrayIfNeed() {
        if (operationsCount >= capacity) {
            int newCapacity = capacity * 2;
            int reallocCost = evaluateCost(newCapacity);
            operationsCount -= reallocCost;
            makeArray(newCapacity);
        }
    }

    private int evaluateCost(int capacity) {
        int cost = 1;

        while (cost * 2 < capacity) {
            cost *= 2;
        }

        return cost;
    }
}
