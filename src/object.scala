object PlayGround {
  def main(args: Array[String]): Unit = {
    val p1 = new Point(10, 20)
    p1.print()
    Point.help()
  }
}

class Point(val x: Int, val y: Int) {
  def print() = {
    println(s"($x, $y)")
  }

  def distance(that: Point) = {
    val xdiff = math.abs(x - that.x)
    val ydiff = math.abs(y - that.y)

    math.sqrt(xdiff * xdiff - ydiff * ydiff).toInt
  }

  def +(that: Point) = {
    new Point(x + that.x, y + that.y)
  }
}

object Point {
  def help(): Unit = {
    println("############ class Point ############")
    println("# - Point(x: Int, y: Int): Unit     #")
    println("# - distance(that: Point): Int      #")
    println("# - +(that: Point): Point           #")
    println("# - print(): Unit                   #")
    println("#####################################")
  }
}
