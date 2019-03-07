package problems.recursive;

public class ListPermutations1 {
  static void perms(String s) {
    foo("", s);
  }
  static void foo(String sofar, String rest) {
    if (rest.isEmpty()) {
      System.out.println(sofar);
    } else {
      for (int i = rest.length()-1; i>=0; i--) {
//      for (int i = 0; i< rest.length(); i++) {
        String next = sofar + rest.charAt(i);
        String nextRest = rest.substring(0,i) + rest.substring(i+1);
        foo(next, nextRest);
      }
    }
  }

  public static void main(String[] args) {
    perms("abcde");
  }
}
