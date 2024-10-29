package ru.toporkov.linked_list;

import java.util.ArrayList;

public class LinkedList {

    public Node head;
    public Node tail;
    private int size;

    public LinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    public void addInTail(Node item) {
        if (head == null)
            head = item;
        else
            tail.next = item;
        tail = item;
        size++;
    }

    public Node find(int value) {
        Node node = head;

        while (node != null) {
            if (node.value == value) {
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

        if (head == null) {
            return false;
        }

        Node node = head;

        // First element is equal value
        if (node.value == _value) {
            head = node.next;
            boolean isTail = tail == node;
            if (isTail) {
                tail = node.next;
            }
            size--;
            return true;
        }

        while (node.next != null && node.next.value != _value) {
            node = node.next;
        }

        // Element was found
        if (node.next != null) {
            if (node.next.next == null) {
                tail = node;
            }
            node.next = node.next.next;
            size--;
            return true;
        }

        return false;
    }

    public void removeAll(int _value) {
        Node node = head;

        while (node != null && node.value == _value) {
            head = node.next;
            if (tail == node) {
                tail = node.next;
            }
            node = head;
            size--;
        }

        while (node != null && node.next != null) {
            if (node.next.value == _value) {

                if (node.next.next == null) {
                    tail = node;
                }

                node.next = node.next.next;
                size--;
            } else {
                node = node.next;
            }
        }
    }

    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    public int count() {
        return size;
    }

    public void insertAfter(Node _nodeAfter, Node _nodeToInsert) {
        if (_nodeAfter == null) {
            if (tail == null) {
                tail = _nodeToInsert;
            } else {
                _nodeToInsert.next = head;
            }
            head = _nodeToInsert;
        } else {
            Node node = head;

            while (node != _nodeAfter) {
                node = node.next;
            }

            if (node.next == null) {
                tail = _nodeToInsert;
            }

            _nodeToInsert.next = node.next;
            node.next = _nodeToInsert;
        }
        size++;
    }
}

class Node {

    int value;
    Node next;

    Node(int value) {
        this.value = value;
    }
}
