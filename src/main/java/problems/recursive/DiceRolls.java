package problems.recursive;

import java.util.ArrayList;
import java.util.List;

public class DiceRolls {
  static void  getDiceRollsOf(int n) {
    helper(n , new ArrayList<>());
  }

  static private  void helper(Integer n, List<Integer> list) {
//    System.out.println("n is: " + n + " and list is: " + list);
    if (n == 0) {
      System.out.println(list);
    } else {
      for(int i : new int[]{1, 2, 3, 4, 5, 6}) {
        list.add(i);
        helper(n - 1, list);
        list.remove(list.size() - 1);
      }
    }
  }

  public static void main(String[] args) {
    getDiceRollsOf(2);
  }
}
