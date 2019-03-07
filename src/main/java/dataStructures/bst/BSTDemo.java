package dataStructures.bst;

public class BSTDemo {
  public static void main(String[] args) {
    Node root = new Node(1);
    root.insert(root, 2);
    root.insert(root, 3);
    root.insert(root, 4);
    root.insert(root, 5);
    root.insert(root, 6);
    root.insert(root, 7);
    root.insert(root, 8);
    root.insert(root, -1);
    root.insert(root, -5);
    root.insert(root, 0);
    root.printInOrder(root);
  }
}

class Node {
  int value;
  Node left;
  Node right;

  public Node(int value) {
    this.value = value;
  }

  boolean contains (Node node, int value) {
    if (node == null) return false;
    if (node.value == value ) return true;
    if (value <= node.value) {
      return contains(node.left, value);
    } else {
      return contains(node.right, value);
    }
  }

  void insert (Node node, int value) {
    if (node == null) return;
    if (value == node.value) return;
    if (value < node.value) {
      if (node.left == null) {
        node.left = new Node(value);
      } else {
        insert(node.left, value);
      }
    } else {
      if (node.right == null) {
        node.right = new Node(value);
      } else {
        insert(node.right, value);
      }
    }
  }

  void printInOrder(Node node) {
    if (node == null) return;
    printInOrder(node.left);
    System.out.print(node.value + ": ");
    printInOrder(node.right);

  }
}