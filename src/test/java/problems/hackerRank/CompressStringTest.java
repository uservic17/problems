package problems.hackerRank;

import org.junit.Test;

import static org.junit.Assert.*;

public class CompressStringTest {

  @Test
  public void compressNull() {
    assertEquals(null, CompressString.compress(null));
  }

  @Test
  public void compressEmpty() {
    assertEquals("", CompressString.compress(""));
  }
  @Test
  public void compress1() {
    assertEquals("a3b1c5d2", CompressString.compress("aaabcccccdd"));
  }

  @Test
  public void compress2() {
    assertEquals("a2b2c1", CompressString.compress("aabbc"));
  }

  @Test
  public void compress3() {
    assertEquals("ab", CompressString.compress("ab"));
  }

  @Test
  public void compress4() {
    assertEquals("a", CompressString.compress("a"));
  }

  @Test
  public void compressSame() {
    assertEquals("abcde", CompressString.compress("abcde"));
  }

  @Test
  public void compressNotEquals() {
    assertNotEquals("a2b2c", CompressString.compress("aabbc"));
  }
}