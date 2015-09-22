import scala.collection.mutable.{ArrayBuffer => Buffer}

object Main {
  def main(args: Array[String]) {
    val N = scala.io.StdIn.readLine()
    println(count(N).mkString(" "))
  }

  def count(str: String, buf: Buffer[Int] = Buffer(0, 0, 0, 0, 0, 0)): List[Int] = str match {
    case "" => buf.toList
    case str =>
      val c = str.head
      val index = getIndex(c)
      buf(index) += 1
      count(str.tail, buf)
  }

  def getIndex(c: Char): Int = c match {
    case 'A' => 0
    case 'B' => 1
    case 'C' => 2
    case 'D' => 3
    case 'E' => 4
    case 'F' => 5
    case _   => -1
  }
}