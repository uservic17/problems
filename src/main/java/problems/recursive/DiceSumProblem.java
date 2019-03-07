package problems.recursive;

import java.util.ArrayList;
import java.util.List;

public class DiceSumProblem {
  static void  getDiceRollsOf(int n, int desiredSum) {
    helper(n , desiredSum,  new ArrayList<>());
  }

  static int counter = 0;
  static private  void helper(Integer n, int desiredSum, List<Integer> list) {
//    System.out.println("n is: " + n + " and list is: " + list);
    counter++;
    if (n == 0) {
      if (list.stream().mapToInt(i -> i).sum() == desiredSum) {
        System.out.println(list);
      }
    } else {
      for(int i : new int[]{1, 2, 3, 4, 5, 6}) {
        list.add(i);
        helper(n - 1, desiredSum,  list);
        list.remove(list.size() - 1);
      }
    }
  }

  public static void main(String[] args) {
    getDiceRollsOf(3, 7);
    System.out.println("Total calls: "+ counter);
  }
}
