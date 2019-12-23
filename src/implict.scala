object PlayGround {
  def main(args: Array[String]): Unit = {
    if (1) println("Hello") // 1: Int is not Boolean => intToBooleanが呼ばれてユーザー定義の型変換が行われる

    // 1 => 暗黙の型変換で RichInt(1) => RichInt(1).isPositive()に
    // 既存のInt型にisPositiveメソッドを追加したのと同等の効果が得られる
    // => enrich my lobrary パターン
    println(1.isPositive)
  }

  implicit def intToBoolean(n: Int): Boolean = n != 0
  implicit def enrichInt(self: Int): RichInt = new RichInt(self)

  // enrich my lobrary パターン用に追加された機構
  // 自動的に, 既存クラスからEnrichクラスへの型変換が定義される
  implicit class RichInt2(val self: Int) {  // enrichIntと被るからこのままじゃ動かないよ
    def isPositive: Boolean = self > 0

    // implict def enrichInt(self Int): RichInt = new RichInt(self) が暗黙的に定義
  }
}

class RichInt(val self: Int) {
  def isPositive: Boolean = self > 0
}
