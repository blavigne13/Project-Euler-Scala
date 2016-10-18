/**
 * Project Euler #6: Sum square difference
 *
 * https://projecteuler.net/problem=6
 */
object Problem6 {

  def main(args: Array[String]) {
    println(squareOfSums(10) - sumOfSquares(10));
    println(squareOfSums(100) - sumOfSquares(100));
  }

  /* Calculate sum of the series [1..n] directly (n(n+1)/2) */
  def squareOfSums(n: Int): Int = {
    Math.pow((n * n + n) / 2, 2).toInt
  }

  /* Don't know the formula for sum of this series, so brute force it is */
  def sumOfSquares(n: Int): Int = {
    Seq.range(1, n + 1)   // [1..n]
      .map { x => x * x } // [1^2, 2^2, ..., n^2]
      .reduce(_ + _);     // sum the series
  }
}