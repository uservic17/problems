package dataStructures.trie;

public class DemoTrieUsingArrays {
  public static void main(String[] args) {
    TrieUsingArrays1 trie = new TrieUsingArrays1();
    trie.insert("for");
    trie.insert("for");
    trie.insert("foo");
    trie.insert("jen");
    trie.insert("jennie");
    trie.insert("jennny");
    trie.insert("foo");
    trie.insert("for");
    trie.insert("jenkins");
    trie.insert("mike");
    trie.insert("mic");
    trie.insert("michael");
    trie.insert("mikey");
    trie.insert("mice");

    System.out.println(trie);

    System.out.println("for occurs: " + trie.find("for"));
    System.out.println("ffff occurs: " + trie.find("ffff"));
  }
}
