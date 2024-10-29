package ru.toporkov.linked_list;

public class MergeLinkedList {

    LinkedList merge(LinkedList firstListToMerge, LinkedList secondListToMerge) {
        if (firstListToMerge.count() != secondListToMerge.count()) {
            return null;
        }

        LinkedList linkedList = new LinkedList();
        Node firstNode = firstListToMerge.head;
        Node secondNode = secondListToMerge.head;

        while (firstNode != null) {
            linkedList.addInTail(
                    new Node(firstNode.value + secondNode.value)
            );
            firstNode = firstNode.next;
            secondNode = secondNode.next;
        }

        return linkedList;
    }
}
