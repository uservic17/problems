package problems.hackerRank.strings;

/**
 * find if there are any duplicate characters in the string
 * 1. Approach 1 is char by char matching . )(n^2)
 * 2. Use set. put char by char. O(n) but space O(n)
 * 3. Sort the charArray and match every char to just the next one but that takes O(nlogn) and O(n) space
 * 4. Set the bits of a 32 bit int. This is an interesting one and this is the one implemented here
 */
public class StringDuplicateChars {
  //should contain only lowercase a-z. Any other char, throw IllegalArgumentException
  static boolean anyDuplicateChars(String str) {
    if (str == null || str.length() == 0) {
      return false;
    }
    int offset = 0;
    int checker = 0;
    for (int i = 0; i < str.length(); i++) {
      offset = (int)(str.charAt(i)) - 'a';
      if (offset >25 || offset < 0) throw new IllegalArgumentException("input should contain only lowercase a-z");
      int bitToSet = 1 << offset;
      if ((checker & bitToSet) > 0) {
        return true;
      } else {
        checker = checker | bitToSet;
      }
    }
    return false;
  }


}
