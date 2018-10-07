package dataStructures.trie;

public class DemoTrieUsingArrays {
  public static void main(String[] args) {
    TrieUsingNodeArray trie = new TrieUsingNodeArray();
    trie.insert("for");
    trie.insert("for");
    trie.insert("forth");
    trie.insert("foo");

    trie.insert("mic");
    trie.insert("michael");
//    trie.insert("jen");
//    trie.insert("jennie");
//    trie.insert("jennny");
//    trie.insert("foo");
//    trie.insert("for");
//    trie.insert("jenkins");
//    trie.insert("mike");
//    trie.insert("mic");
//    trie.insert("michael");
//    trie.insert("mikey");
//    trie.insert("mice");

//    System.out.println(trie);

    System.out.println("for occurs: " + trie.find("for").getCount());
    System.out.println("ffff occurs: " + trie.find("ffff"));
    System.out.println("forth occurs: " + trie.find("forth"));
    System.out.println("delete for count: " + trie.delete("for"));
    System.out.println("for occurs now: " + trie.find("for").getCount());
    System.out.println("for occurs now: " + trie.find("forth").getCount());
    System.out.println(trie.delete("michael"));

    System.out.println(trie);
  }
}
