object Main {

  sealed trait Arrow { def reverse: Arrow ; def value(x: Long): Long }
  case object Left extends Arrow { val reverse = Right ; def value(x: Long) = x * 2}
  case object Right extends Arrow { val reverse = Left ; def value(x: Long) = x * 2 + 1}

  sealed trait Turn { def arrow: Arrow }
  case class Takahashi(arrow: Arrow) extends Turn
  case class Aoki(arrow: Arrow) extends Turn

  def main(args: Array[String]) {
    try {
      val N = scala.io.StdIn.readLine().toLong
      var i = 0
      while(1L << (i + 1) <= N) { i += 1 }
      val (tArrow, aArrow) = if (i % 2 == 0) (Right, Left) else (Left, Right)
      simulate(N, Takahashi(tArrow), Aoki(aArrow)) match {
        case Takahashi(_) => println("Aoki")
        case Aoki(_) => println("Takahashi")
      }
    }
    catch { case e: NumberFormatException => println("Aoki") }
  }

  def simulate(N: Long, turn: Turn, nextTurn: Turn, x: Long = 1): Turn = {
    val y = turn.arrow.value(x)
    if (y > N) turn
    else       simulate(N, nextTurn, turn, y)
  }

}