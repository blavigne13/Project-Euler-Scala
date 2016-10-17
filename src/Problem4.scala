/**
 * Project Euler #4: Largest palindromic product of 3-digit numbers
 * https://projecteuler.net/problem=4
 */
object Problem4 {

  def main(args: Array[String]) {
    val pals = scala.collection.mutable.ArrayBuffer[Int]();
    
    for (i <- 100 to 999; j <- i to 999) {
      pals += i * j;
    }
    
    println(pals.filter { x => x == x.toString().reverse.toInt }.max);
  }
}