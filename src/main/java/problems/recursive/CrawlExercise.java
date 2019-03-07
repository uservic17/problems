package problems.recursive;

import java.io.File;

public class CrawlExercise {
  static void printAllFiles(String path) {
    printAllFilesPrivate(path, "");
  }
  private static void printAllFilesPrivate(String path, String indent) {
    File  file = new File(path);
    if (file.exists() && file.isFile()) {
      System.out.println(indent + file.getName());
    } else {
      System.out.println(indent + file.getName());
      File[] array = file.listFiles();
      for (File child : array) {
        printAllFilesPrivate(child.getPath(), indent + "  ");
      }
    }
  }

  public static void main(String[] args) {
    printAllFiles("/Users/VickyD/Documents");
  }
}
