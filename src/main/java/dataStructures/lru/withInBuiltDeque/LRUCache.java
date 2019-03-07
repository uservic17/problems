package dataStructures.lru.withInBuiltDeque;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/*
so we will have a map.. we will store the key in the map and value.. but the value will also be stored in a linkedlist
so what will happen is.. when i insert some value in the map..
it will create a map entry which will have the key and the node containing the value
and the node should be put in the front of the linked list
now when you access it.. you see if the map has thekey.. if yes.. you get the node (value) and return it and move the
node to the top
when you insert a new value.. and if capacity is full.. you need to remove the last node from deque.. but
you also need to remove the key from the hashmap.. so how do you remove a key... when you know the value
so how about we store both the key and the value in the node

 */
class Node {
  int key;
  public int value;
  Node prev;
  Node next;

  public Node(int key, int value) {
    this.key = key;
    this.value = value;
  }
}

public class LRUCache {

  private Map<Integer, Node> map;
  private final int capacity;
  private Node head;
  private Node tail;

  public LRUCache(int capacity) {
//    deque = new LinkedList<>();
    map = new HashMap<>(capacity);
    this.capacity = capacity;
  }

  public int get(int key) {
    //check if map contains the key
    // if yes.. then get the corresponding node..
    //and move that node to the front of the deque
    int returnValue = -1;
    if (map.containsKey(key)) {
      Node node = map.get(key);
      returnValue = node.value;
      //now update the deque
      moveToFront(node);
    }
    return returnValue;
  }

  private void moveToFront(Node node) {
    if (node == head) {
      //nothing
    } else {
      Node prev = node.prev;
      prev.next = node.next;
      if (node.next != null) {
        node.next.prev = prev;
      }
      if (tail == node) {
        tail = node.prev;
      }

      //handle / update tail
      node.next = head;
      head.prev = node;
      node.prev = null;
      head = node;
    }
  }

  private Node removeLast() {
    Node node = tail;
    tail.next = null;
    tail = tail.prev;
    return node;
  }

  public void put(int key, int value) {
    //if map already contains the key.. then update the value and move the node to the front
    if (map.containsKey(key)) {
      map.get(key).value = value;
      moveToFront(map.get(key));
    } else {
      // else .. check the capacity
      //if capacity is full.. remove the last one from the queue.. and get the key from node and remove the entry from the hashmap
      if (map.size() == capacity) {
        //remove the last one
        Node node = removeLast();
        map.remove(node.key);
      }
      Node node = new Node(key, value);
      map.put(key, node);
      addToFront(key, node);
      //todo update tail
      if (map.size() == 1) {
        tail = head;
      }
//      deque.addFirst(node);
    }
  }

  private void addToFront(int key, Node node) {
    if (head == null) {
      head = node;
    } else {
      node.next = head;
      head.prev = node;
      head = node;
    }
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("------------------");
    sb.append("LRUCache: \nCapacity: ").append(capacity).append("\nSize: ").append(map.size());

    Node current = head;
    while (current != null) {
      sb.append("\nkey: ").append(current.key);
      sb.append(" , value: ").append(current.value);
      current = current.next;
    }
    return sb.toString();
  }

  public static void main(String[] args) {
    LRUCache cache = new LRUCache(1 /* capacity */);


    //["LRUCache","put","put","get","put","get","put", "get","get","get"]
    //[[2],       [1,1],[2,2],[1],  [3,3],[2],   [4,4],[1],   [3],  [4]]


    //["LRUCache","put","put","get","put","get","put","get","get","get"]
    //[[2],[1,1],[2,2],[1],[3,3],[2],[4,4],[1],[3],[4]]

    //["LRUCache","put","get","put","get","get"]
    //[[1],       [2,1],[2],   [3,2],[2],  [3]]

   cache.put(2,1);
    System.out.println(cache.get(2));
    cache.put(3,2);
    System.out.println(cache.get(2));
    System.out.println(cache.get(3));


  }
//  public static void main(String[] args) {
//    LRUCache cache = new LRUCache(2 /* capacity */);
////    ["LRUCache","get","put",  "get","put","put","get","get"]
////    [[2],        [2], [2,6],  [1], [1,5],[1,2], [1],  [2]]
////    [null,       -1,   null,   -1,  null,null,   2,    6]
//
//    System.out.println("should be -1: " + cache.get(2));
//    cache.put(2, 6);
//    System.out.println("should have 2 -> 6");
//    System.out.println(cache);
//
//    System.out.println("should be -1 : " + cache.get(1));
//
//    System.out.println("putting 1-> 5 there");
//    cache.put(1, 5);
//    System.out.println(cache);
//    System.out.println("now putting 1-> 2");
//    cache.put(1, 2);
//    System.out.println(cache);
//
//    System.out.println("get value for 1.. should be 2");
//    System.out.println(cache.get(1));
//
//    System.out.println("get value for 2.. should be 6");
//    System.out.println(cache.get(2));
//
//    System.out.println("final should have 2-6 on the top and then 1-2");
//    System.out.println(cache);
//
//  }

//  public static void main(String[] args) {
//    LRUCache cache = new LRUCache( 2 /* capacity */ );
//    cache.put(1, 1);
//    cache.put(2, 2);
//    System.out.println(cache);
//    cache.get(1);       // returns 1
//    System.out.println(cache);
//    cache.put(3, 3);    // evicts key 2
//    System.out.println("should evict 2");
//    System.out.println(cache);
//    System.out.println("should not find out 2..");
//    System.out.println(cache.get(2));       // returns -1 (not found)
//
//    System.out.println("Inserting 4 now.. should evict 1");
//    cache.put(4, 4);    // evicts key 1
//    System.out.println(cache);
//    cache.get(1);       // returns -1 (not found)
//    cache.get(3);       // returns 3
//    cache.get(4);       // returns 4
//    System.out.println(cache);
//    cache.get(3);
//    System.out.println(cache);
//  }
}