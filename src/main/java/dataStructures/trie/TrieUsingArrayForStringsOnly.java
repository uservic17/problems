package dataStructures.trie;


import com.sun.javaws.exceptions.InvalidArgumentException;

import java.util.Arrays;

/**
 * this is the implementation of Array based trie
 * Root node will be empty value but will have an array to store first character of all the strings
 * <p>
 * Every other node will have a reference to a char array unless it is the terminal string and
 * no other longer string exists in that branch
 * <p>
 * Insert operation will take a string and put the first char under root, the second char in the array under that node
 * <p>
 * A node has the following attributes:
 * - value to store value
 * - Reference to the next array to store next char
 */
public class TrieUsingArrayForStringsOnly {
  private Node root;
  private int SIZE = 26;

  private class Node { //todo do we make it static
    Node[] children;
    Character c;
    boolean isTerminal;
    private Integer value;

    public boolean isTerminal() {
      return getValue() != null;
    }

    Node(Character c, Integer value) {
      this.c = c;
      this.value = value;
      children = new Node[SIZE];
    }

    Integer getValue() {
      return value;
    }

    void setValue(int value) {
      this.value = value;
    }

    @Override
    public String toString() {
      if (this.children == null) {
        return this.c.toString();
      }
      StringBuilder stringBuilder = new StringBuilder();
//      stringBuilder.append("-->");
      stringBuilder.append(c).append(":").append("value:").append(value).append(":children:").append("\n");
      for (Node node : this.children) {
        if (node != null) {
          stringBuilder.append("--->").append(node.toString()).append("\n");
        }
      }
      return stringBuilder.toString();
    }
  }

  public TrieUsingArrayForStringsOnly() {
    root = new Node(null, -1);
//    root.array = null;   //todo root node array should not be initialized the first time
  }

  public boolean insert(String str, Integer value) {
    if (str == null || str.length() == 0) {
      throw new IllegalArgumentException("Length is zero");
    }
    Node nextNode = root;
    Node firstNode = root;

    for (int i = 0; i < str.length(); i++) {
      nextNode = nextNode.children[getOffset(str, i)];

      if (!isLastChar(str, i)) { //todo need to optimize.. only initialize the array if it is not the last char
        if (nextNode == null) {
          nextNode = new Node(str.charAt(i), null);
        } else {
          nextNode.c = str.charAt(i);
        }
          firstNode.children[(getOffset(str,i))] = nextNode;
          firstNode = nextNode;
//          nextNode.children = new Node[SIZE]; // only create if a longer string than this does not exist
//        nextNode.value = null; //don't do this if a short string is there.. for ex. foo exists and we are putting foobar
//          nextNode.c = str.charAt(i);


      }
      if (isLastChar(str, i)) {
        if (nextNode == null)  {
          nextNode = new Node(str.charAt(i), value);
        } else {
          nextNode.c = str.charAt(i);
          nextNode.value = value;
        }
          firstNode.children[(getOffset(str,i))] = nextNode;
          firstNode = nextNode;

//        nextNode.children = null;  //todo should not set it to null.. what if a longer string exists
//        break; // todo should not be required because length is getting checked in the for loop
        return true;
      }

    }


    return false;
  }

  private int getOffset(String str, int i) {
    return (int) str.charAt(i) - 'a';
  }

  public Integer find(String str) {
    return null;
  }

  public static boolean isLastChar(String str, int index) {
    boolean result = false;
    if (index == str.length() - 1) {
      result = true;
    }
    return result;
  }

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append("root->\n");
    builder.append("children-->\n");
    for (int i = 0; i < SIZE; i++) {
      if (root.children[i] != null) {
        builder.append("--->").append(root.children[i].toString()).append("\n");
      }
    }
    return builder.toString();
  }
}
