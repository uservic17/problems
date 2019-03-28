package strings;

/*
return the length of the longest common substring
this is for 2 strings
can we do for more than 2 strings using DP?
complexity using dp is .. space O(n*m)
and time complexity is O(n*m)
 */
public class LongestCommonSubstring {

    public static int lcsLength(String str1, String str2) {
        if (isEmpty(str1) || isEmpty(str2)) return 0;
        int rows = str1.length();
        int columns = str2.length();

        int[][] matrix = new int[rows+1][columns+1];
        for (int i = 0; i<=rows; i++) {
            matrix[i][0] = 0;
        }
        for (int i = 0; i<=columns; i++) {
            matrix[0][i] = 0;
        }

        int max = 0;
        for (int i = 1; i <=rows; i++) {
            for (int j = 1; j<= columns; j++) {
                if (str1.charAt(i-1 ) == str2.charAt(j-1)) {
                    matrix[i][j] = matrix[i-1][j-1] + 1;
                    max = Math.max(max, matrix[i][j]);
                }
            }
        }

        return max;
    }

    private static boolean isEmpty(String str2) {
        return str2 == null || str2.length() == 0;
    }


}
