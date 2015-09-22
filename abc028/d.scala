object Main {
  def main(args: Array[String]) {
    val Array(n, k) = scala.io.StdIn.readLine().split(" ").map(_.toDouble)
    val all = n * n * n
    val n3: Double = n - 1
    val n6: Double = (k - 1) * (n - k)
    println("%.15f".format((1 + n3 * 3 + n6 * 6).toDouble / all))
  }
}