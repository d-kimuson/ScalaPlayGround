object PlayGround {
  def main(args: Array[String]): Unit = {
    val h = new Hoge()
    h(0)
  }
}

class Hoge() {
  def apply(x: Int): Unit = {
    println(s"$x is called")
  }
}
