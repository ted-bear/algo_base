package ru.toporkov.dyn_array;

public class MultiDimensionalArray<T> {

    public int[] dimensions;
    private Object[] array;
    private Class clazz;

    public MultiDimensionalArray(Class clz, int... dimensions) {
        clazz = clz;
        array = makeDimensionArray(dimensions, 0);
        this.dimensions = dimensions;
    }

    public T getItem(int position, int... index) {
        DynArray<T> array = getArrayByIndex(index);
        return array.getItem(position);
    }

    public void append(T item, int... index) {
        DynArray<T> arr = getArrayByIndex(index);
        arr.append(item);
    }

    public void insert(T item, int position, int... index) {
        validateDimensionIndex(index);
        DynArray<T> arr = getArrayByIndex(index);

        arr.insert(item, position);
    }

    public void remove(int position, int... index) {
        validateDimensionIndex(index);

        DynArray<T> arr = getArrayByIndex(index);
        arr.remove(position);
    }


    public DynArray<T> getArrayByIndex(int[] index) {
        Object[] current = array;

        for (int i = 0; i < index.length - 1; i++) {
            current = (Object[]) current[index[i]];
        }

        return (DynArray<T>) current[index[index.length - 1]];
    }

    private void validateDimensionIndex(int[] index) {
        for (int i = 0; i < index.length; i++) {
            if (index[i] >= dimensions[i] || index[i] < 0) {
                throw new RuntimeException("Index cannot be less than 0 and more than %d dimension size".formatted(i));
            }
        }
    }

    private Object[] makeDimensionArray(int[] dimensions, int depth) {
        int size = dimensions[depth];
        Object[] array = new Object[size];

        for (int i = 0; i < size; i++) {
            if (depth == dimensions.length - 1) {
                array[i] = new DynArray<T>(clazz);
            } else {
                array[i] = makeDimensionArray(dimensions, depth + 1);
            }
        }

        return array;
    }
}
