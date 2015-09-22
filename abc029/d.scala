import scala.math._

object Main {

  def main(args: Array[String]) {
    val N = scala.io.StdIn.readLine().toInt
    println(getOneSum(N))
  }

  def getOneSum(N: Int): Int = {
    val M = log10(N).toInt + 1
    (1 to M).toList.map { i =>
      val n10 = pow(10, i).toInt
      val n1  = n10 / 10
      val pattern = N % n10
      val digit = (N / n10).toInt
      val extra = if (0 <= pattern && pattern < n1) 0
                  else if (pattern < 2 * n1) pattern - n1 + 1
                  else n1
      digit * n1 + extra
    }.sum
  }

  def numToList(n: Int): List[Int] = n.toString.map{_.toString.toInt}.toList

}