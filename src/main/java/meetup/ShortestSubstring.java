package meetup;

import java.util.*;

/*
 Shortest Substring containing all query words
     a x b z c c d a b x c containing a b c
 */
public class ShortestSubstring {
    public String minWindow(String s, String t) {
        char[] array = t.toCharArray();
        List<Character> list = new ArrayList<>();
        for (char c : array) {
            list.add(c);
        }
        return shortestSubstringContaining(s, list);
    }

    public static String shortestSubstringContaining(String str, List<Character> list) {
        if (str == null || str.length() == 0 || list == null || list.size() == 0) return "";
        int start = -1;
        int end = -1;
        Set<Character> set = new HashSet<>(list);

        int result = Integer.MAX_VALUE;
        String resultString = "";
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char current = str.charAt(i);
            if (map.size() == list.size()) {
                System.out.println("start is: " + start + " and end is: " + end);
                if (result > end - start + 1) {
                    result = end - start + 1;
                    resultString = str.substring(start, end + 1);
                }
            }
                if (set.contains(current)) {
                    if (start == -1) {
                        start = i;
                    }
                    //if the map already contains the char.. we should update.. because it is not complete yet..
                    // and this index is bigger than the last
                    //if the index of this char was not start.. then update index to this
                    //if it was start.. we need the next elements position..
                    // maybe we get it from a heap or something
                    if (map.containsKey(current)) {
                        if (map.get(current) != start) {
                            start = findNextStart(str, start + 1, end, set);
                        }
                        map.put(current, i);

                    } else {
                        //if the map does not contain the char.. add it to the map.. with this index..
                        //and also update end to its index.
                        map.put(current, i);
                    }
                    end = i;

            }
        }
//        resultString = str.substring(start, end + 1);

        System.out.println(start);
        System.out.println(end);
        return resultString;
    }

    private static int findNextStart(String str, int start, int end, Set<Character> set) {
        for (int i = start; i <= end; i++) {
            if (set.contains(str.charAt(i))) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println("Resulting String is: " + shortestSubstringContaining("axfbzccdabxc", Arrays.asList('a', 'b', 'c')));
    }
}
