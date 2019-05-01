package problems.leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

public class POWTest {

    @Test
    public void myPow() {
        assertEquals(1024.00000, POW.myPow(2.00000, 10), 0);
    }
    @Test
    public void myPow2() {
        assertEquals(9.26100, POW.myPow(2.10000, 3), 0);
    }
    @Test
    public void myPow3() {
        assertEquals(0.25000, POW.myPow(2.00000, -2), 0);
    }
    @Test
    public void myPow4() {
        assertEquals(0, POW.myPow(0, 2), 0);
    }
    @Test
    public void myPow5() {
        assertEquals(1, POW.myPow(2.00000, 0), 0);
    }
}