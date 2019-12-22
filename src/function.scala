object PlayGround {
  def main(args: Array[String]): Unit = {
    val f1 = sampleMethod _
    val f2 = () => println("called f2")
    val f3 = new Function0[Unit] {
      def apply(): Unit = {
        println("called f3")
      }
    }

    f1()
    f2()
    f3()
  }

  def sampleMethod(): Unit = {
    println("called f1")
  }
}
