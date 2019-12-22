object PlayGround {
  def main(args: Array[String]): Unit = {
    val s1 = new Triange()
    val s2 = new UnknownShape()

    s1.draw()
    s2.draw()
  }
}

// Classと継承
// 複数クラスの継承不可 => 代わりにtraitのmix-in

abstract class Shape {
  def draw(): Unit = {
    println("不明な図形")
  }
}

class Triange extends Shape {
  override def draw(): Unit = {
    println("三角形")
  }
}

class UnknownShape extends Shape
