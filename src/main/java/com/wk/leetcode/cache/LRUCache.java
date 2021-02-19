package com.wk.leetcode.cache;

import java.util.HashMap;
import java.util.Map;

/**
 * LRU算法，LinkedHashMap
 * 算法思想，用队列保存最近使用的key值
 * @param <K>F
 * @param <V>
 */

public class LRUCache<K,V> {
    private int cap = 5;

    private Map<K,Node> map = new HashMap<>();

    private NodeList nodeList = new NodeList();


    public LRUCache() {
    }

    public void put(K key, V val) {
        if (map.containsKey(key)) {
            Node oldNode = map.get(key);
            makeRecent(oldNode);
            oldNode.val = val;
        } else {
            Node node = new Node(val);
            // 缓存是否已达上限
            if (nodeList.size == cap) {
                deleteRecent();
            }
            map.put(key, node);
            nodeList.tail.next = node;
            node.prev = nodeList.tail;
            nodeList.tail = node;
            nodeList.size++;
        }
    }

    public V get(K key) {
        Node node = map.get(key);
        if (node != null) {
            makeRecent(node);
            return node.getVal();
        }
        return null;
    }

    private void deleteRecent() {
        Node head = nodeList.head;
        map.remove(head.getKey(), head);
        nodeList.head = head.next;
        nodeList.head.prev = null;
        nodeList.size--;
    }

    private void makeRecent(Node node) {
        if (nodeList.tail == node) {
            // 如果当前节点已经在队列尾部，即已经是最新使用的就不用在移动了
            return;
        }
        // 删除老节点
        Node prev = node.getPrev();
        prev.next = node.next;
        Node next = node.getNext();
        next.prev = node.prev;

        // 将节点移到尾部
        node.prev = nodeList.tail;
        node.next = null;
        nodeList.tail = node;
    }



    class Node {
        V val;
        K key;
        Node prev;
        Node next;

        public Node(V val) {
            this.val = val;
            this.prev = null;
            this.next = null;
        }

        public V getVal() {
            return val;
        }

        public void setVal(V val) {
            this.val = val;
        }

        public Node getPrev() {
            return prev;
        }

        public void setPrev(Node prev) {
            this.prev = prev;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public K getKey() {
            return key;
        }

        public void setKey(K key) {
            this.key = key;
        }
    }


    class NodeList {
        Node head;

        Node tail;

        int size;

        public NodeList() {
            this.head = null;
            this.tail = null;
            this.size = 0;
        }

        public Node getHead() {
            return head;
        }

        public void setHead(Node head) {
            this.head = head;
        }

        public Node getTail() {
            return tail;
        }

        public void setTail(Node tail) {
            this.tail = tail;
        }

        public int getSize() {
            return size;
        }

        public void setSize(int size) {
            this.size = size;
        }
    }

}
