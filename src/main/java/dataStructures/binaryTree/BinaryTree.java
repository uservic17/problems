package dataStructures.binaryTree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BinaryTree {
  public static void main(String[] args) {
    Node root = new Node(1);
    root.insert(2);
    root.insert(3);
    root.insert(4);
    root.insert(5);
    root.insert(6);
    root.insert(7);
    root.insert(8);
    root.insert(9);
    System.out.println("Printing In Order");
    root.printInOrder(root);
    System.out.println("\n\nPrint level wise");
    root.printLevelWise(root);
    System.out.println("\n\nPrint lists at levels/depths using Breadth First Algo");
    for (LinkedList<Node> list : root.listOfDepthsBFS(root)) {
      System.out.println(list);
    }
    System.out.println("\n\nPrint lists at levels/depths using Depth First Algo, less space than bfs but space for recursion");
    for (LinkedList<Node> list : root.listOfDepthsDFS(root)) {
      System.out.println(list.size() + ": " + list);
    }

    System.out.println("\n\nPrint lists at levels/depths using Modified Breadth First Algo, no recursive space even");
    for (LinkedList<Node> list : root.listOfDepthsModifiedBFS(root)) {
      System.out.println(list.size() + ": " + list);
    }
  }
}


class Node {
  private int value;
  private Node left;
  private Node right;
  int level;

  public Node(int value) {
    this.value = value;
  }

  @Override
  public String toString() {
    return "" + value + "(" + level + ")";
  }

  void insert(int value) {
    ArrayDeque<Node> deque = new ArrayDeque<>();
    deque.addLast(this);
    insert(value, deque);
  }

  private void insert(int value, ArrayDeque<Node> deque) {
    Node node = deque.poll();
    if (node == null) return;
    if (node.left == null) {
      node.left = new Node(value);
    } else if (node.right == null) {
      node.right = new Node(value);
    } else {
      deque.addLast(node.left);
      deque.addLast(node.right);
      insert(value, deque);
    }

  }

  void printInOrder(Node node) {
    if (node == null) return;
    printInOrder(node.left);
    System.out.print(node.value + ": ");
    printInOrder(node.right);

  }

  void printLevelWise(Node node) {
    if (node == null) return;
    ArrayDeque<Node> deque = new ArrayDeque<>();
    deque.addLast(node);

    printLevelWise(deque);

  }

  private void printLevelWise(ArrayDeque<Node> deque) {
    while (!deque.isEmpty()) {
      Node node = deque.poll();
      if (node.left != null) deque.addLast(node.left);
      if (node.right != null) deque.addLast(node.right);
      System.out.print(node.value + ", ");
    }
  }

  /**
   * create a master list of lists
   * create a linked list at each level. and add it to the master list
   * add all elements at that level in that linked list
   * once on the next level, create a new list, add it to the master list and now add elements to that level's linked list
   * until the queue is empty
   * how to determine when we are at the next level.
   * -> stay on the same level (add elements to the same level list) until
   * (counter < Math.pow(2, level) - 1)
   * where counter is the overall number of element being added
   *
   * @param node
   * @return
   */
  List<LinkedList<Node>> listOfDepthsBFS(Node node) {

    if (node == null) return null;
    List<LinkedList<Node>> listOfLists = new ArrayList<>();
    LinkedList<Node> currentList = new LinkedList<>();
    listOfLists.add(currentList);
    int counter = 0;
    int level = 0;
    ArrayDeque<Node> deque = new ArrayDeque<>();
    deque.addLast(node);
    while (!deque.isEmpty()) {
      if (counter < Math.pow(2, level + 1) - 1) {
        Node currentNode = deque.poll();
        currentList.add(currentNode);
        currentNode.level = level;
        if (currentNode.left != null) {
          deque.addLast(currentNode.left);
        }
        if (currentNode.right != null) {
          deque.addLast(currentNode.right);
        }
        counter++;
      } else {
        level++;
        LinkedList<Node> newList = new LinkedList<>();
        listOfLists.add(newList);
        currentList = newList;
      }
    }

    return listOfLists;
  }

  /**
   * This piece of code does the same thing as above method i.e. add elements at a certain level to a particular list
   * and then returns the list of all the depth level lists
   * But it does it in a depth search way. It will add the element at a level to the list and then recursively call the
   * method to add the left and right children at the level -> level + 1
   *
   * @param node
   * @return
   */
  List<LinkedList<Node>> listOfDepthsDFS(Node node) {
    List<LinkedList<Node>> masterList = new ArrayList<>();
    listOfDepthsDFSPrivate(node, 0, masterList);
    return masterList;
  }

  private void listOfDepthsDFSPrivate(Node node, int level, List<LinkedList<Node>> masterList) {
    if (node != null) {
      if (masterList.size() <= level) {
        masterList.add(level, new LinkedList<>());
      }
      masterList.get(level).add(node);
      node.level = level;
      listOfDepthsDFSPrivate(node.left, level + 1, masterList);
      listOfDepthsDFSPrivate(node.right, level + 1, masterList);
    }
  }

  /**
   * same thing.. to get the list of depths
   * but this time with modified breadth search
   * where we don't use a queue for traversal
   * rather use parent and current
   */

  List<LinkedList<Node>> listOfDepthsModifiedBFS(Node node) {
    List<LinkedList<Node>> masterList = new ArrayList<>();
    LinkedList<Node> current = new LinkedList<>();

    if (node != null) {
      current.add(node);
    }

    while (!current.isEmpty()) {
      masterList.add(current);
      LinkedList<Node> parent = current;
      current = new LinkedList<>();
      for (Node node1 : parent) {
        if (node1.left != null) {
          current.add(node1.left);
        }
        if (node1.right != null) {
          current.add(node1.right);
        }
      }
    }
    return masterList;
  }

}