package dataStructures.binaryTree.morePractice.dec9;

import java.util.*;

/*
  Not a binary search tree..
  nodes are inserted in the left to right order on the latest level
 */
public class TreePractice {
  public static void main(String[] args) {
    Node node = new Node(5);
    node.insert(1);
    node.insert(6);
    node.insert(2);
    node.insert(8);
    node.insert(8);
    node.insert(8);
    node.insert(8);
    node.insert(8);
    node.insert(9);
    node.insert(9);
    node.insert(9);
    node.insert(9);
    node.insert(9);
    node.insert(9);
    node.insert(9);
    node.insert(9);
    node.insert(9);
    node.insert(9);
    node.insert(9);
    Node.printInOrder(node);
    Node.printLevelWiseBFS(node);

    List<LinkedList<Node>> lol = Node.createLofL(node);
    printLol(lol);
    List<LinkedList<Node>> lolDFS = Node.createLofLDFS(node);
    printLol(lolDFS);



  }

  private static void printLol(List<LinkedList<Node>> lol) {
    System.out.println("\nLol");
    for (LinkedList<Node> current : lol) {
      for (Node i : current) {
        System.out.print(i.value + " ");
      }
      System.out.println("");
    }
  }
}


class Node {
  int value;
  Node left;
  Node right;

  public Node(int value) {
    this.value = value;
  }

  static void printInOrder(Node node) {
    if (node != null) {
      printInOrder(node.left);
      System.out.print(node.value + " ");
      printInOrder(node.right);
    }
  }

  /*
  level wise print
  extras space .. using BFS
   */
  static void printLevelWiseBFS(Node node) {
    Deque<Node> deque = new ArrayDeque<>();
    deque.add(node);
    printLevelWiseBFS(deque, 0, 1);
  }

  private static void printLevelWiseBFS(Deque<Node> deque, int level, int count) {
    while (!deque.isEmpty()) {
      Node node = deque.pollFirst();
      if (count <= Math.pow(2, level) - 1) {
        System.out.print(node.value + " ");
        count = count + 1;
      } else /*if (count == Math.pow(2, level) - 1)*/{
        System.out.print("\n");
        System.out.print(node.value + " ");
        count = count + 1;
        level = level + 1;
      }
      if (node.left != null) deque.add(node.left);
      if (node.right != null) deque.add(node.right);
    }

  }

  void insert(int value) {
    Deque<Node> deque = new ArrayDeque<>();
    deque.add(this);
    insert(value, deque);
  }

  private void insert(int value, Deque<Node> deque) {
    if (!deque.isEmpty()) {
      Node node = deque.pollFirst();
      if (node != null) {
        if (node.left == null) {
          node.left = new Node(value);
        } else if (node.right == null) {
          node.right = new Node(value);
        } else {
          deque.add(node.left);
          deque.add(node.right);
          insert(value, deque);
        }
      }
    }
  }

  static List<LinkedList<Node>> createLofL(Node node) {
    if (node != null) {
      List<LinkedList<Node>> master = new ArrayList<LinkedList<Node>>();
      master.add(new LinkedList<>());
      Deque<Node> deque = new ArrayDeque<>();
      deque.add(node);
      return createLofL(master, deque, 0, 1);
    }

    return null;
  }

  private static List<LinkedList<Node>> createLofL(List<LinkedList<Node>> master, Deque<Node> deque, int level, int count) {
    while (!deque.isEmpty()) {
      Node node = deque.pollFirst();
      if (count <= Math.pow(2, level) - 1) {
        LinkedList<Node> current = master.get(level);
        current.add(node);
      } else {

        LinkedList<Node> newList = new LinkedList<>();
        master.add(newList);
        newList.add(node);
        level = level + 1;
        count = count + 1;
      }
      if (node.left != null) deque.add(node.left);
      if (node.right != null) deque.add(node.right);
    }
    return master;
  }

   static List<LinkedList<Node>> createLofLDFS(Node node) {
    if (node != null) {
      List<LinkedList<Node>> master = new ArrayList<>();
      master.add(new LinkedList<>());
      return createLofLDFS(node, 0, master);
    }
    return null;
  }

  private static List<LinkedList<Node>> createLofLDFS(Node node, int level, List<LinkedList<Node>> master) {
    if (node == null) return master;
    if (level == master.size()) {
      master.add(new LinkedList<>());
    }
    LinkedList<Node> current = master.get(level);
    current.add(node);
    createLofLDFS(node.left, level + 1, master);
    createLofLDFS(node.right, level + 1, master);
    return master;

  }
}