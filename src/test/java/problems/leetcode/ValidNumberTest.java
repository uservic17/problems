package problems.leetcode;


import org.junit.Test;

import static org.junit.Assert.*;

public class ValidNumberTest {

    @Test
    public void isNumber() {
        assertEquals(ValidNumber.isNumber("0"), true);
    }

    @Test
    public void isNumber2() {
        assertEquals(ValidNumber.isNumber(" 0.1 "), true);
    }

    @Test
    public void isNumber3() {
        assertEquals(ValidNumber.isNumber("abc"), false);
    }

    @Test
    public void isNumber4() {
        assertEquals(ValidNumber.isNumber("1 a"), false);
    }

    @Test
    public void isNumber5() {
        assertEquals(ValidNumber.isNumber("2e10"), true);
    }

    @Test
    public void isNumber6() {
        assertEquals(ValidNumber.isNumber(" -90e3   "), true);
    }

    @Test
    public void isNumber7() {
        assertEquals(ValidNumber.isNumber(" 1e"), false);
    }

    @Test
    public void isNumber8() {
        assertEquals(ValidNumber.isNumber("e3"), false);
    }

    @Test
    public void isNumber9() {
        assertEquals(ValidNumber.isNumber(" 6e-1"), true);
    }

    @Test
    public void isNumber10() {
        assertEquals(ValidNumber.isNumber(" 99e2.5 "), false);
    }

    @Test
    public void isNumber11() {
        assertEquals(ValidNumber.isNumber("53.5e93"), true);
    }

    @Test
    public void isNumber12() {
        assertEquals(ValidNumber.isNumber(" --6 "), false);
    }

    @Test
    public void isNumber13() {
        assertEquals(ValidNumber.isNumber("-+3"), false);
    }

    @Test
    public void isNumber14() {
        assertEquals(ValidNumber.isNumber("95a54e53"), false);
    }

    @Test
    public void isNumber15() {
        assertEquals(ValidNumber.isNumber("42.e6"), false);
    }

    @Test
    public void isNumber16() {
        assertEquals(ValidNumber.isNumber("42.e.6"), false);
    }
    @Test
    public void isNumber17() {
        assertEquals(true, ValidNumber.isNumber(".1"));
    }
    @Test
    public void isNumber18() {
        assertEquals(false, ValidNumber.isNumber(" "));
    }
    @Test
    public void isNumber19() {
        assertEquals(false, ValidNumber.isNumber("0.."));
    }
}
