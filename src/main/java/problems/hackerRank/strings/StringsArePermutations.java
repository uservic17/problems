package problems.hackerRank.strings;

/**
 * todo WRONG - does not work for aa and dd.. because both become zero when XORing
 * -- String s1 = "aabcd"; String s2 = "bcddd"; It returns true !
 * -- Because xor will eliminate even number of appearance, your solution will be correct if all characters are unique
 * check if 2 strings are permutations of each other
 * Time O(n)
 * Space O(1)
 */
public class StringsArePermutations {
  static boolean arePerutationsWrongOne(String str1, String str2) {
    if (str1 == null || str2 == null || str1.length() != str2.length()) {
      return false;
    }

    int resultingZero = 0; //32 bit to have the bits set. This should be zero at the end

    resultingZero = getResultingZero(str1, resultingZero);

    resultingZero = getResultingZero(str2, resultingZero);

    return resultingZero == 0;
  }

  private static int getResultingZero(String str, int resultingZero) {
    int offset;
    for (int i = 0; i < str.length(); i++) {
      offset = str.charAt(i) - 'a';
      if (offset < 0 || offset > 25) throw new IllegalArgumentException("send only strings containing a-z");

      int bitToSet = 1 << offset;
      resultingZero = resultingZero ^ bitToSet;
    }
    return resultingZero;
  }

  //does not work with bcddd and aabcd.. use the above one
  public static boolean arePerutationsWrongTwo(String s1, String s2) {
    if (s1 == null || s2 == null || s1.length() != s2.length()) return false;

    int checker = 0;
    for (int i = 0; i < s1.length(); i++) {
      checker ^= s1.charAt(i) ^ s2.charAt(i);
    }
    return checker == 0;
  }
}
