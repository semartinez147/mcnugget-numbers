package edu.cnm.deepdive;

public class Frobenius {

  /*  Pack sizes are 6, 9, and 20*/
  public static boolean isMcNugget(int value) {

    /*    TODO return true if value can be expressed as the sum of McNugget packs
           (integral multiples including zero of the 3 original pack sizes)*/
    if (value <0) {
      return false;
    }
    if (value == 0) {
      return true;
    }
    return (isMcNugget(value-6)
        || isMcNugget(value-9)
        || isMcNugget(value-20)
        );
  }

}
