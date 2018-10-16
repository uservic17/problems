package problems.hackerRank.strings;

import com.sun.javaws.exceptions.InvalidArgumentException;
import org.junit.Test;

import static org.junit.Assert.*;

public class UrlifyTest {

  @Test
  public void urlify() {
    assertEquals("hi", Urlify.urlify("hi"));
  }

  @Test(expected = IllegalArgumentException.class)
  public void urlifyEmpty() {
    assertEquals("", Urlify.urlify(""));
  }

  @Test(expected = IllegalArgumentException.class)
  public void urlifyNull() {
    assertEquals("", Urlify.urlify(null));
  }

  @Test
  public void urlify2() {
    assertEquals("hi%20Hello", Urlify.urlify("hi Hello"));
  }

  @Test
  public void urlify3() {
    assertEquals("hi%20Hello%20how%20are%20you?", Urlify.urlify("hi Hello how are you?"));
  }

  @Test
  public void urlifyOnlySpace() {
    assertEquals("%20", Urlify.urlify(" "));
  }

  @Test
  public void urlifyOnlySpaceMultiple() {
    assertEquals("%20%20%20", Urlify.urlify("   "));
  }
}