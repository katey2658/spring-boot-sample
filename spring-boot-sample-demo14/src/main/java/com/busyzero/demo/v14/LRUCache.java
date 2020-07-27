package com.busyzero.demo.v14;

import java.util.HashMap;
import java.util.Map;

public class LRUCache<K, V> {
    // 容量
    private int capacity;
    // 节点统计
    private int count;
    // 缓存节点
    private Map<K, Node<K, V>> nodeMap;
    private Node<K, V> head;
    private Node<K, V> tail;

    public LRUCache(int capacity) {
        if (capacity < 1) {
            throw new IllegalArgumentException(String.valueOf(capacity));
        }
        this.capacity = capacity;
        this.nodeMap = new HashMap<>(capacity);
        Node headNode = new Node(null, null);
        Node tailNode = new Node(null, null);
        headNode.next = tailNode;
        tailNode.pre = headNode;
        this.head = headNode;
        this.tail = tailNode;
    }

    public void put(K key, V value) {
        Node<K, V> node = nodeMap.get(key);
        if (node == null) {
            if (count >= capacity) {
                removeNode();
            }
            node = new Node<>(key, value);
            addNode(node);
        } else {
            node.value = value;
            moveNodeToHead(node);
        }
    }

    public Node<K, V> get(K key) {
        Node<K, V> node = nodeMap.get(key);
        if (node != null) {
            moveNodeToHead(node);
        }
        return node;
    }

    public void removeNode() {
        Node node = tail.pre;
        if (node == head) {
            return;
        }
        removeFromList(node);
        nodeMap.remove(node.key);
        count--;
    }

    public void removeFromList(Node<K, V> node) {
        Node pre = node.pre;
        Node next = node.next;

        pre.next = next;
        next.pre = pre;

        node.next = null;
        node.pre = null;
    }

    public void moveNodeToHead(Node<K, V> node) {
        removeFromList(node);
        addNode(node);
    }

    public void addNode(Node<K, V> node) {
        Node next = head.next;

        node.next = next;
        node.pre = head;

        next.pre = node;
        head.next = node;
        count++;
    }

    class Node<K, V> {
        K key;
        V value;
        Node pre;
        Node next;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

    }
}
