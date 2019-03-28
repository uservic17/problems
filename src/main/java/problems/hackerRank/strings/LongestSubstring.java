package problems.hackerRank.strings;

import java.util.*;

public class LongestSubstring {

  /*
  this is about getting the longest substring with non repeating characters
   */

  public int lengthOfLongestSubstring(String s) {
    return getLongestSubstring(s).length();
  }

  public static int lengthOfLongestSubstringMine(String s) {
    return getLengthOfLongestSubstring(s);
  }
  public static int lengthOfLongestSubstringMine2(String s) {
    if (s == null || s.length() == 0) return 0;


    int ans = 0, i = 0, j = 0;
    int length = s.length();
    Set<Character> set = new HashSet<>();
    while (j < length && i < length) {
      if (!set.contains(s.charAt(j))) {
        set.add(s.charAt(j));
//        ans = Math.max(ans, j - i);
      } else {
        ans = Math.max(ans, j - i);
        int indexOfDuplicate = s.indexOf(s.charAt(j), i);
        if (indexOfDuplicate != -1) {
          i = indexOfDuplicate + 1;
        }
      }
      j++;
    }
    if (j == s.length()) {
      ans = Math.max(ans, j - i);
    }
    return ans;
  }


  public static String getLongestSubstring(String string) {
    String result = "";
    if (string == null || string.length() == 0) {
      return result;
    }
    Map<Character, Integer> map = new HashMap<>();
    int startingIndex = 0;

    for (int i = 0; i < string.length(); i++) {
      if (map.containsKey(string.charAt(i)) && startingIndex <= map.get(string.charAt(i))) {
        int eliminateUntil = map.get(string.charAt(i));
        map.put(string.charAt(i), i);
        String intermediateResult = getIntermediateString(string, eliminateUntil, i - 1);
        if (result.length() < intermediateResult.length()) {
          result = intermediateResult;
        }
        startingIndex = eliminateUntil + 1;
      } else {
        map.put(string.charAt(i), i);
        String intermediateString = getIntermediateString(string, startingIndex, i);
        if (result.length() < intermediateString.length()) {
          result = intermediateString;
        }
        if (i == string.length() - 1) {
          return result;
        }
      }
    }

    return result;

  }

  private static String getIntermediateString(String string, int startingIndex, int i) {
    StringBuilder intermediateResult = new StringBuilder();
    for (int j = startingIndex; j < i + 1; j++) {
      intermediateResult.append(string.charAt(j));
    }
    return intermediateResult.toString();
  }

  public static int getLengthOfLongestSubstring(String s) {
    if (s == null || s.length() == 0) return 0;
    int ans = 0, i = 0, j = 0;
    int length = s.length();
    Set<Character> set = new HashSet<>();
    while (i < length && j < length) {
      char c = s.charAt(j);
      if (!set.contains(c)) {
        set.add(c);
        j++;
        ans = Math.max(ans, j - i);
      } else {
        set.remove(s.charAt(i++));
      }
    }
    return ans;
  }


  public static int lengthOfLongestSubstring2(String s) {
    int start = 0, end = 0;
    int n = s.length();
    Set<Character> set = new HashSet<>();
    int ans = 0, i = 0, j = 0;
    while (i < n && j < n) {
      // try to extend the range [i, j]
      if (!set.contains(s.charAt(j))) {
        set.add(s.charAt(j++));
        if (j - i > ans) {
          ans = j - i;
          start = i;
          end = j;
        }
        ans = Math.max(ans, j - i);
      } else {
        set.remove(s.charAt(i++));
      }
    }
    System.out.println(s.substring(start, end ));
    return ans;
  }
}