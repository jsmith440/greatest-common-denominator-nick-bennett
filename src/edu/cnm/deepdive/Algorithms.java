package edu.cnm.deepdive;

/**
 * This class includes stubs of two static methods, {@link #gcd(long,long)} and {@link
 * #gcd(long...)}, which compute the greatest common divisor of 2 or more {@code long} values.
 * Implementation of these methods is included in the practical exam materials of the Deep Dive
 * Coding Java + Android Bootcamp.
 */
public class Algorithms {

  private Algorithms() {
    // NOTE: There is NO need to do anything with this constructor! The method
    //       you will implement in this class is static; thus, there is no need
    //       to create instances of this class.
  }

  // THIS IS THE BASIC PROBLEM.

  /**
   * Computes and returns the greatest common divisor (GCD) of {@code a} and {@code b}.
   *
   * @param a
   * @param b
   * @return GCD of {@code a} and {@code b}.
   * @throws IllegalArgumentException if {@code a} and {@code b} are both zero.
   */
  public static long gcd(long a, long b) throws IllegalArgumentException {
    long divisor = 0;
    if (a == 0 && b == 0) {
      throw new IllegalArgumentException();
    }
    a = Math.abs(a);
    b = Math.abs(b);
    if (a == 0) {
      divisor = b;
    } else if (b == 0) {
      divisor = a;
    } else {
      while (a != 0) {
        if (a >= b) {
          a -= b;
        } else {
          b -= a;
        }
      }
      divisor = b;
    }
    return divisor;
  }


  // THIS IS THE EXTRA CREDIT PROBLEM. DON'T ATTEMPT THIS UNTIL YOU'VE COMPLETED THE BASIC PROBLEM.

  /**
   * Computes and returns the greatest common divisor (GCD) of {@code values}.
   *
   * @param values
   * @return GCD of {@code values}.
   * @throws IllegalArgumentException if {@code (values.length == 0)}, or if 2 or more elements of
   * {@code values} are zero.
   */
  public static long gcd(long... values) throws IllegalArgumentException {
    return 0; // TODO Replace with implementation as described above and in README.
  }

}
