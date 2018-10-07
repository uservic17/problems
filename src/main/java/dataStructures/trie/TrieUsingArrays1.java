package dataStructures.trie;


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
public class TrieUsingArrays1 {
  private Node root;


  TrieUsingArrays1() {
    root = new Node();
    root.setaChar('\u0000');
  }

  public int insert(String str) {
    checkIfLengthIsZero(str);
    return handleInsert(str);
  }

  private int handleInsert(String str) {
    Node currentNode = root;
    for (int i = 0; i < str.length(); i++) {
      char c = str.charAt(i);
      if (isLastChar(str, i)) {
        return insertFinalCharAndSetValue(currentNode, c);
      } else {
        currentNode = insertIntermediateChar(currentNode, c);
      }
    }
    return -1;
  }


  private int insertFinalCharAndSetValue(Node currentNode, char c) {
    int offset = c - 'a';
    makeSureCurrentNodeHasChildArray(currentNode, offset);
    currentNode.getChildren()[offset].setaChar(c);
    currentNode.getChildren()[offset].makeTerminal();
    return currentNode.getChildren()[offset].getCount();
  }

  private Node insertIntermediateChar(Node currentNode, char c) {
    int offset = c - 'a';
    makeSureCurrentNodeHasChildArray(currentNode, offset);
    currentNode.getChildren()[offset].setaChar(c);
    return currentNode.getChildren()[offset];
  }

  private static void makeSureCurrentNodeHasChildArray(Node currentNode, int offset) {
    if (currentNode.getChildren()[offset] == null) {
      currentNode.getChildren()[offset] = new Node();
    }
  }


  private void checkIfLengthIsZero(String str) {
    if (str == null || str.length() == 0) {
      throw new IllegalArgumentException("Length is zero or value is null");
    }
  }

  private int getOffset(String str, int i) {
    int offset = (int) str.charAt(i) - 'a';
    if (offset > 25 || offset < 0) {
      throw new IllegalArgumentException("Invalid char");
    }
    return offset;
  }

  public int find(String str) {
    checkIfLengthIsZero(str);
    int result = -1;
    //for every char.. go to the offset and proceed if not null.. if null.. return -1
    //for last char, check if terminal.. if terminal, return the value.. i.e. count.. else return -1

    Node currentNode = root;
    int offset;
    for (int i = 0; i < str.length(); i++) {
      offset = getOffset(str, i);
      if (currentNode.getChildren()[offset] == null
              || currentNode.getChildren()[offset].getaChar() != str.charAt(i)) {
        break;
      }
      if (isLastChar(str, i)) {
        result = currentNode.getChildren()[offset].getCount();
        break; //not required but for better readability
      }
      currentNode = currentNode.getChildren()[offset];
    }
    return result;
  }

  private static boolean isLastChar(String str, int index) {
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
    for (int i = 0; i < Node.SIZE; i++) {
      if (root.getChildren()[i] != null) {
        builder.append("--->").append(root.getChildren()[i].toString()).append("\n");
      }
    }
    return builder.toString();
  }
}
