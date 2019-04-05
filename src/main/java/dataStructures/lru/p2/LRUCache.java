package dataStructures.lru.p2;

import java.util.HashMap;
import java.util.Map;

class LRUCache {

    class Node {
        int value;
        Node next;
        Node prev;

        Node(int value) {
            this.value = value;
        }
    }

    Map<Integer, Node> map;
    int capacity;
    int size;
    Node head;
    Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        size = 0;
    }

    public int get(int key) {
        //map does not contain the key - return -1
        if (!map.containsKey(key)) return -1;
        //map contains the key
        //move the node to the top. Update head and tail
        Node current = map.get(key);
        //if current is at the top
        if (head == current) return current.value;
        //if current is in the middle or end
        current.prev.next = current.next;
        if (tail == current) { //if current is tail
            tail = current.prev;
        }
        current.prev = null; //importante
        current.next = head;
        head.prev = current;
        head = current;
        return current.value;

    }

    public void put(int key, int value) {
        Node node = new Node(value);
        //map is empty
        if (map.size() == 0 && map.size() < capacity) {
            map.put(key, node);
            head = node;
            tail = node;
            return;
        }
        //map does not contain the key.
        if (!map.containsKey(key)) {
            // size < capacity, add a new one.. update head (and tail if required)
            if (map.size() < capacity) {
                map.put(key, node);
                node.next = head;
                head.prev = node;
                head = node;
                return;
            } else {
                // size == capacity, remove the last, update tail. Add a new one.
                map.put(key, node);
                map.remove(tail.value);
                if (tail.prev != null) {
                    tail.prev.next = null;
                    tail = tail.prev;
                }

                node.next = head;
                head.prev = node;
                head = node;
                if (capacity == 1) tail = head;
                return;
            }

        } else {
            // map contains the key
            //need to update head and tail pointers;
            node = map.get(key);
            //if node at the top
            if (head == node) return;
            //if node at tail
            if (tail == node) {
                tail.prev.next = null;
                tail = tail.prev;
                node.next = head;
                head.prev = node;
                head = node;
                return;
            }
            //if node in the middle
            node.next.prev = node.prev;
            node.prev.next = node.next;
            node.next = head;
            head.prev = node;
            head = node;
        }
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(1 /* capacity */);

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