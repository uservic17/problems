package problems.hackerRank.strings;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestSubstringBest {


  public static int getLongestSubstring(String str) {
    int result = 0;
    if (str == null || str.length() == 0) {
      return result;
    }
    Map<Character, Integer> map = new HashMap<>();

    for (int startingIndex = 0, runner = 0; runner < str.length(); runner++) {
      char currentChar = str.charAt(runner);
      if (map.containsKey(currentChar)) {
        int indexOfDuplicate = map.get(currentChar);
        if (indexOfDuplicate >= startingIndex) {
          startingIndex = runner;
        }
      }
      result = Math.max(result, runner - startingIndex + 1);
      map.put(currentChar, runner);
    }
    return result;
  }


}