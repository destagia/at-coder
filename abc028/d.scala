object Main {
  def main(args: Array[String]) {
    val Array(n, k) = scala.io.StdIn.readLine().split(" ").map(_.toInt)
    val all = getAll(n)
    val low = k - 1
    val up  = n - k
    val n3 = low + up
    val n6 = low * up
    println((1 + n3 * 3 + n6 * 6).toDouble / all)
  }

  def getAll(n: Int): Double = (n * n * n).toDouble
}