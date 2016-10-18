/**
 * Project Euler #7: Calculate the 10,001st prime number.
 *
 * https://projecteuler.net/problem=7
 */
object Problem7 {

  def main(args: Array[String]) {
    /* If I try to go right to the 10,001st prime, I blow the stack. Presumably
     * because streams use memoization, splitting it into two applies of 5000
     * each worked.
     */
    val primes = sieve(2 #:: Stream.from(3, 2));
    primes.apply(5000);
    println(primes.apply(10000));
  }

  def sieve(xs: Stream[Int]): Stream[Int] = {
    xs.head #:: sieve((xs.tail) filter (_ % xs.head != 0))
  }
}