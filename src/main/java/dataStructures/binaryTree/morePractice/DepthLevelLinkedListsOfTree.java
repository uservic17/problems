package dataStructures.binaryTree.morePractice;

import java.util.*;

public class DepthLevelLinkedListsOfTree {
  public static void main(String[] args) {
    Node node = new Node(1);
    node.insert(2);
    node.insert(3);
    node.insert(4);
    node.insert(5);
    node.insert(6);
    node.insert(7);
    node.insert(8);
    node.insert(9);
    node.insert(9);
    node.insert(9);
    node.insert(9);
    node.insert(9);
    node.insert(9);
    node.insert(9);
    node.printTreeLevelWise();
    node.printInOrder();

    printListOfLists(createMasterList(node), "Level wise linked lists BFS");
    printListOfLists(createMasterListDFS(node), "Level wise linked lists DFS");
    printListOfListsNode(createMasterListBFSModified(node), "Level wise linked lists BFS modified");
    System.out.println(isBalancedTree(node));

    Node node1 = new Node(1);
    Node node2 = node1.insert(2);
    Node node3 = node2.insert(3);
    Node node4 = node3.insert(4);
    Node node5 = node4.insert(5);

    node1.printInOrder();
    node1.printTreeLevelWise();
    printListOfListsNode(createMasterListBFSModified(node1), "Level wise linked lists BFS modified");
    System.out.println(isBalancedTree(node1));


    System.out.println(checkBalanced(node));
    System.out.println(checkBalanced(node1));

  }

  private static void printListOfLists(List<LinkedList<Integer>> masterList, String str) {
    System.out.println(str);
    for (LinkedList<Integer> sublist : masterList) {
      for (Integer i : sublist) {
        System.out.print(i + " ");
      }
      System.out.print("\n");
    }
  }

  private static void printListOfListsNode(List<LinkedList<Node>> masterList, String str) {
    System.out.println(str);
    for (LinkedList<Node> sublist : masterList) {
      for (Node node : sublist) {
        System.out.print(node.value + " ");
      }
      System.out.print("\n");
    }
  }
  /**
   * put levels in linked lists - BFS
   */
  static List<LinkedList<Integer>> createMasterList(Node node) {
    List<LinkedList<Integer>> masterList = new ArrayList<>();
    if (node == null) return masterList;
    Deque<Node> deque = new ArrayDeque<>();
    deque.add(node);
    int level = 1;
    int count = 0;
    // if the count is less than 2^level -1, then add to the same sub list
    //else initialize a new sublist and add to the master list
    LinkedList<Integer> sublist = new LinkedList<>();
    masterList.add(sublist);
    while (!deque.isEmpty()) {
      Node node1 = deque.poll();
      if (count >= Math.pow(2, level) - 1) {

        sublist = new LinkedList<>();
        masterList.add(sublist);
        level++;
      }
      sublist.add(node1.value);
      count++;

      if (node1.left != null) {
        deque.add(node1.left);
      }
      if (node1.right != null) {
        deque.add(node1.right);
      }
    }
    return masterList;
  }

  /**
   * put levels in linked lists - DFS
   */
  static List<LinkedList<Integer>> createMasterListDFS(Node node) {
    List<LinkedList<Integer>> masterList = new ArrayList<>();
    if (node == null) return masterList;
    createMasterListDFS(node, masterList, 0);
    return masterList;
  }

  private static void createMasterListDFS(Node node, List<LinkedList<Integer>> masterList, int level) {
    if (node == null) return;
    if (masterList.size() <= level) {
      masterList.add(new LinkedList<>());
    }
    masterList.get(level).add(node.value);
    createMasterListDFS(node.left, masterList, level + 1);
    createMasterListDFS(node.right, masterList, level + 1);
  }

  /**
   * put levels in linked lists - BFS Modified. No extra space
   */
  static List<LinkedList<Node>> createMasterListBFSModified(Node node) {
    List<LinkedList<Node>> masterList = new ArrayList<>();
    LinkedList<Node> current = new LinkedList<>();
    current.add(node);
    while (!current.isEmpty()) {
      LinkedList<Node> parent = current;
      current = new LinkedList<>();
      for (Node n : parent) {
        if (n.left != null) {
          current.add(n.left);
        }
        if (n.right != null) {
          current.add(n.right);
        }
      }
      masterList.add(parent);
    }
    return masterList;
  }

