/**
 * Project Euler #119: Digit power sum
 *
 * https://projecteuler.net/problem=119
 */
import scala.annotation.tailrec;
import scala.collection.mutable.ListBuffer;

object Problem119 {
  def main(args: Array[String]) {
    val dpss = digitPowerSum();
    println(dpss.apply(1));
    println(dpss.apply(9));
    println(dpss.apply(29));
  }

  def digitPowerSum(): List[Long] = {
    val dpss = ListBuffer[Long]();
    
    for (dsum <- 2L to 17 * 9) { // digit sums up to 10^18 - 1
      dpss ++= Stream.iterate(dsum)(x => x * dsum) // append stream of powers of n
        .takeWhile(_ < Long.MaxValue / dsum)       // end stream before overflow
        .filter(_ > 9)                             // 2+ digits required
        .filter(x => isDPS(x, digitSum(x, 0)))     // remove "non-DPS" values
    }

    dpss.distinct.sorted.toList;
  }

  @tailrec def isDPS(n: Long, ds: Long): Boolean =
    if (n == ds) {
      true;
    } else if (ds > 1 && n % ds == 0) {
      isDPS(n / ds, ds);
    } else {
      false;
    }

  @tailrec def digitSum(n: Long, ret: Long): Long =
    if (n > 9) {
      digitSum(n / 10, ret + n % 10);
    } else {
      ret + n;
    }
}