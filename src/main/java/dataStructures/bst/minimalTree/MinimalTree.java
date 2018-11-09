package dataStructures.bst.minimalTree;

import dataStructures.bst.BSTDemo;

/**
 * 4.2 Minimal Tree: Given a sorted (increasing order) array with unique integer elements,
 * write an algorithm to create a binary search tree with minimal height.
 */
public class MinimalTree {

  static Node createMinimalTree(int[] sortedArray) {
    if (sortedArray == null || sortedArray.length == 0) {
      return null;
    }
    return createMinimalTreePrivate(sortedArray, 0, sortedArray.length - 1);
  }

  private static Node createMinimalTreePrivate(int[] sortedArray, int left, int right) {
    if (left > right) return null;
    if (sortedArray.length == 0) return null;
    int mid = (left + right) / 2;
     Node parent = new Node(sortedArray[mid]);

    parent.left = createMinimalTreePrivate(sortedArray, left, mid - 1);
    parent.right = createMinimalTreePrivate(sortedArray, mid + 1, right);


    return parent;
  }

  private static class Node {
    int value;
    Node left;
    Node right;

    public Node(int value) {
      this.value = value;
    }

static void printInOrder(Node node) {
      if (node == null) return;
      printInOrder(node.left);
  System.out.print(" " + node.value);
      printInOrder(node.right);
}
  }

  public static void main(String[] args) {
    int[] array = {1, 2, 3, 4, 5};
    Node parent1 = createMinimalTree(array);
    Node.printInOrder(parent1);
    System.out.println("\n");
    int[] array2 = {1, 2, 4 , 6, 8, 9, 10, 14, 18, 20};
    Node parent2 = createMinimalTree(array2);
    Node.printInOrder(parent2);
  }


}
