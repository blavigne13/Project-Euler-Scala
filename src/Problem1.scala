/**
 * Project Euler #1: Sum of multiples of 3 and 5 below 1000
 * 
 * https://projecteuler.net/problem=1
 */
object Problem1 {

  def main(args: Array[String]) {
    println(mul35(1000));

    // hackerrank
    // (1 to io.StdIn.readInt).foreach(x => println(mul35(io.StdIn.readInt)));
  }

  def mul35(n: Long): Long = {
    // ensure multiples of both 3 and 5 are not double-counted
    sumMultiples(3, n) + sumMultiples(5, n) - sumMultiples(15, n);
  }

  def sumMultiples(m: Long, n: Long): Long = {
    val x = (n - 1) / m; // x represents the number of multiples of m in [1..n)
    (x * x + x) / 2 * m; // each val in [1..x] represents val * x, so sum, then multiply by m
  }
}