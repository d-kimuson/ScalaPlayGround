object PlayGround {
  def main(args: Array[String]): Unit = {
    // match 式
    // 値の分解, 取り出し, 条件分岐(valueだけでなくclassも)
    intMatchSample(0)
    intMatchSample(1)
    intMatchSample(2)
    intMatchSample(3)

    listMatchSample(List(1, 2, 3, 4, 5, 6))
    listMatchSample(List(1, 2, 3))
    listMatchSample(List(1, 2, 3, 4, 5))

    val result = reverse(List(10, 20, 30), Nil) // Nil = 空リスト
    println(result)


    matchGuard(List("A", "B", "C", "D", "E"))
    matchGuard(List("A", "C", "E", "G", "I"))

    println(last2(List("A", "B", "C", "D", "E")))


  }

  def intMatchSample(i: Int): Unit = {
    val matched = i match {
      case 0 => "Int: A"
      case 1 => "Int: B"
      case 2 => "Int: C"
      case _ => "Int: else"
    }

    println(matched)
  }

  def listMatchSample(l: List[Int]): Unit = {
    // 上から順にマッチする
    val matched = l match {
      case List(1, 2, 3) => "List: A"
      case List(1, 2, 3, 4) => "List: B"
      case List(1, 2, 3, 4, 5, 6) => "List: C"
      case List(a, b, c, d) => "List: 要素数4"
      case List(a, b, c, d, e) => "List: 要素数5"
    }

    println(matched)
  }

  def reverse[A](list: List[A], result: List[A]): List[A] = list match {
    // 再帰関数と組み合わせ
    // x::xs => 要素数1以上のリストにマッチして, 先頭要素(x), 残り(xs)に分解
    case x :: xs => reverse(xs, x :: result) // (a1), (a2, ..., a4) => reverse((a2, ..., a4), (a1) + result)
    case Nil => result
  }

  def matchGuard(l: List[String]): Unit = {
    // ガード式: if式でマッチ条件をカスタマイズ
    val matched = l match {
      case List("A", b, c, d, e) if b != "B" => s"A, $b, $c, $d, $e"
      case _ => "Nothing"
    }

    println(matched)
  }

  def last2(l: List[String]): String = {
    // Match はネストした対象にも行える
    // x::_::Nil => ::(x, ::(_, Nil)) の 省略記法

    l match {
      case x :: _ :: Nil => x    // ::(x, ::(_, Nil)) => 要素, 空リスト
      case x :: xs => last2(xs)  // 最後-1の要素まで再帰する
      case _ => sys.error("Length Error, argument l: List[String] must have at least 2 elements.")
    }
  }
}
