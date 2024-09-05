package ru.toporkov.linked_list2;

public final class Util {

    public static void reverseList(LinkedList2 list) {
        Node node = list.head;
        list.head = list.tail;
        list.tail = node;

        while (node != null) {
            Node temp = node.next;
            node.next = node.prev;
            node.prev = temp;
            node = temp;
        }
    }

    public static boolean isThereCycle(LinkedList2 list) {

        if (list.head == null) {
            return false;
        }

        if (list.head.next == list.head) {
            return true;
        }

        Node slow = list.head;
        Node fast = list.head.next;

        while (fast != null && fast.next != null && fast != slow) {

            slow = slow.next;
            fast = fast.next.next;

        }

        return fast != null && fast.next != null;
    }

    public static void sort(LinkedList2 list) {

        if (list.count() <= 1) {
            return;
        }

        Node sorted = list.head;

        while (sorted != null) {
            Node minNode = sorted;
            Node node = sorted;

            while (node != null) {
                if (node.value < minNode.value) {
                    minNode = node;
                }
                node = node.next;
            }

            int temp = sorted.value;
            sorted.value = minNode.value;
            minNode.value = temp;
            sorted = sorted.next;
        }
    }

    public static LinkedList2 merge(LinkedList2 list1, LinkedList2 list2) {
        sort(list1);
        sort(list2);

        LinkedList2 result = new LinkedList2();
        Node firstNode = list1.head;
        Node secondNode = list2.head;

        while (firstNode != null && secondNode != null) {
            if (firstNode.value < secondNode.value) {
                result.addInTail(new Node(firstNode.value));
                firstNode = firstNode.next;
            } else {
                result.addInTail(new Node(secondNode.value));
                secondNode = secondNode.next;
            }
        }

        while (firstNode != null) {
            result.addInTail(new Node(firstNode.value));
            firstNode = firstNode.next;
        }

        while (secondNode != null) {
            result.addInTail(new Node(secondNode.value));
            secondNode = secondNode.next;
        }

        return result;
    }
}
