import scala.collection.mutable.{ListBuffer => Buffer}

object Main {
  def main(args: Array[String]) {
    val N = scala.io.StdIn.readLine()
    val nums = N.split(" ").map(_.toInt).toSet
    val ts = three(nums)
    println(ts.map(_.sum).toList.sorted.reverse(2))
  }

  def three(nums: Set[Int], count: Int = 3): Set[Set[Int]] =
    if (count == 0)
      Set(Set[Int]())
    else {
      nums.map { n =>
        three(nums.filterNot(_ == n), count - 1).map { ns =>
          Set(n) ++ ns
        }
      }.foldRight(Set[Set[Int]]())(_ ++ _)
    }
}