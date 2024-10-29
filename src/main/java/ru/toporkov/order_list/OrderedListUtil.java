package ru.toporkov.order_list;

public class OrderedListUtil {

    static <T> OrderedList<T> mergeList(
            OrderedList<T> first,
            OrderedList<T> second,
            boolean isAsc
    ) {
        OrderedList<T> merged = new OrderedList<>(isAsc);

        Node<T> firstPtr = first.isAscending() ^ isAsc ?
                first.tail :
                first.head;

        Node<T> secondPtr = second.isAscending() ^ isAsc ?
                second.tail :
                second.head;

        while (firstPtr != null && secondPtr != null) {
            if (isAsc) {
                if (first.compare(firstPtr.value, secondPtr.value) < 0) {
                    merged.add(firstPtr.value);
                    firstPtr = first.isAscending() ? firstPtr.next : firstPtr.prev;
                } else {
                    merged.add(secondPtr.value);
                    secondPtr = second.isAscending() ? secondPtr.next : secondPtr.prev;
                }
            } else {
                if (first.compare(firstPtr.value, secondPtr.value) > 0) {
                    merged.add(firstPtr.value);
                    firstPtr = first.isAscending() ? firstPtr.prev : firstPtr.next;
                } else {
                    merged.add(secondPtr.value);
                    secondPtr = second.isAscending() ? secondPtr.prev : secondPtr.next;
                }
            }
        }

        while (firstPtr != null) {
            merged.add(firstPtr.value);
            firstPtr = first.isAscending() ^ isAsc ? firstPtr.prev : firstPtr.next;
        }

        while (secondPtr != null) {
            merged.add(secondPtr.value);
            secondPtr = second.isAscending() ^ isAsc ? secondPtr.prev : secondPtr.next;
        }

        return merged;
    }
}
