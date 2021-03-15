package com.gyadav.practice.lc;

import java.util.HashMap;
import java.util.Map;

public class LRUCache146 {
    Map<Integer, Node> cacheMap = new HashMap<>();
    Node head = null, tail = null;
    int capacity;
    public LRUCache146(int capacity) {
        this.capacity = capacity;
    }

    public static void main(String[] s) {
        LRUCache146 lRUCache = new LRUCache146(2);
        lRUCache.put(1, 1); // cache is {1=1}
        lRUCache.put(2, 2); // cache is {1=1, 2=2}
        lRUCache.get(1);    // return 1
        lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
        lRUCache.get(2);    // returns -1 (not found)
        lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
        lRUCache.get(1);    // return -1 (not found)
        lRUCache.get(3);    // return 3
        lRUCache.get(4);    // return 4
    }

    public int get(int key) {
        if (cacheMap.containsKey(key)) {
            extractAndMove(cacheMap.get(key));
            return cacheMap.get(key).value;
        }
        return -1;
    }

    public void put(int key, int value) {
        // It's an update
        if (cacheMap.containsKey(key)) {
            cacheMap.get(key).value = value;
            extractAndMove(cacheMap.get(key));
            return;
        }
        // Eviction
        if (cacheMap.size() == capacity) {
            cacheMap.remove(tail.key);
            Node newTail = tail.prev;
            if (newTail != null)
                newTail.next = null;
            tail = newTail;
        }
        // Addition
        Node node = new Node(key, value);
        if (head == null) {
            head = node;
            tail = node;
        } else {
            node.next = head;
            head.prev = node;
            head = node;
        }
        cacheMap.put(key, node);
    }

    private void extractAndMove(Node node) {
        if (head != node) {
            node.prev.next = node.next;
            if (node.next != null) {
                node.next.prev = node.prev;
            } else {
                tail = node.prev;
            }
            node.next = head;
            node.prev = null;
            head.prev = node;
            head = node;
        }
    }

    class Node {
        int key;
        int value;
        Node prev;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}
