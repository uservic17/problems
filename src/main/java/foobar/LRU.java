package foobar;

import java.util.HashMap;
import java.util.Map;

public class LRU {
    //A cache of size 3.. for integers only for now
    //we will use a hashmap
    // the key will be the number.. the value will be a node containing value.. which will be in a queue
    //everytime something is get() from the cache..
    //we will check if the map contains it.. if it does.. take its node and move it to the front of the queue
    //when we put a new item... we put a new node in the queue.. in the front..
    // and take out the last node of the queue..
    //and also take out that key from the node.

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

    Map<Integer, Node> map;
    final int capacity;
    Node head;
    Node tail;


    public LRU(int capacity) {
        map = new HashMap<>(capacity);
        this.capacity = capacity;
    }

    void put (int key, int value) {
        if (map.isEmpty()) {
            Node node = new Node(key, value);
            head = node;
            tail = node;
            map.put(key, node);

        } else if (map.containsKey(key)) {
            map.get(key).value = value;
            bubbleUp(map.get(key));
        } else {
            Node node = new Node(key, value);
            node.next = head;
            head.prev = node;
            head = node;

            map.put(key, node);
            if (capacity < map.size()) {
                removeLastNode();
            }

        }
    }

    private void removeLastNode() {
        Node node = tail;
        map.remove(node.key);
        tail = tail.prev;
        tail.next = null;
    }

    private void bubbleUp(Node node) {
        if (node == head) return;
        if (tail == node) {
            tail = tail.prev;
        }
        node.prev.next = node.next;
        node.prev = null;
        node.next = head;
        head.prev = node;
        head = node;
    }

    int get(int key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            bubbleUp(node);
            return node.value;
        }
        //return value;
        return -1;
    }


    public static void main(String[] args) {
        LRU cache = new LRU( 2 /* capacity */ );

        cache.put(1, 1);
        cache.put(2, 2);
        cache.get(1);       // returns 1
        cache.put(3, 3);    // evicts key 2
        cache.get(2);       // returns -1 (not found)
        cache.put(4, 4);    // evicts key 1
        cache.get(1);       // returns -1 (not found)
        cache.get(3);       // returns 3
        cache.get(4);       // returns 4
    }
}
