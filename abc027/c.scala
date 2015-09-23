object Main {

  sealed trait Arrow { def reverse: Arrow }
  case object Left extends Arrow { val reverse = Right }
  case object Right extends Arrow { val reverse = Left }

  sealed trait Turn { def arrow: Arrow }
  case class Takahashi(arrow: Arrow) extends Turn
  case class Aoki(arrow: Arrow) extends Turn

  def main(args: Array[String]) {
    try {
      val N = scala.io.StdIn.readLine().toLong
      var i = 0
      while(1L << (i + 1) <= N) { i += 1 }
      val (tArrow, aArrow) = if (i % 2 == 0) (Right, Left) else (Left, Right)
      val takahashi = Takahashi(tArrow)
      simulate(N, takahashi) match {
        case Takahashi(_) => println("Aoki")
        case Aoki(_) => println("Takahashi")
      }
    }
    catch {
      case e: NumberFormatException => println("Aoki")
    }
  }

  def next(arrow: Arrow, num: Long): Long = arrow match {
    case Left => num * 2
    case Right => num * 2 + 1
  }

  def simulate(N: Long, turn: Turn, x: Long = 1): Turn = {
    val y = next(turn.arrow, x)
    if (y > N)
      turn
    else turn match {
      case Aoki(arrow) => simulate(N, Takahashi(arrow.reverse), y)
      case Takahashi(arrow) => simulate(N, Aoki(arrow.reverse), y)
    }
  }

}
