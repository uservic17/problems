package problems.hackerRank.strings;

/**
 * the algo is to find if the word is a permutation of a palindrome
 * dalda is permutaion of palindrome dalad
 * llaa is a permutation of palidrome laal or alla
 *
 * so at max one char can be a single, else they have to be pairs
 * So we assume char set is a-z
 * and set and unset bit at positions in a 32 bit integer
 * At the end if the integer is zero, return true
 * or if there is only one bit is set to 1, return true
 * else return false
 *
 * To check if only one bit is set in an integer myInteger, do the following
 * (myInteger - 1) & myInteger should be equal to 0
 */
public class PalindromePermutation {
  static boolean isPalidromPerm(String str) {
    if (str == null) throw new IllegalArgumentException("String is null");
    if (str.length() == 0 || str.length() == 1) return true;

    str = str.toLowerCase();
    int checker = 0;
    int offset;

    for (int i = 0; i < str.length(); i++) {
      char charAt = str.charAt(i);
      if (charAt == ' ') continue;
      offset = charAt - 'a';
      if (offset < 0 || offset > 25) return false;
      checker = checker ^ (1 << offset);
    }
    if (checker == 0) return true;


    //to check only one bit at max is set
/*  //the following code can be replaced by just subtracting 1 from the checker and &'ing the result with checker
    for (int i = 2; i <= checker; i = i*2) {
      if (i == checker) return true;
      if (checker % i != 0) return false;
    }*/
    return (checker & (checker -1)) == 0;
  }
}
