/**
 * Project Euler #2: Sum of even Fibonacci numbers under 4,000,000
 * https://projecteuler.net/problem=2
 */
object Problem2 {

  def main(args: Array[String]) {
    lazy val fibs: Stream[Long] = 1 #:: 1 #:: fibs.zip(fibs.tail).map { x => x._1 + x._2 };

    println(fibs.takeWhile { _ < 4000000 }.filter { _ % 2 == 0 }.reduce(_ + _));

    // hackerrank
    //    (1 to io.StdIn.readInt)
    //      .map { x => io.StdIn.readLong }
    //      .map { x => fibs.takeWhile { _ < x }.filter { _ % 2 == 0 }.reduce(_ + _) }
    //      .foreach { println }
  }
}