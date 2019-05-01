package problems.leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

public class AtoITest {

    @Test
    public void myAtoi1() {
        assertEquals(42, AtoI.myAtoi("42"));
    }  @Test
    public void myAtoi2() {
        assertEquals(-42, AtoI.myAtoi("      -42"));
    }
    @Test
    public void myAtoi3() {
        assertEquals(4193, AtoI.myAtoi("4193 with words"));
    }
    @Test
    public void myAtoi4() {
        assertEquals(0, AtoI.myAtoi("words and 987"));
    }
    @Test
    public void myAtoi5() {
        assertEquals(Integer.MIN_VALUE, AtoI.myAtoi("-91283472332"));
    }
    @Test
    public void myAtoi6() {
        assertEquals(0, AtoI.myAtoi(" "));
    }
    @Test
    public void myAtoi7() {
        assertEquals(0, AtoI.myAtoi(" -a"));
    }
    @Test
    public void myAtoi8() {
        assertEquals(0, AtoI.myAtoi(" - "));
    }
}