  /**
   * Check Balanced: Implement a function to check if a binary tree is balanced.
   * For the purposes of this question, a balanced tree is defined to be a tree
   * such that the heights of the two subtrees of any node never differ by more than one.
   */
  public static boolean isBalancedTree(Node node) {
    if (node == null) return true;
    if (node.left == null && node.right == null) return true;
    int[] array = new int[2];
    array[0] = Integer.MAX_VALUE;
    array[1] = 0;

    System.out.print("\nIs tree balanced? ");
     return isBalancedTreePrivate(node, array, 0, 0);
//    System.out.println("\n min level = " + array[0] + " and max level = " + array[1]);
//     return !(Math.abs(array[1] - array[0]) > 1);
  }

  private static boolean isBalancedTreePrivate(Node node, int[] array, int leftLevel, int rightLevel) {
    if (node.left != null) {
      leftLevel = leftLevel + 1;
      isBalancedTreePrivate(node.left, array, leftLevel, rightLevel);
    }
    if (node.right !=  null)  {
      rightLevel = rightLevel + 1;
      isBalancedTreePrivate(node.right, array, leftLevel, rightLevel);
    }
    return !(Math.abs(leftLevel - rightLevel) > 1);
  }

  /**
   * second approach for isBalanced
   *
   * check if the node is leaf node.. use array for lowest level and highest level and return the difference > 1
   */
  public static boolean checkBalanced(Node node) {
    if (node == null) return true;
    int[] array = new int[2];
    array[0] = Integer.MAX_VALUE;
    array[1] = Integer.MIN_VALUE;
    boolean result =  checkBalancedPrivate(node, 0, array);
    System.out.println(array[0] + " : " + array[1]);
    return result;
  }

  private static boolean checkBalancedPrivate(Node node, int level, int[] array) {
    if (isLeafNode(node)) {
      if (level < array[0]) {
        array[0] = level;
      }
      if (level > array[1]) {
        array[1] = level;
      }

    }
    if (node.left != null ) {
      checkBalancedPrivate(node.left, level + 1, array);
    }
    if (node.right != null ) {
      checkBalancedPrivate(node.right, level + 1, array);
    }
    return !(Math.abs(array[1] - array[0]) > 1);
  }

  private static boolean isLeafNode(Node node) {
    return node.left == null && node.right == null;
  }

}



/**
 * Binary tree. Not binary search tree
 * Just add the new nodes level wise
 */
class Node {

  Node left, right;
  int value;

  public Node(int value) {
    this.value = value;
  }


  Node insert(int value) {
    Deque<Node> deque = new ArrayDeque<>();
    deque.add(this);
    return insert(value, deque);
  }


  private Node insert(int value, Deque<Node> deque) {
    Node node = deque.poll();

    if (node != null) {
      if (node.left == null) {
        Node newNode = new Node(value);
        node.left = newNode;
        return newNode;
      } else if (node.right == null) {
        Node newNode = new Node(value);
        node.right = newNode;
        return newNode;
      } else {
        deque.add(node.left);
        deque.add(node.right);
        return insert(value, deque);
      }
    }
    return null;
  }

  //print tree level wise or BFS
  public void printTreeLevelWise() {
    Deque<Node> deque = new ArrayDeque<>();
    deque.add(this);
    System.out.println("Levelwise tree print");
    printTreeLevelWise(deque);
    System.out.println("\n");

  }

  private void printTreeLevelWise(Deque<Node> deque) {
    if (deque.isEmpty()) {
      return;
    }
    while (!deque.isEmpty()) {
      Node node = deque.poll();
      System.out.print(node.value + ", ");
      if (node.left != null) {
        deque.add(node.left);
      }
      if (node.right != null) {
        deque.add(node.right);
      }
    }
  }

  public void printInOrder() {
    System.out.println("In order traversal print");
    printInOrder(this);
    System.out.println("\n");

  }

  private void printInOrder(Node node) {
    if (node == null) return;
    printInOrder(node.left);
    System.out.print(node.value + ", ");
    printInOrder(node.right);
  }


}
