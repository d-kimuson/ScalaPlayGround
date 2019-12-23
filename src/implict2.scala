object PlayGround {
  def main(args: Array[String]): Unit = {
    implicit val ctx = 2
    printContext // 引数の暗黙化, 使い回すインスタンス(DBのコネクションとか)で使う

    // ⇓っぽいのがメイン
    implicit object IntAdder extends Adder[Int] {
      def zero: Int = 0
      def plus(x: Int, y: Int) = x + y
    }

    implicit object StrAdder extends Adder[String] {
      def zero: String = ""
      def plus(x: String, y: String): String = x + y
    }

    println(sum(List(1, 2, 3, 4, 5)))
    println(sum(List("H", "e", "l", "l", "o")))
  }

  def printContext(implicit ctx: Int): Unit = {
    println(ctx)
  }

  def sumInt(list: List[Int]): Int = list.foldLeft(0) { (x, y) => x + y }

  def sum[T](list: List[T])(implicit adder: Adder[T]): T = {
    list.foldLeft(adder.zero) { (x, y) => adder.plus(x, y) }
  }

  trait Adder[T] {
    def zero: T

    def plus(x: T, y: T): T
  }

}

