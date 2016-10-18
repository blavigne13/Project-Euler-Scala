/**
 * Project Euler #5: Smallest number divisible by 1 through 20
 *
 * https://projecteuler.net/problem=5
 */
object Problem5 {
  
  def main(args: Array[String]) {
    println(listFact((2 to 10).toList).reduce(_ * _));
    println(listFact((2 to 20).toList).reduce(_ * _));
  }

  /**
   * Reduce a list of Int to its "essential" factors such that the product of
   * those factors yields the smallest number divisible by each number in the
   * input list.
   */
  def listFact(xs: List[Int]): List[Int] = xs match {
    case Nil => Nil;
    case x :: xs => x :: listFact(tailFact(xs, x));
  }

  /**
   * Divide fact out of each element by which it is divisible.
   */
  def tailFact(xs: List[Int], fact: Int): List[Int] = xs match {
    case Nil => Nil;
    case x :: xs if (x % fact == 0) => x / fact :: tailFact(xs, fact);
    case x :: xs => x :: tailFact(xs, fact);
  }

}