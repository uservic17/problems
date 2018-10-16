package dataStructures.bst;

import java.util.ArrayList;
import java.util.List;

public class BSTBalancer {
  static void balanceBST(Node node) {
    //todo copy this unmodifiable node?
    //convert to sorted array, by putting the in order traversal in
    //Convert from array to a tree by taking mid as the root recursively
    int[] array = convertPreOrderToArray(node, new ArrayList<Integer>());
    getBalancedBST(array);
  }

  private static void getBalancedBST(int[] array) {
    getBalancedBSTPrivate(array, 0, array.length, null);
  }

  private static void getBalancedBSTPrivate(int[] array, int start, int end, Node parent) {
    if (array.length == 0) return;
    if (start > end) return;
    int mid = (start + end) / 2;
    int value = array[mid];
    int leftEnd = mid - 1;
    int rightStart = mid + 1;

    Node newNode = new Node(value);
    if (parent == null) {
      parent = newNode;
    } else {
      if (value < parent.value) {
        parent.left = newNode;
      } else if (value > parent.value) {
        parent.right = newNode;
      }
    }
    getBalancedBSTPrivate(array, 0, leftEnd, newNode);
    getBalancedBSTPrivate(array, rightStart, end, newNode);
  }

  private static int[] convertPreOrderToArray(Node node, List<Integer> list) {
    //left
    //root
    //right
    int[] result = new int[list.size()];

    List<Integer> integers = anotherOne(node, list);
    if (integers != null) {
      for (int i = 0; i < integers.size(); i++) {
        result[i] = integers.get(i);
      }
    }
   return result;
  }

  private static List<Integer> anotherOne(Node node, List<Integer> list) {
    if (node == null) return list;
    list.addAll(anotherOne(node.left, list) != null? anotherOne(node.left, list) : null);
//    list.add(node.right.getValue())
    return null;
  }


}
