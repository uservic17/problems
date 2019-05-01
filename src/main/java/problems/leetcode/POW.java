package problems.leetcode;

public class POW {
    static int calls = 0;
    public static double myPow(double x, int n) {
        if (x == 0) return 0;
        if (n == 0) return 1;
        if (n < 0) {
            x = 1/x;
            n = -n;
        }
        double result = x;
        while (n != 1) {
            calls++;
            result *= x; ;
            n--;
        }
        System.out.println("Number of calsl made: " + calls);
        return Math.floor(result*100000)/100000;
    }

    public static void main(String[] args) {
        System.out.println(myPow(2.00000, 100));
    }


}
