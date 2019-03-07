package problems.recursive;

import java.util.ArrayList;
import java.util.List;

public class DiceRollsReturn {
  static List<List<Integer>> getDiceRollsOf(int n) {
    return helper(n, new ArrayList<>(), new ArrayList<>());
  }

  static private List<List<Integer>> helper(Integer n, List<List<Integer>> result, List<Integer> list) {
    if (n == 0) {

      result.add(new ArrayList<>(list));
    } else {
      for (int i : new int[]{1, 2, 3, 4, 5, 6}) {
        list.add(i);
        helper(n - 1, result, list);
        list.remove(list.size() - 1);
      }
    }
    return result;
  }

  public static void main(String[] args) {
    System.out.println(getDiceRollsOf(3));
  }
}
