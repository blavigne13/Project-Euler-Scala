object Problem7 {

  def main(args: Array[String]) {
    def sieve(xs: Stream[Int]): Stream[Int] = {
      xs.head #:: sieve((xs.tail) filter (_ % xs.head != 0))
    }
    val primes = sieve(2 #:: Stream.from(3, 2));

    /* if I try to go right to the 10,001st prime, I blow the stack, presumably because of the 
     * sheer number of stack frames requires to lazily evaluate the 10,0001st prime number in one
     * shot. Since streams use memoization, splitting it into two applies of 5000 each worked.*/
    primes.apply(5000);
    println(primes.apply(10000));
  }
}