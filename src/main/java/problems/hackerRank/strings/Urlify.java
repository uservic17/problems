package problems.hackerRank.strings;

public class Urlify {
  static String urlify(String str) {
    if (str == null || str.length() == 0) throw new IllegalArgumentException("String is null or of length zero");
    int spaceCount = 0;
    for (int i = 0; i < str.length(); i++) {
      if (str.charAt(i) == ' ') spaceCount++;
    }
    if (spaceCount == 0) return str;
    int trueLength = str.length() + spaceCount * 2;
    char[] array =  new char[trueLength];

//    char[] array  = getFinalCharArray(str);

    for (int i = array.length - 1, j = str.length() - 1; i >= 0; i--, j--) {
      if (str.charAt(j) == ' ') {
        array[i--] = '0';
        array[i--] = '2';
        array[i] = '%';
      } else {
        array[i] = str.charAt(j);
      }

    }
    return String.valueOf(array);
  }
}
