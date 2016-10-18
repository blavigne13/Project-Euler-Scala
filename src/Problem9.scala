
/**
 * Find the unique pythagorean triplet that satisfies the following:
 * a < b < c
 * a + b + c = 1000
 * a^2 + b^2 = c^2
 *
 * https://projecteuler.net/problem=9
 */
object Problem9 {
  /* Makes use of Scala's Option type instead of using "in-band signaling" (eg: -1)
   * or Null to signal an invalid return value.
   */
  def main(args: Array[String]) {
    println(triplet(1));
  }

  def triplet(a: Int): Option[Int] = {
    if (3 * a >= 1000) None;
    else triplet(a, a + 1) match {
      case None => triplet(a + 1);
      case Some(num) => Some(num);
    }
  }

  def triplet(a: Int, b: Int): Option[Int] = {
    val c = 1000 - a - b;
    
    if (c <= b) None;
    else triplet(a, b, c) match {
      case None => triplet(a, b + 1);
      case Some(num) => Some(num);
    }
  }

  def triplet(a: Int, b: Int, c: Int): Option[Int] = {
    if (a * a + b * b == c * c) Some(a * b * c);
    else None;
  }
}