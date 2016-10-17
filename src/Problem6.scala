

object Problem6 {
  def main(args: Array[String]) {
    println(squareOfSums(10) - sumOfSquares(10));
    println(squareOfSums(100) - sumOfSquares(100));
  }

  def sumOfSquares(n: Int): Int = Seq.range(1, n + 1).map { x => x * x }.reduce(_ + _);
  def squareOfSums(n: Int): Int = Math.pow((n * n + n) / 2, 2).toInt
}