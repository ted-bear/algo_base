package ru.toporkov.dyn_array;

public class MultiDimensionalArray<T> {

    private static final int DEFAULT_DIMENSION_CAPACITY = 1;

    public int dimensionCount;
    private DynArray<T>[] array;
    private Class clazz;

    public MultiDimensionalArray(Class clz) {
        dimensionCount = DEFAULT_DIMENSION_CAPACITY;
        clazz = clz;
        makeDimensionArray(DEFAULT_DIMENSION_CAPACITY);
    }

    public T getItem(int dimension, int index) {
        validateIndex(dimension, index);
        return array[dimension].getItem(index);
    }

    public DynArray<T> getDimension(int dimension) {
        return array[dimension];
    }

    public void addDimension() {
        DynArray<T>[] temp = new DynArray[dimensionCount + 1];

        System.arraycopy(array, 0, temp, 0, dimensionCount);

        temp[dimensionCount] = new DynArray<>(clazz);
        array = temp;
        dimensionCount++;
    }

    public void append(int dimension, T itm) {
        array[dimension].append(itm);
    }

    public void insert(T itm, int dimension, int index) {
        if (index > array[dimension].count || index < 0) {
            throw new RuntimeException("Index cannot be less than 0 and more than array size");
        }

        validateDimension(dimension);
        array[dimension].insert(itm, index);
    }

    public void remove(int dimension, int index) {
        validateIndex(dimension, index);
        array[dimension].remove(index);
    }

    private void makeDimensionArray(int dimension) {
        array = new DynArray[dimension];

        for (int i = 0; i < dimension; i++) {
            array[i] = new DynArray<>(clazz);
            ;
        }
    }

    private void validateIndex(int dimension, int index) {
        if (index >= array[dimension].count || index < 0) {
            throw new RuntimeException("Index cannot be less than 0 and more than array size");
        }
    }

    private void validateDimension(int dimension) {
        if (dimension >= dimensionCount || dimension < 0) {
            throw new RuntimeException("Dimension cannot be less than 0 and more than dimensions");
        }
    }
}
