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
    root.printInOrder(root);
    System.out.println("\n");
    root.printLevelWise(root);
    System.out.println("\n");
    for (LinkedList<Node> list : root.listOfDepthsBFS(root)) {
      System.out.println(list);
    }
  }
}


class Node {
  private int value;
  private Node left;
  private Node right;

  public Node(int value) {
    this.value = value;
  }

  @Override
  public String toString() {
    return "" + value;
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
    int level = 1;
    ArrayDeque<Node> deque = new ArrayDeque<>();
    deque.addLast(node);
    while (!deque.isEmpty()) {
      if (counter < Math.pow(2, level) - 1) {
        Node currentNode = deque.poll();
        currentList.add(currentNode);
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

  List<LinkedList<Node>> listOfDepthsDFS(Node node) {
    return null;
  }


}