package problems.leetcode;

public class ConvertDecimalToBinary {

  public static String decimalToBinary(int n) {
    StringBuilder sb = new StringBuilder();
     helper(n, sb);
     return sb.toString();
  }

  private static void helper(int n, StringBuilder sb) {
    if (n < 0) {
      sb.append("-");
      helper(-n, sb);
    } else if (n < 2) {
      sb.append(n);
    } else {
      int remainder = n % 2;
      n = n/2;
      helper(n, sb);
      sb.append(remainder);
    }
  }


}
