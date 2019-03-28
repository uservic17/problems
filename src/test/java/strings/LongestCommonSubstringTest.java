package strings;

import org.junit.Test;
import problems.hackerRank.strings.LongestSubstring;

import static org.junit.Assert.*;

public class LongestCommonSubstringTest {

    @Test
    public void lcsLength() {
        assertEquals(0, LongestCommonSubstring.lcsLength("", ""));
    }

    @Test
    public void lcsLength2() {
        assertEquals(0, LongestCommonSubstring.lcsLength("", "sdfsdf"));
    }

    @Test
    public void lcsLength3() {
        assertEquals(1, LongestCommonSubstring.lcsLength("a", "aa"));
    }

    @Test
    public void lcsLength4() {
        assertEquals(5, LongestCommonSubstring.lcsLength("abcde", "abcde"));
    }

    @Test
    public void lcsLength5() {
        assertEquals(5, LongestCommonSubstring.lcsLength("aaaaa", "aaaaabb"));
    }

    @Test
    public void lcsLength6() {
        assertEquals(5, LongestCommonSubstring.lcsLength("abcde", "hhhhhhabcde"));
    }

    @Test
    public void lcsLength7() {
        assertEquals(5, LongestCommonSubstring.lcsLength("vicky", "hellovickyhello"));
    }

    public void lcsLength8() {
        assertEquals(3, LongestCommonSubstring.lcsLength("vicky", "helloviickyhello"));
    }
}