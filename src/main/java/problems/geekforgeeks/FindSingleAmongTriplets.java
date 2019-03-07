package problems.geekforgeeks;

public class FindSingleAmongTriplets {
  public static int findSingle(int[] array) {
    int result = 0;

    //for every number, get their bit at a particular position
    //take the sum
    // % 3.. whatever the remainder, set that bit in result
    //so effectively, get the bits of each number, add, get remainder.. if not 0, set the bit in result
    //go from 0 to 31.. as integer is 4bytes

    for (int i = 0; i < 32; i++) {
      int x = 1 << i;
      int sum = 0;
      for (int j = 0; j < array.length; j++) {
        sum = sum + ( x & array[j]);
      }
      if (sum % 3 != 0 ) {
        result = result | x;
      }
    }


    return result;
  }

  public static void main(String[] args) {
    System.out.println( 1 | 2);
  }
}
