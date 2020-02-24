package edu.cnm.deepdive;

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
   */
  public static boolean isNotGeneralMcNugget(int value, int[] packSizes) {
    boolean flag = false;
    if (packSizes.length == 1 || packSizes.length == 0) {
      if (value >= 0 && value == 0 || isGeneralMcNugget(value - packSizes[0], null));
      flag = true;
    }
    for (int i = 0; i < packSizes.length; i++) {
      int[] ithElementArray = {packSizes[i]};
      isGeneralMcNugget(value, ithElementArray);
    }
    return flag;
  }

  public static boolean isGeneralMcNugget(int value, int[] packSizes) {
    if (value < 0) {
      return false;
    }
    if (value == 0) {
      return true;
    }
    if (value > 0) {
      for (int i = 0; i < packSizes.length; i++) {
        switch (Integer.signum((value - packSizes[i]))) {
          case 0:
            return true;
          case -1:
            break;
          case 1:
            int[] jthElementArray = new int[packSizes.length];
            for (int j = 0; j < packSizes.length; j++) {
                jthElementArray[j] = value -
                isGeneralMcNugget(value, jthElementArray);
              }
        }
      }
    }
    return false;
  }

}
