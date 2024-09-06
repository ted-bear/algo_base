package ru.toporkov.linked_list2;

import java.util.ArrayList;

public class LinkedList2 {
    public Node head;
    public Node tail;
    private int size;

    public LinkedList2() {
        head = null;
        tail = null;
        size = 0;
    }

    public void addInTail(Node _item) {
        if (head == null) {
            this.head = _item;
            this.head.next = null;
            this.head.prev = null;
        } else {
            this.tail.next = _item;
            _item.prev = tail;
        }
        this.tail = _item;
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
        Node node = head;

        while (node != null && node.value != _value) {
            node = node.next;
        }

        if (node == null) {
            return false;
        }

        if (node == head) {
            head = node.next;
            if (head != null) {
                head.prev = null;
                node.next = null;
            }
        }

        if (node == tail) {
            tail = node.prev;
            if (tail != null) {
                tail.next = null;
                node.prev = null;
            }
        }

        Node prevNode = node.prev;
        Node nextNode = node.next;

        if (prevNode != null) {
            prevNode.next = nextNode;
        }

        if (nextNode != null) {
            nextNode.prev = prevNode;
        }

        size--;

        return true;
    }

    public void removeAll(int _value) {
        Node node = head;

//      if there is elements for delete in the head
        while (node != null && node.value == _value) {
            head = node.next;

            if (head != null) {
                head.prev = null;
            }

            if (tail == node) {
                tail = node.prev;
            }

            node.next = null;
            node = head;
            size--;
        }

        while (node != null) {
            if (node.value == _value) {
                Node prevNode = node.prev;
                Node nextNode = node.next;

                prevNode.next = nextNode;

                if (nextNode != null) {
                    nextNode.prev = prevNode;
                } else {
                    tail = prevNode;
                }

                node.next = null;
                node.prev = null;
                node = nextNode;
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
            _nodeToInsert.next = head;

            if (head != null) {
                head.prev = _nodeToInsert;
            }

            head = _nodeToInsert;

            if (tail == null) {
                tail = _nodeToInsert;
            }
        } else {
            Node node = head;

            while (node != null && node != _nodeAfter) {
                node = node.next;
            }

            if (node != null) {
                Node nextNode = node.next;

                if (nextNode == null) {
                    tail = _nodeToInsert;
                } else {
                    nextNode.prev = _nodeToInsert;
                    _nodeToInsert.next = nextNode;
                }

                node.next = _nodeToInsert;
                _nodeToInsert.prev = node;
            }
        }
        size++;
    }
}

class Node {
    public int value;
    public Node next;
    public Node prev;
    public boolean isDummy;

    public Node(boolean isDummy) {
        this.isDummy = isDummy;
    }

    public Node(int _value) {
        value = _value;
        next = null;
        prev = null;
    }
}