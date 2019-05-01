package problems.leetcode;

public class POWFastPower {
    static int calls = 0;
    public static double myPow(double x, int n) {
        if (x == 0) return 0;
        if (n == 0) return 1;
        if (n < 0) {
            x = 1/x;
            n = -n;
        }



        /*
            2^5 = 32
            prev = 2
            2*2 == 4  and n becomes n / 2.. but n%2 = 1.. so multi with prev after next operation



            2^4 = 16
            so 2*2.. then n becomes n/2 = 2.. so it is square.. result * result..


            2^10 = 1024
            x = 2
            prev = 2
            2*2 = 4.. and n becomes 10/2 = 5 and n%2 = 0 .. so we are ok

            then the x  = 4, prev = 4
            4*4 = 16.. and n becomes 5/2 = 2.. but n%2 = 1.. so keep prev.. and multi it next time

            since n > 2.. keep going
            16*16 = 256... and multi with previous.. i.e. 256 * 4 = 1024  so and n become n/2 = 2/2 = 1 and remainder is 0

            2^6
            4.. remainder 0, n = 3
            16.. remainder =1 .. prev = 4
         */

        double prev = x;
        int remainder = 0;

        while (n > 1) {
            double  temp = x;
            x = x*x;
            if (remainder != 0) {
                x = x * prev;
            }
            remainder = n%2;
            n = n/2;
            prev = temp;

        }
        if (remainder != 0) {
            x = x* prev;
        }

//        System.out.println("Number of calsl made: " + calls);
        return Math.floor(x*100000)/100000;
    }

    public static void main(String[] args) {
        System.out.println("Expected: 4, Actual: " + myPow(2.00000, 2));
        System.out.println("Expected: 16, Actual: " + myPow(2.00000, 4));
        System.out.println("Expected: 64, Actual: " + myPow(2.00000, 6));
        System.out.println("Expected: 1024, Actual: " + myPow(2.00000, 10));
    }


}
