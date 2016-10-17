/**
 * Project Euler #3: Maximum prime factor
 * https://projecteuler.net/problem=3
 */
object Problem3 {

  def main(args: Array[String]) {
    println(factor(600851475143L, 2));
  }

  def factor(n: Long, m: Long): Long = {
    if (n == 1) {
      m;
    } else if (n % m == 0) {
      factor(n / m, m);
    } else {
      factor(n, m + (if (m == 2) 1 else 2))
    }
  }

  /* 
   * Played around with trying for a more "idiomatic" solution, using a stream of primes, but in the end,
   * it was keeping track of more than this problem really needed, and it kept blowing the stack. Eg:
   * def sieve(xs: Stream[Long]): Stream[Long] = xs.head #:: sieve((xs.tail) filter (_ % xs.head != 0))
   */
}