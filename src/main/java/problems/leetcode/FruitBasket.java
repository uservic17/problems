package problems.leetcode;

import java.util.HashSet;
import java.util.Set;

public class FruitBasket {

  public static int totalFruit(int[] tree) {
    return totalFruit(tree, 2);
  }

  public static int totalFruit(int[] tree, int basketCount) {
    if (tree.length <= 2) return tree.length;
    int result = 0;
    Set<Integer> set = new HashSet<>(2);
    set.add(tree[0]);
    int startIndex = 0;
    int switchIndex = -1; //this is the index at which the switch happens.. for ex. {1,1,3} .. switchIndex is 2

    //case 1: if the current element is there in the set
    //   1a: if it is the same as the tree[currentIndex - 1], continue
    //   1b: if it is different from the previousElement, set switch to currentIndex
    //update result

    //case 2: if the current elemnet is not in the set
    //  2a: if the set size is less than 2, add this element to set and set switchIndex
    //  2b: if the set size is 2, remove tree[switchIndex - 1] element from the set,
    //      set the start index to switchIndex
    //      set the switchIndex to currentIndex
    //update result

    int currentElement;
    for (int currentIndex = 1; currentIndex < tree.length; currentIndex++) {
      currentElement = tree[currentIndex];
      if (set.contains(currentElement)) {
        if (currentElement != tree[currentIndex - 1]) {
          switchIndex = currentIndex;
        }
      } else {
        if (set.size() == 2) {
          set.remove(tree[switchIndex - 1]);
          startIndex = switchIndex;
        }
        switchIndex = currentIndex;
        set.add(currentElement);
      }
      result = Math.max(result, currentIndex - startIndex + 1);

    }
    return result;
  }
}