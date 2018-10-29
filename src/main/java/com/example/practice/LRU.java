package com.example.practice;

import java.util.Hashtable;
import java.util.Map;

public class LRU {

    class Node {
        int key;
        int value;
        Node prev;
        Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private int size;
    Node head;
    Node end;
    Map<Integer, Node> cache = new Hashtable<>();

    public LRU(int size) {
        this.size = size;
    }

    private int get(int key) {
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            remove(node);
            setHead(node);

            return node.value;
        }

        return -1;
    }

    private void insert(int key, int value) {
        if (cache.containsKey(key)) {
            Node old = cache.get(key);
            old.value = value;
            remove(old);
            setHead(old);
        } else {
            Node node = new Node(key, value);
            if (cache.size() >= size) {
                cache.remove(end.key);
                remove(end);
            }
            setHead(node);
            cache.put(key, node);
        }
    }

    private void remove(Node node) {
        if (node.prev != null)
            node.prev.next = node.next;
        else
            head = node.next;

        if (node.next != null)
            node.next.prev = node.prev;
        else
            end = node.prev;
    }

    private void setHead(Node node) {
        node.next = head;
        node.prev = null;

        if( head != null)
            head.prev = node;

        head = node;

        if (end == null)
            end =  head;
    }

}
