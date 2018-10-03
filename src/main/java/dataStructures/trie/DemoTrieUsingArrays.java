package dataStructures.trie;

public class DemoTrieUsingArrays {
  public static void main(String[] args) {
    TrieUsingArrayForStringsOnly trie = new TrieUsingArrayForStringsOnly();
    trie.insert("for", 6);
    trie.insert("for", 66);
    trie.insert("foo", 7);
    System.out.println(trie);
  }
}
