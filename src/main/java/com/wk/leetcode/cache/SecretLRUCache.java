package com.wk.leetcode.cache;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class SecretLRUCache<K,V> {

    private int cap = 5;

    private Map<K, Node> map = new HashMap<>();

    private Map<K, Long> keepAlive = new HashMap<>();

    private NodeList nodeList = new NodeList();


    public SecretLRUCache() {
    }

    public synchronized void put(K key, V val) {
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

    public synchronized void  putex(K key, V val, Long aliveTime) {
        put(key, val);
        keepAlive.put(key, aliveTime);
    }

    public synchronized V get(K key) {
        Node node = map.get(key);
        if (node == null) return null;
        Long aliveTime = keepAlive.get(key);
        aliveTime = aliveTime == null ? Long.MAX_VALUE : aliveTime;
        Long hasAlive = new Date().getTime() - node.timestamp;
        if (hasAlive < aliveTime) {
            makeRecent(node);
            return node.getVal();
        }
        deleteNode(node);
        return null;
    }


    private void deleteRecent() {
        Node head = nodeList.head;
        map.remove(head.getKey(), head);
        nodeList.head = head.next;
        nodeList.head.prev = null;
        nodeList.size--;
    }

    private void deleteNode(Node node) {
        Node prev = node.getPrev();
        prev.next = node.next;
        Node next = node.getNext();
        next.prev = node.prev;
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
        long timestamp;

        public Node(V val) {
            this.val = val;
            this.prev = null;
            this.next = null;
            this.timestamp = new Date().getTime();
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

        public long getTimestamp() {
            return timestamp;
        }

        public void setTimestamp(long timestamp) {
            this.timestamp = timestamp;
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
