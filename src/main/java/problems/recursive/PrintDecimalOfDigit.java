package problems.recursive;

public class PrintDecimalOfDigit {
  static void printDecimal(int n) {
    printDecimal("", n);
  }

  private static void printDecimal(String prefix, int n) {

    if (n == 0) {
      System.out.println(prefix);
    } else {
      for (int i = 0; i <=9 ; i++)
      printDecimal(prefix + Integer.toString(i), n - 1);
    }
  }

  public static void main(String[] args) {
    printDecimal(3);
  }
}
