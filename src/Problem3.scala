/**
 * Project Euler #3: Maximum prime factor
 *
 * https://projecteuler.net/problem=3
 */
object Problem3 {
  
  def main(args: Array[String]) {
    println(factor(600851475143L, 2));
  }

  /* I Played around with trying for a more "idiomatic" solution, using a stream of primes, but
   * in the end, it was keeping track of more than this problem really needed, and it kept blowing
   * the stack. Even though the solution I implemented tests against many unnecessary values, 
   * filtering them (eg: for primality) adds significant complexity.
   */
  def factor(n: Long, m: Long): Long = {
    if (n == 1)
      m;
    else if (n % m == 0)
      factor(n / m, m);
    else
      factor(n, m + 1);
  }
}