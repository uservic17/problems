package problems.recursive;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;

public class UseLruCacheInJava {
  public static void main(String[] args) {
    final int MAX_ENTRIES = 3;
    Map<Integer, String> cache = new LinkedHashMap<Integer, String>(MAX_ENTRIES+1, .75F, true) {
      // This method is called just after a new entry has been added
      public boolean removeEldestEntry(Map.Entry eldest) {
        return size() > MAX_ENTRIES;
      }
    };

    printCache(cache);
    cache.put(1, "vicky");
    cache.put(2, "cicky");
    cache.put(3, "kiki");
    System.out.println(cache.get(1));
    cache.put(4, "blah");

    printCache(cache);
  }

  private static void printCache(Map<Integer, String> cache) {
    for (Map.Entry<Integer, String> entry: cache.entrySet()) {
      System.out.println(entry.getKey() + " : " + entry.getValue());
    }
  }
}
