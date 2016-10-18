/**
 * Project Euler #2: Sum of even Fibonacci numbers under 4,000,000
 *
 * https://projecteuler.net/problem=2
 */
object Problem2 {

  def main(args: Array[String]) {
    /* Writing up an explanatory summary is always a great way for me to to refresh my
     * memory and/or learn a little bit more about something, so here we go: 
     * 
     * fibs: [1, 1, f3, f4, ...]
     * tail: [1, f3, f4, ...]
     * zip: [(1, 1), (1, f3), (f3, f4), (f4, ...)] 
     * map: [1, 1, 2, 1+f3, f3+f4, f4+...]
     * 
     * A typical recursion would end up as something like this:
     * [1, 1, (f1+f2), (f2+(f1+f2)), ((f1+f2)+(f2+(f1+f2))), ...]
     * 
     * But since streams are lazy, and since as values are memoized as they are materialized,
     * so by the time a given element is needed, the previous elements have known values that
     * can be referenced instead of relying on a recursive call.
     */
    lazy val fibs: Stream[Long] = 1 #:: 1 #:: fibs.zip(fibs.tail).map { x => x._1 + x._2 };
    val result = fibs.takeWhile { _ < 4000000 }.filter { _ % 2 == 0 }.reduce(_ + _);

    println(result);

    // hackerrank
    //    (1 to io.StdIn.readInt)
    //      .map { x => io.StdIn.readLong }
    //      .map { x => fibs.takeWhile { _ < x }.filter { _ % 2 == 0 }.reduce(_ + _) }
    //      .foreach { println }
  }
}