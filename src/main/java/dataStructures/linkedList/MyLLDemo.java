package dataStructures.linkedList;

public class MyLLDemo {
  public static void main(String[] args) {
    System.out.println(isCircularList(getCircularList()));
    System.out.println("---------kth to last element");
    System.out.println("3rd element from end in " + getSimpleIntegerList() + " is: " + getKthToLastElementData(getSimpleIntegerList(), 3));
    System.out.println("4th element from end in " + getSimpleIntegerList() + " is: " + getKthToLastElementData(getSimpleIntegerList(), 4));
    System.out.println("11th element from end in " + getSimpleIntegerList() + " is: " + getKthToLastElementData(getSimpleIntegerList(), 11));
    System.out.println("0th element from end in " + getSimpleIntegerList() + " is: " + getKthToLastElementData(getSimpleIntegerList(), 0));
    System.out.println("1st element from end in " + getSimpleIntegerList() + " is: " + getKthToLastElementData(getSimpleIntegerList(), 1));
    if(!getKthToLastElementData(getSimpleIntegerList(), 3).equals(getKthToLastElementDataWith2Pointers(getSimpleIntegerList(), 3))) {
      System.out.println("#############Not working .. the 2 pointer solution");
    }

    System.out.println("------kth elemnet using 2 pointers");
    System.out.println("3rd element from end in " + getSimpleIntegerList() + " is: " + getKthToLastElementDataWith2Pointers(getSimpleIntegerList(), 3));
    System.out.println("11th element from end in " + getSimpleIntegerList() + " is: " + getKthToLastElementDataWith2Pointers(getSimpleIntegerList(), 11));
    System.out.println("0th element from end in (should be null)" + getSimpleIntegerList() + " is: " + getKthToLastElementDataWith2Pointers(getSimpleIntegerList(), 0));
    System.out.println("1st element from end in " + getSimpleIntegerList() + " is: " + getKthToLastElementDataWith2Pointers(getSimpleIntegerList(), 1));
    System.out.println("------kth element from end using recursion");
    System.out.println("3rd element from end in " + getSimpleIntegerList() + " is: " );
    getKthToLastElementDataRecursive(getSimpleIntegerList(), 3);


    System.out.println("################### ");
    System.out.println("##Testing the deleting the current node..");
    MyLinkedList<Integer> list1 = getSimpleIntegerList();
    Node<Integer> node1 = getNthNode(list1, 4);
    System.out.println(list1);
    deleteTheGivenNode(list1, node1);
    System.out.println(list1);

  }

  /**
   * basic test to print a list
   */
  private static void basicTest() {
    MyLinkedList<Integer> list = new MyLinkedList<>();
    System.out.println(list);
    list.add(5);
    list.add(6);
    list.add(7);
    System.out.println(list);
    list.removeFirst();
    System.out.println(list);
    list.removeLast();
    System.out.println(list);
  }

  /**
   * return true if list is circular
   */
  private static <T> boolean isCircularList(MyLinkedList<T> list) {
    Node<T> head = list.getHead();
    if (head == null || head.next == null || head.next.next == null) {
      return false;
    }
    Node<T> slow = head.next;
    Node<T> fast = head.next.next;

    while(true) {
      if (slow == fast) {
        return true;
      }
      if (slow.next != null && fast.next != null && fast.next.next != null) {
        slow = slow.next;
        fast = fast.next.next;
      } else {
        return false;
      }
    }

  }

  /**
   * get the kth from end elemnet
   * @return null if k is greater than the size of the list
   */
  private static  <T> T  getKthToLastElementData(MyLinkedList<T> list, int k) {
    if (k == 0) return null;
    Node<T> head = list.getHead();
    if (head == null) {
      return null;
    }
    int size = 1;
    Node<T> current = head;
    while (current.next != null) {
      size++;
      current = current.next;
    }
    current = head;
    if (size < k) {
      return null;
    }
    for (int i = 0; i < size - k; i++) {
      current = current.next;
    }

    return current.getData();
  }

  /**
   * get the kth from end elemnet using 2 pointers
   * @return null if k is greater than the size of the list
   */
  public static  <T> T  getKthToLastElementDataWith2Pointers(MyLinkedList<T> list, int k) {
    if (k == 0) return null;
    Node<T> head = list.getHead();
    if (head == null) {
      return null;
    }
    Node<T> first = head;
    Node<T> second = head;
    int index = 1;
    while (index < k ) {
      if (first.next == null && index < k) {
        System.out.println("Size of the list is less than K ###");
        return null;
      }
      first = first.next;
      index++;
    }
    while (first.next != null) {
      first = first.next;
      second = second.next;
    }

    return second.getData();
  }

  /**
   * prints get the kth from end elemnet using Recursion
   */
  public static  <T> void getKthToLastElementDataRecursive(MyLinkedList<T> list, int k) {
    Node<T> head = list.getHead();
    getKthToLastElementDataRecursive(head, k);
  }
  private static  <T> int getKthToLastElementDataRecursive(Node<T> node, int k) {
    if (k == 0 ) {
      System.out.println("null");
    }
    if (node == null) {
      return 0;

    }
    int index = 0;
    index = 1 + getKthToLastElementDataRecursive(node.next, k);
    if (index == k) {
      System.out.println("this is the element and the value is: " + node.getData());
    }
    return index;
  }

  private static MyLinkedList<Integer> getSimpleIntegerList() {
    MyLinkedList<Integer> list = new MyLinkedList<>();
    list.add(1);
    list.add(2);
    list.add(3);
    list.add(4);
    list.add(5);
    list.add(6);
    list.add(7);

    return list;
  }

  /**
   *
   * @return a circular linked list
   */
  private static MyLinkedList<Integer> getCircularList() {
    MyLinkedList<Integer> list = new MyLinkedList<>();
    list.add(1);
    list.add(2);
    list.add(3);
    list.add(4);
    list.add(5);
    list.add(6);
    list.add(7);

    Node<Integer> lastNode = list.getLastNode();
    Node<Integer> someNonTerminalNode = list.getNode(3);
    lastNode.next = someNonTerminalNode;
    return list;
  }

  /**
   * Get the nth Node
   */
  private static <T> Node<T> getNthNode(MyLinkedList<T> list, int index) {
    if (list == null || list.getHead() == null) {
      return null;
    }
    Node<T> current = list.getHead();
    int count = 1;
    for (int i = 1; i < index; i++) {
      if (current.next == null) {
        System.out.println("Size not big enough");
        return null;
      }
      current = current.next;
    }
    return current;

  }
  /**
   * deletes the given node
   * first approach was bad.. was copying data of next to current for all nodes following that node.
   * we can just do the next easily which is the following approach
   */
  public static <T> void deleteTheGivenNode(MyLinkedList<T> list, Node<T> node) {
    T data = node.getData();
    System.out.println("Deleted node data: " + data);

    node.data = node.next.data;
    node.next = node.next.next;


  }

}
