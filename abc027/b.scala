object Main {

  def main(args: Array[String]) {
    val N = scala.io.StdIn.readLine().toInt
    val inputs = scala.io.StdIn.readLine().split(" ").map(_.toInt).toList
    val sum = inputs.sum
    if (sum % N != 0)
      println(-1)
    else {
      val unit = (sum / N)
      val result = (1 to N - 1).map { n =>
        val left  = inputs.take(n).sum
        val right = inputs.drop(n).sum
        !(left == unit * n && right == sum - unit * n)
      }
      println(result.filter(x => x).size)
    }
  }

}