object PlayGround {
  def main(args: Array[String]): Unit = {
    val p1 = Point(10, 20)
    val p2 = Point2(10, 20)
    val p3 = Point3(10, 20)

    println(p1)
    println(p2)
    println(p3)
  }
}

// オーバーライドしてclassをよりまともに
// - hashCode(Mapのキーとなるためのメソッド)
// - toString(print文等で呼ばれる)
// - equals
// - apply(コンパニオンオブジェクト)


class Point(val x: Int, val y: Int) {
  override def hashCode(): Int = x + y

  override def toString: String = s"Point($x, $y)"

  override def equals(that: Any): Boolean = that match {
    case that: Point => x == that.x && x == that.y
    case _ => false
  }
}


object Point {
  def apply(x: Int, y: Int): Point = new Point(x, y)
}

// case class による簡略化
// hashCode, toString, equals, applyの自動実装?
// match式で Point(10, 20)でマッチングが可能になる

case class Point2(x: Int, y: Int)

// toStringだけ自前で定義し直す的なことももちろんできる

case class Point3(x: Int, y: Int) {
  override def toString: String = s"Point3($x, $y)"
}
