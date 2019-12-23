object PlayGround {
  def main(args: Array[String]): Unit = {
    // 既存クラスを継承した無名クラスのインスタンスをその場で生成
    new Thread {
      override def run(): Unit = {
        for(i <- 1 to 10) println(i)
      }
    }.start()
  }
}
