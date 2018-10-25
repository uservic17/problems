package dataStructures.linkedList;

public class MyLinkedList<T> {
  private Node<T> head;
  private Node<T> tail;

  public MyLinkedList() {
    this.head = null;
    this.tail = null;
  }

  public void add(T element) {
    Node<T> node = new Node<>(element);
    if (head == null) {
      head = node;
      head.next = null;
      tail = node;
    } else {
      Node<T> current = head;
      while (current.next != null ) {
        current = current.next;
      }
      current.next = node;
      tail = node;
    }
  }

  public T removeLast() {
    T data;
    if (head == null) {
      data = null;
    } else if (head.next == null) {
      data = head.getData();
      head = null;
    } else {
      Node<T> current = head;
      while (current.next.next != null) {
        current = current.next;
      }
      data = current.getData();
      current.next = null;
    }
    return data;
  }


  public T removeFirst() {
    T data;
    if (head == null) {
      data = null;
    } else {
      data = head.getData();
      head = head.next;
    }
    return data;
  }

  public Node<T> getLastNode() {
    if (head == null) {
      return null;
    }
    Node<T> current = head;
    while (current.next != null) {
      current = current.next;
    }
    return current;
  }

  public Node<T> getHead() {
    return head;
  }
  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("MyLinkedList: ");
    Node node = head;
    while (node != null) {
      sb.append(node.getData()).append("->");
      node = node.next;
    }
    sb.append("null");
    return sb.toString();
  }

  public Node<T> getNode(int index) {
    if (head == null) {
      return null;
    }
    Node<T> node = head;
    int count = 1;
    while (index > count) {
      if (node.next == null) {
        return null;
      }
      node = node.next;
      count++;
    }
    return node;
  }
}

class Node<T> {
  Node<T> next;
  public T data;

  public Node(Node<T> next, T data) {
    this.next = next;
    this.data = data;
  }

  Node(T data) {
    this.data = data;
    this.next = null;
  }

  public Node getNext() {
    return next;
  }

  public T getData() {
    return data;
  }

  @Override
  public String toString() {
    return "Node{" +
            "next=" + next +
            ", data=" + data +
            '}';
  }
}