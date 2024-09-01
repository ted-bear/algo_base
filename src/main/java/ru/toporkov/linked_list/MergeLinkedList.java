package ru.toporkov.linked_list;

public class MergeLinkedList {

    LinkedList merge(LinkedList ll1, LinkedList ll2) {
        if (ll1.count() != ll2.count()) {
            return null;
        }

        LinkedList linkedList = new LinkedList();
        Node firstNode = ll1.head;
        Node secondNode = ll2.head;

        while (firstNode != null) {
            int sum = firstNode.value + secondNode.value;
            linkedList.addInTail(new Node(sum));
            firstNode = firstNode.next;
            secondNode = secondNode.next;
        }

        return linkedList;
    }
}
