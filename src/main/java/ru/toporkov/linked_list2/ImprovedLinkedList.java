package ru.toporkov.linked_list2;

import java.util.ArrayList;

public class ImprovedLinkedList {

    Node head;
    Node tail;
    private int size;

    public ImprovedLinkedList() {
        head = new Node(true);
        tail = new Node(true);
        head.next = tail;
        tail.prev = head;
        size = 0;
    }

    public void addInTail(Node _item) {
        tail.prev.next = _item;
        _item.prev = tail.prev;
        tail.prev = _item;
        _item.next = tail;
        size++;
    }

    public Node find(int _value) {
        Node node = head;

        while (node != null) {
            if (node.value == _value) {
                return node;
            }
            node = node.next;
        }

        return null;
    }

    public ArrayList<Node> findAll(int _value) {
        ArrayList<Node> nodes = new ArrayList<Node>();

        Node node = head;

        while (node != null) {
            if (node.value == _value) {
                nodes.add(node);
            }
            node = node.next;
        }

        return nodes;
    }

    public boolean remove(int _value) {
        Node node = head.next;

        while (!node.isDummy && node.value != _value) {
            node = node.next;
        }

        if (node.value == _value) {
            Node temp = node.prev;
            node.prev.next = node.next;
            node.next.prev = temp;
            size--;
            return true;
        }

        return false;
    }

    public void removeAll(int _value) {
        Node node = head.next;

        while (!node.isDummy) {
            if (node.value == _value) {
                Node temp = node.next;
                node.prev.next = temp;
                temp.prev = node.prev;
                node = temp;
                size--;
            } else {
                node = node.next;
            }
        }
    }

    public void clear() {
        head.next = tail;
        tail.prev = head;
        size = 0;
    }

    public int count() {
        return size;
    }

    public void insertAfter(Node _nodeAfter, Node _nodeToInsert) {

        if (_nodeAfter == null) {
            _nodeToInsert.next = head.next;
            head.next.prev = _nodeToInsert;
            head.next = _nodeToInsert;
            _nodeToInsert.prev = head;
            size++;
        }

        Node after = head.next;

        while (!after.isDummy && after != _nodeAfter) {
            after = after.next;
        }

        if (!after.isDummy) {
            _nodeToInsert.next = after.next;
            after.next.prev = _nodeToInsert;
            after.next = _nodeToInsert;
            _nodeToInsert.prev = after;
            size++;
        }
    }
}
