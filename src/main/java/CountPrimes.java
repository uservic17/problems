import java.util.ArrayList;
import java.util.List;

public class CountPrimes {

    public static int countPrimes(int k ) {
        List<Integer> list = new ArrayList<>();
//        list.add(2);
        for (int i = 2; i < k; i++) {
            boolean isPrime = true;
            for (int j = 0; j < list.size(); j++) {
                if (i % list.get(j) == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                list.add(i);
            }
        }
        return list.size();
    }

    public static void main(String[] args) {
        System.out.println(countPrimes(10));
    }
}
