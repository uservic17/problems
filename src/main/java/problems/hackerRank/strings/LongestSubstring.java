package problems.hackerRank.strings;

import java.util.*;

public class LongestSubstring {

  /*
  this is about getting the longest substring with non repeating characters
   */

  public static int lengthOfLongestSubstring(String s) {
    if (s== null || s.length() == 0) return 0;
    int start = 0;
    int max = 1;
    Map<Character, Integer> map = new HashMap<>();
    for (int i = 0; i < s.length(); i++) {
      char current = s.charAt(i);
      if (!map.containsKey(current)) {
        map.put(current, i);
      } else {
        int indexOfDuplicate = map.get(current) + 1;
        if (indexOfDuplicate > start) {
          start = indexOfDuplicate;
        }
        map.put(current, i);

      }
      max = Math.max(i - start + 1, max);
    }
    return max;
  }

  public static void main(String[] args) {
    System.out.println(lengthOfLongestSubstring("abba"));
  }

}