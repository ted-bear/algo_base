package ru.toporkov.order_list;

import java.util.ArrayList;
import java.util.List;

class Node<T> {
    public T value;
    public Node<T> next, prev;

    public Node(T _value) {
        value = _value;
        next = null;
        prev = null;
    }
}

public class OrderedList<T> {
    public Node<T> head, tail;
    private int size;
    private boolean _ascending;

    public OrderedList(boolean asc) {
        head = null;
        tail = null;
        size = 0;
        _ascending = asc;
    }

    public int compare(T v1, T v2) {
        switch (v1) {
            case Integer integer -> {
                return integer.compareTo((Integer) v2);
            }
            case Long l -> {
                return l.compareTo((Long) v2);
            }
            case Double v -> {
                return v.compareTo((Double) v2);
            }
            case Float v -> {
                return v.compareTo((Float) v2);
            }
            case String ignored -> {
                String s1 = v1.toString().trim();
                String s2 = v2.toString().trim();
                return s1.compareTo(s2);
            }
            case null, default -> throw new RuntimeException("Not valid type");
        }
    }

    public void add(T value) {
        Node<T> nodeToAdd = new Node<>(value);
        if (_ascending) {
            addInAscendingOrder(nodeToAdd);
        } else {
            addInDescendingOrder(nodeToAdd);
        }
        size++;
    }

    public Node<T> find(T val) {
        if (head == null) {
            return null;
        }

        return _ascending ? findInAscending(val) : findInDescending(val);
    }

    public boolean is_ascending() {
        return _ascending;
    }

    public void delete(T val) {
        Node<T> current;

        for (current = head;
             current != null && compare(current.value, val) != 0;
             current = current.next
        ) {
        }

        if (current == null) {
            return;
        }

        if (size == 1) {
            head = null;
            tail = null;
        } else if (current == head) {
            head = current.next;
            head.prev = null;
        } else if (current == tail) {
            tail = current.prev;
            tail.next = null;
        } else {
            current.prev.next = current.next;
            current.next.prev = current.prev;
        }
        size--;
    }

    public void clear(boolean asc) {
        _ascending = asc;
        head = null;
        tail = null;
        size = 0;
    }

    public int count() {
        return size;
    }

    public void removeDuplicates() {
        Node<T> first = head;
        Node<T> last = head;

        while (last != null) {
            int countDups = 0;
            while (last != null && first.value == last.value) {
                last = last.next;
                countDups++;
            }

            if (last == null) {
                tail = first;
                first.next = null;
            }

            if (last != null && last.prev != first) {
                first.next = last;
                last.prev = first;
            }

            size -= countDups - 1;
            first = last;
        }
    }

    public boolean isSubList(OrderedList<T> subList) {

        if (subList.head == null) {
            return true;
        }

        Node<T> listPtr = head;
        Node<T> subListPtr = subList.head;

        while (listPtr != null && listPtr.value != subListPtr.value) {
            listPtr = listPtr.next;
        }

        if (listPtr == null) {
            return false;
        }

        while (subListPtr != null && listPtr != null) {
            if (compare(listPtr.value, subListPtr.value) != 0) {
                return false;
            }
            subListPtr = subListPtr.next;
            listPtr = listPtr.next;
        }

        return subListPtr == null;
    }

    public T getMostFrequent() {
        if (head == null) {
            return null;
        }

        Node<T> start = head;
        Node<T> end = head;
        T mostFrequentEl = head.value;
        int maxFrequency = 0;
        int curFrequency = 0;

        while (end != null) {
            if (compare(start.value, end.value) != 0) {
                if (curFrequency > maxFrequency) {
                    maxFrequency = curFrequency;
                    mostFrequentEl = start.value;
                }
                curFrequency = 0;
                start = end;
            } else {
                end = end.next;
                curFrequency++;
            }
        }

        return curFrequency > maxFrequency ? start.value : mostFrequentEl;
    }

    public int getByValue(T value) {
        List<Node<T>> list = getAll();
        int start = 0;
        int end = list.size() - 1;

        while (start <= end) {
            int middle = start + (end - start) / 2;
            T midVal = list.get(middle).value;

            if (compare(midVal, value) < 0) {
                start = middle + 1;
            } else if (compare(midVal, value) > 0) {
                end = middle - 1;
            } else {
                return middle;
            }
        }

        return -(start + 1);
    }

    ArrayList<Node<T>> getAll() {
        ArrayList<Node<T>> r = new ArrayList<Node<T>>();
        Node<T> node = head;
        while (node != null) {
            r.add(node);
            node = node.next;
        }
        return r;
    }

    private Node<T> findInAscending(T val) {

        Node<T> current;

        for (current = head;
             compare(current.value, val) < 0;
             current = current.next
        ) {
        }

        return compare(current.value, val) == 0 ? current : null;
    }

    private Node<T> findInDescending(T val) {

        Node<T> current = head;

        while (compare(current.value, val) > 0) {
            current = current.next;
        }

        return compare(current.value, val) == 0 ? current : null;
    }

    private void addInAscendingOrder(Node<T> value) {
        if (head == null) {
            head = value;
            tail = head;
            return;
        }

        Node<T> current;

        for (current = head;
             current != null && compare(current.value, value.value) < 0;
             current = current.next
        ) {
        }

        if (current == null) {
            tail.next = value;
            value.prev = tail;
            tail = value;
        } else if (current == head) {
            current.prev = value;
            value.next = head;
            head = value;
        } else {
            current.prev.next = value;
            value.prev = current.prev;
            value.next = current;
            current.prev = value;
        }
    }

    private void addInDescendingOrder(Node<T> value) {
        if (tail == null) {
            tail = value;
            head = tail;
            return;
        }

        Node<T> current;

        for (current = tail;
             current != null && compare(current.value, value.value) < 0;
             current = current.prev
        ) {
        }

        if (current == null) {
            head.prev = value;
            value.next = head;
            head = value;
        } else if (current == tail) {
            current.next = value;
            value.prev = tail;
            tail = value;
        } else {
            current.next.prev = value;
            value.next = current.next;
            current.next = value;
            value.prev = current;
        }
    }
}
