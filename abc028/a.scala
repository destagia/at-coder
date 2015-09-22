object Main {
  def main(args: Array[String]) {
    val N = scala.io.StdIn.readLine().toInt
    if (N < 60) {
      println("Bad")
    } else if (N < 90) {
      println("Good")
    } else if (N < 100) {
      println("Great")
    } else {
      println("Perfect")
    }
  }
}