package dataStructures.trie;

public class Node {
  private Node[] children;
  private int value;
  private char aChar;
  public static final int SIZE = 26;


  Node() {
    children = new Node[SIZE];
  }

  public char getaChar() {
    return aChar;
  }

  public void setaChar(char aChar) {
    this.aChar = aChar;
  }

  public Node[] getChildren() {
    return children;
  }

  Integer getCount() {
    return value;
  }

  public void makeTerminal() {
    this.value++;
  }


  @Override
  public String toString() {
    if (this.children == null) {
      return this.getaChar() + " (" + this.getCount().toString() + ")";
    }
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(aChar).append(":").append("count: ").append(getCount()).append(":children:").append("\n");
    for (Node node : this.children) {
      if (node != null) {
        stringBuilder.append("--->").append(node.toString()).append("\n");
      }
    }
    return stringBuilder.toString();
  }
}