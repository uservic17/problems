package problems.effectiveJava;

import javax.print.DocFlavor;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * input is large text
 * output is - print all large anagrams from the text
 */
public class FindAllAnagramsSolution {

  private static void printLargeAnagramSets(final Path path, final int THRESHOLD) throws IOException {
    //read file line by line
    //for every word, alphabetize,
    //have a map.. with key.. alphabetized word, and the values are a set..
    //print all the entry sets where the size of set is greater than the threshold passed

    Map<String, Set<String>> map = new HashMap<>();

    Scanner scanner = new Scanner(path);
    while (scanner.hasNext()) {
      String word = scanner.next();
      String alpha = alphabetize(word);
      if (map.get(alpha) == null) {
        Set< String>  set = new TreeSet<>();
        set.add(word);
        map.put(alpha, set);
      } else {
        map.get(alpha).add(word);
      }
    }
//    map = map.entrySet().stream().filter(entry -> entry.getValue().size()>= 2).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    map.entrySet().stream().filter(entry -> entry.getValue().size()>= THRESHOLD).forEach(System.out::println);


  }

  private static String alphabetize(String str) {
    char[] array = str.toCharArray();
    Arrays.sort(array);
    return Arrays.toString(array);
  }
  public static void main(String[] args) throws IOException {
//    String s = "foo bar baz";
//    String[] array = s.split(" ");
//    for (String word: array) {
//      System.out.println(word);
//    }
    Path path = Paths.get("/Users/VickyD/IdeaProjects/Problems/src/main/java/problems/effectiveJava/largeText.txt");
    printLargeAnagramSets(path, 2);
  }

}
