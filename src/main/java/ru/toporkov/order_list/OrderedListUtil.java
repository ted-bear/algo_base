package ru.toporkov.order_list;

public class OrderedListUtil {

    static <T> OrderedList<T> mergeList(
            OrderedList<T> first,
            OrderedList<T> second
    ) {
        OrderedList<T> merged = new OrderedList<>(true);

        Node<T> firstPtr = first.is_ascending() ?
                first.head :
                first.tail;
        Node<T> secondPtr = second.is_ascending() ?
                second.head :
                second.tail;

        while (firstPtr != null && secondPtr != null) {
            if (first.compare(firstPtr.value, secondPtr.value) < 0) {
                merged.add(firstPtr.value);
                firstPtr = first.is_ascending() ? firstPtr.next : firstPtr.prev;
            } else {
                merged.add(secondPtr.value);
                secondPtr = second.is_ascending() ? secondPtr.next : secondPtr.prev;
            }
        }

        while (firstPtr != null) {
            merged.add(firstPtr.value);
            firstPtr = first.is_ascending() ? firstPtr.next : firstPtr.prev;
        }

        while (secondPtr != null) {
            merged.add(secondPtr.value);
            secondPtr = second.is_ascending() ? secondPtr.next : secondPtr.prev;
        }

        return merged;
    }
}
