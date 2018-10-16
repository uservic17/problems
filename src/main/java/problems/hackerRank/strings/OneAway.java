package problems.hackerRank.strings;

/**
 * one char diff
 * pate, mate = true
 * billion, million = true
 * aaa, bbb = false
 * aab, abb = true
 *
 * one extra char (insert) or one less char
 * hi hii = true
 * hill hilly = true
 * aple apple = true
 * apple aple = true
 *
 * bull, bullion = false
 * null, bill = false
 * null, null = false
 * "", a = true
 * ab, "" = false
 *
 */
public class OneAway {
  static boolean isOneDifferenceAway(String str1, String str2) {
    if (str1 == null || str2 == null) return false;
    if (str1.length() == str2.length()) return isOneReplaceAway(str1, str2);
    if (str1.length() + 1 == str2.length()) {
      return isOneInsertAway(str1, str2);
    } else if (str2.length() + 1 == str1.length()) {
      return isOneInsertAway(str2, str1);
    }
    return false;
  }

  private static boolean isOneInsertAway(String str1, String str2) {
    if (str1 == null || str2 == null) return false;
    if (Math.abs(str1.length() - str2.length()) != 1) return false;
    int index1 = 0, index2 = 0;
    while (index1 < str1.length() && index2 < str2.length()) {
      if (str1.charAt(index1) != str2.charAt(index2)) {
        if (index1 != index2) {
          return false;
        }
        index2++;
      } else {
        index1++;
        index2++;
      }
    }
    return true;
  }

  private static boolean isOneReplaceAway(String str1, String str2) {
    if (str1 == null || str2 == null) return false;
    if (str1.length() != str2.length()) return false;
    boolean replaceOneSet = false;
    for (int i = 0; i < str1.length(); i++) {
      if (str1.charAt(i) != str2.charAt(i)) {
        if (replaceOneSet) {
          return false;
        }
        replaceOneSet = true;
      }
    }
    return true;
  }
}
