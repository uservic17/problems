package problems.leetcode;

public class ValidNumber {

    private static final char DOT_CHAR = '.';
    private static final char E_CHAR = 'e';
    private static final char NEGATIVE_CHAR = '-';
    public static final char PLUS_CHAR = '+';

    public static boolean isNumber(String s) {
        if (s == null) return false;
        String str = s.trim();
        if (str.length() == 0) return false;
        char firstChar = str.charAt(0);
        //first check validity
        if (firstChar != DOT_CHAR && firstChar != PLUS_CHAR && firstChar != NEGATIVE_CHAR && !Character.isDigit(firstChar)) {
            return false;
        }

        //take out the sign if exists
        boolean isNegative = false;
        boolean startsWithDot = false;
        if (firstChar == '+' || firstChar == '-') {
            str = str.substring(1);
            isNegative = firstChar == '-';
        } else if (firstChar == DOT_CHAR) {
            startsWithDot = true;
            str = str.substring(1);
            if (str.length() == 0) return false;
        }

        //Now if the first char is sign, then it is bad
        if (!Character.isDigit(str.charAt(0))) return false;

        boolean hasE = false;
        boolean hasMinus = false;
        Prev prev = Prev.DIGIT;

        for (int i = 1; i < str.length(); i++) {
            char current = str.charAt(i);
            if (Character.isDigit(current)) {
                prev = Prev.DIGIT;
                continue;
            }
            if (current == DOT_CHAR) {
                if (prev == Prev.E || hasE) {
                    return false;
                }
                prev = Prev.DECIMAL;
                continue;
            }
            if (current == E_CHAR) {
                if (hasE || prev == Prev.DECIMAL) return false;
                if (i == str.length() - 1) return false;
                hasE = true;
                prev = Prev.E;
                continue;
            }
            if (current == NEGATIVE_CHAR) {
                if (hasE) {
                    prev = Prev.MINUS;
                    continue;
                }
                return false;
            }
            return false;
        }
        return true;
    }
    enum Prev {
        DIGIT, E, DECIMAL, MINUS
    }
}
