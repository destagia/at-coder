object Main {

  def main(args: Array[String]) =
    println((1 to 12).map{_ => scala.io.StdIn.readLine() }.map{n => if (n.contains('r')) 1 else 0 }.sum)

}