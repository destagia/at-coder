object Main {
  def main(args: Array[String]) {
    val inputs = scala.io.StdIn.readLine().split(" ").map(_.toInt)
    val head = inputs.head
    val answer = inputs.filter(_ == head).size match {
      case 2 => inputs.find(_ != head).getOrElse(-1)
      case _ => head
    }
    println(answer)
  }
}
