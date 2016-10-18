/**
 * Project Euler #4: Largest palindromic product of 3-digit numbers
 *
 * https://projecteuler.net/problem=4
 */
object Problem4 {

  def main(args: Array[String]) {
    /* In this case my approach is best served by a mutable collection: most of
     * work is generating a large number of calculated values, and adding them to
     * said collection.
     * 
     * As for the choice between a List or Array backed collection, in the case
     * it doesn't matter too much, though I suspect that the filtering at the end
     * is faster for List-backed collections by some constant factor.
     * 
     * Taking the max at the end is linear time, since the list is unsorted. This
     * could be improved, but doing so would cost more than it would save:
     * -> Using a tree-backed collection would make it a logrithmic time operation, but
     * would do the same to the append operation, making it take linearithmic (n log n)
     * time to populate (vs linear time for a list).
     * -> Sorting the list can make finding the max element a constant time operation,
     * but since a comparison sort is linearithmic, this too is a no-go. 
     */
    val pals = scala.collection.mutable.ListBuffer[Int]();

    for (i <- 100 to 999; j <- i to 999) {
      pals += i * j;
    }
    val result = pals
      .filter(x => x == x.toString().reverse.toInt) // filter for palindromic numbers
      .max;
    println(result);
  }
}