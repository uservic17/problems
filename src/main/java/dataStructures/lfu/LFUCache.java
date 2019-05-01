package dataStructures.lfu;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

class LFUCache {
    class Node {
        int key;
        int value;
        int freq;
//        Node prev, next;
        Node(int key, int value) {
            this.key = key;
            this.value = value;
            freq = 0;
        }
    }
    final int capacity;
    int minFrequency;
    Map<Integer, Node> map1;
    Map<Integer, Deque<Node>> freqMap;
    Deque<Node> deque;
    public LFUCache(int capacity) {
        this.capacity = capacity;
        map1 = new HashMap<>();
        freqMap = new HashMap<>();
//        deque = new ArrayDeque<>();
        minFrequency = 0;
    }
    
    public int get(int key) {
        //if size is zero?

        //if key does not exist in map1, return -1

        //if key exists, return the value..
        // but also put the node in the right frequency in freq table
        //also update the deque to bring this element to the head
        return -1;
    }
    
    public void put(int key, int value) {
        Node node = new Node(key, value);
        //if size is zero.. just put it in both maps.. in freq map.. make the freq as zero
        //update the min freq as zero
        if (map1.size() == 0) {
            map1.put(key, node);
            minFrequency = 0;
            if (freqMap.containsKey(key)) {
                freqMap.get(key).addLast(node);
            } else {
                Deque<Node> deque = new ArrayDeque<>();
                deque.add(node);
                freqMap.put(0,deque);
            }
            return;

        }

        //if the key value already exist.. update its value and update the frequency table
        if (map1.containsKey(key)) {
            Node existing = map1.get(key);
            existing.value = value;

            Deque<Node> nodes = freqMap.get(existing.freq);


        }

        //if size is less than capacity, put it in the both maps.. put the element in freqmap in freq zero
        //update the min freq as zero


        //if the cache is full.. get the min freq.. take out the last element by deleting the tail and pointing tail to tail.perv
        
    }

    public static void main(String[] args) {
        LFUCache cache = new LFUCache( 2 /* capacity */ );

        cache.put(1, 1);
        cache.put(2, 2);
        cache.get(1);       // returns 1
        cache.put(3, 3);    // evicts key 2
        cache.get(2);       // returns -1 (not found)
        cache.get(3);       // returns 3.
        cache.put(4, 4);    // evicts key 1.
        cache.get(1);       // returns -1 (not found)
        cache.get(3);       // returns 3
        cache.get(4);       // returns 4
    }
}