package problems.recursive;

public class PrintBinariesOfDigit {
  static void printBinaries(int n) {
    printBinaries("", n);
  }

  private static void printBinaries(String prefix, int n) {

    if (n == 0) {
      System.out.println(prefix);
    } else {
      printBinaries(prefix + "0", n - 1);
      printBinaries(prefix + "1", n - 1);
    }
  }

  public static void main(String[] args) {
    printBinaries(8);
  }
}
