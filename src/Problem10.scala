/**
 * Project Euler #10: Sum of primes less than 2,000,000
 *
 * https://projecteuler.net/problem=10
 */
import scala.annotation.tailrec;

object Problem10 {

  def main(args: Array[String]) {
    val result = sieve((2L until 2000000).toList, Nil).reduce(_ + _);
    println(result);
  }

  /**
   * Tail recursive Sieve of Eratosthenes. Without tail recursion, the stack
   * was blowing almost immediately.
   */
  @tailrec
  def sieve(primes: List[Long], accum: List[Long]): List[Long] = primes match {
    case p :: ps => sieve(ps.filter(_ % p != 0), p :: accum);
    case _ => accum;
  }
}