package foobar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FactorCombination {
    private static ArrayList<Integer> allFactors(int num) {
        int upperlimit = (int) (Math.sqrt(num));
        ArrayList<Integer> factors = new ArrayList<Integer>();
        for (int i = 2; i <= upperlimit; i += 1) {
            while (num % i == 0) {
                factors.add(i);
                num = num / i;
            }
        }
        Collections.sort(factors);
        return factors;
    }

    public static List<List<Integer>> getFactors(int num) {
        List<Integer> factors = allFactors(num);
        List<List<Integer>> result = new ArrayList<>();
        helper(result, factors, new ArrayList<Integer>());
        return result;
    }

    private static void helper(List<List<Integer>> result, List<Integer> available, ArrayList<Integer> chosen) {
        if (available.size() == 0) {
            result.add(new ArrayList<>(chosen));
        } else {
            for (int i = 0; i < available.size(); i++) {
                if (i - 1 >= 0 && available.get(i).equals(available.get(i - 1))) continue;
                int temp = available.remove(i);
                for (int j = 0; j < available.size(); j++) {
                    chosen.
                }
                chosen.add(temp);
                helper(result, available, chosen);
                chosen.remove(chosen.size() - 1);
                available.add(i, temp);
            }
        }
    }


    public static void main(String[] args) {
        int num = 36;
        System.out.println("All factors: " + allFactors(num));
        System.out.println("And the combinations are:" );
        System.out.println(getFactors(num));
    }
}
