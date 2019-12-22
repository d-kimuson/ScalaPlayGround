object PlayGround {
  def main(args: Array[String]): Unit = {
    println("#####")
    // For ループ
    for (x <- 1 to 3) {
      println("x = " + x)
    }

    println("#####")
    // 多重 For ループ
    for (x <- 1 to 3; y <- 1 until 3) {
      println(s"x = $x y = $y")
    }

    println("#####")
    // 条件に一致するループを抽出
    for (x <- 1 to 3; y <- 1 until 3 if x == y) {
      println(s"x = $x y = $y")
    }

    println("#####")
    // コレクションを用いた For ループ
    for (e <- List(1, 2, 3)) println(e)

    println("#####")
    // yield を使って コレクションを加工(Map的な)
    val created = for (e <- List(1, 2, 3)) yield e + 1
    println(created)
  }
}
