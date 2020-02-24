package edu.cnm.deepdive;

import java.util.Arrays;

public class Frobenius {

  /*  Pack sizes are 6, 9, and 20*/
  public static boolean isMcNugget(int value) {

    return value >= 0 && (value == 0
        || isMcNugget(value - 6)
        || isMcNugget(value - 9)
        || isMcNugget(value - 20)
    );
  }


  /**
   * Return true if the stated value can be formed as a sum of non-negative integral multiples of
   * the elements of packSizes.
   *
   * @param value     target/goal number.
   * @param packSizes array of distinct, positive pack sizes, in descending order.
   * @return true if value is a McNugget number using the specific pack sizes, false otherwise.
   * <p>
   * Try recursion by subtracting the largest number first.  If you hit a negative, back up
   * (recursively) and try again with the next smallest number
   */
  public static boolean isGeneralMcNugget(int value, int[] packSizes) {
    boolean result = false;
    if (value < 0) {
      result = false;
    }
    if (value == 0) {
      result = true;
    } else if (value > 0) {
      for (int i = 0; i < packSizes.length; i++) {
        if (isGeneralMcNugget(value - packSizes[i],
            Arrays.copyOfRange(packSizes, i, packSizes.length))) {
          result = true;
          break;
        }
      }
    }
    return result;
  }

}
