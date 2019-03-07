package problems.recursive;

public class ListSubsets1 {
  static void printSubsets(String s) {

    foo("", s);
  }

  static private void foo(String soFar, String rest) {
    if (rest.isEmpty()) {
      System.out.print(soFar + ", ");
    } else {
      String next = soFar + rest.charAt(0);
      String nextRest = rest.substring(1);
      foo(next, nextRest);
      foo(soFar, nextRest);
    }

  }

  public static void main(String[] args) {
    printSubsets("abc");
  }
}
