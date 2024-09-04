package ru.toporkov.linked_list2;

public final class Util {

    public static LinkedList2 reverseList(LinkedList2 list) {
        Node node = list.head;
        list.head = list.tail;
        list.tail = node;

        while (node != null) {
            Node temp = node.next;
            node.next = node.prev;
            node.prev = temp;
            node = temp;
        }

        return list;
    }
}
