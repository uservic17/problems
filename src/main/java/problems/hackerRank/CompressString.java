package problems.hackerRank;

/**
 *  Implement a method to perform basic string compression using the counts of repeated characters.
 *  For example, the string aabcccccaaa would become a2blc5a3.
 *  If the "compressed" string would not become smaller than the original string, your method should return the original string.
 *  You can assume the string has only uppercase and lowercase letters (a - z).
 */
public class CompressString {
  static String compress(String str) {
    if (str == null || str.length() == 0) return str;

    int count = 1;
    int i = 1;
    char c = str.charAt(0);
    int maxCount = 1;
    StringBuilder sb = new StringBuilder();
    while (i < str.length()) {
      if (str.charAt(i) == c) {
        i++; count++;
      } else {
        sb.append(c).append(count);
        maxCount = Math.max(count, maxCount);
        count = 1;
        c = str.charAt(i);
        i++;
      }
      if (i == str.length()) {
        sb.append(c).append(count);
        maxCount = Math.max(maxCount, count);
      }
    }
    return maxCount == 1? str : sb.toString();
  }
}
