package strings;

import org.junit.Test;
import strings.longestCommonSubsequence.LongestCommonSubsequenceRecursive;

import static org.junit.Assert.*;

public class LongestCommonSubstringRecursiveTest {

    @Test
    public void lcsLength() {
        assertEquals(0, LongestCommonSubsequenceRecursive.lcsLength("", ""));
    }

    @Test
    public void lcsLength2() {
        assertEquals(0, LongestCommonSubsequenceRecursive.lcsLength("", "sdfsdf"));
    }

    @Test
    public void lcsLength3() {
        assertEquals(1, LongestCommonSubsequenceRecursive.lcsLength("a", "aa"));
    }

    @Test
    public void lcsLength4() {
        assertEquals(5, LongestCommonSubsequenceRecursive.lcsLength("abcde", "abcde"));
    }

    @Test
    public void lcsLength5() {
        assertEquals(5, LongestCommonSubsequenceRecursive.lcsLength("aaaaa", "aaaaabb"));
    }

    @Test
    public void lcsLength6() {
        assertEquals(5, LongestCommonSubsequenceRecursive.lcsLength("abcde", "hhhhhhabcde"));
    }

    @Test
    public void lcsLength7() {
        assertEquals(5, LongestCommonSubsequenceRecursive.lcsLength("vicky", "hellovickyhello"));
    }

    public void lcsLength8() {
        assertEquals(3, LongestCommonSubsequenceRecursive.lcsLength("vicky", "helloviickyhello"));
    }
}