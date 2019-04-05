package foobar;

import java.util.ArrayList;
import java.util.Collections;

public class FindFactors {
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

    public static void main(String[] args) {
        System.out.println(allFactors(36));
    }
}
