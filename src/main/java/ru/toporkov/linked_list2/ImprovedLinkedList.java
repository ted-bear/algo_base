package ru.toporkov.linked_list2;

import java.util.ArrayList;

public class ImprovedLinkedList {

    Node head;
    private int size;

    public ImprovedLinkedList() {
        head = new DummyNode();
        head.next = head;
        head.prev = head;
        size = 0;
    }

    public void addInTail(Node _item) {
        head.prev.next = _item;
        _item.prev = head.prev;
        head.prev = _item;
        _item.next = head;
        size++;
    }

    public Node find(int _value) {
        Node node = head.next;

        while (node != head) {
            if (node.value == _value) {
                return node;
            }
            node = node.next;
        }

        return null;
    }

    public ArrayList<Node> findAll(int _value) {
        ArrayList<Node> nodes = new ArrayList<Node>();

        Node node = head.next;

        while (node != head) {
            if (node.value == _value) {
                nodes.add(node);
            }
            node = node.next;
        }

        return nodes;
    }

    public boolean remove(int _value) {
        Node node = head.next;

        while (isNotNodeDummy(node) && node.value != _value) {
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

        while (isNotNodeDummy(node)) {
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
        head.next = head;
        head.prev = head;
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
        } else {
            Node after = head.next;

            while (isNotNodeDummy(after) && after != _nodeAfter) {
                after = after.next;
            }

            if (isNotNodeDummy(after)) {
                _nodeToInsert.next = after.next;
                after.next.prev = _nodeToInsert;
                after.next = _nodeToInsert;
                _nodeToInsert.prev = after;
                size++;
            }
        }
    }

    private boolean isNotNodeDummy(Node node) {
        return !(node instanceof DummyNode);
    }
}

class DummyNode extends Node {

    public DummyNode() {

    }
}
