package problems.recursive;

import java.util.ArrayList;

public class DiceRoll {
    static void  getDiceRollsOf(int n) {
        helper(n , new ArrayList<>());
    }

    private static void helper(int n, ArrayList<Object> chosen) {
        if (n == 0) {
            System.out.println(chosen);
        } else {
            for (int i =1; i <= 6; i++) {
                chosen.add(i);
                helper(n -1 , chosen);
                chosen.remove(chosen.size() - 1);

            }
        }

    }

    public static void main(String[] args) {
        getDiceRollsOf(3);
    }
}
