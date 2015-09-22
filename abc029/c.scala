object Main {

  def main(args: Array[String]) {
    val N = scala.io.StdIn.readLine().toInt
    password(N, List("a", "b", "c")).foreach(println)
  }

  def password(N: Int, candidate: List[String], str: String = ""): List[String] =
    if (N == 0)
      List(str)
    else
      candidate.map(s => password(N - 1, candidate, str + s)).foldRight(List[String]())(_ ++ _)

}