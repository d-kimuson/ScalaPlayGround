object PlayGround {
  def main(args: Array[String]): Unit = {
    val e1 = new Employee("Taro")
    e1.display()
  }
}

// トレイトを複数合成(mix-in)してクラスを作る

class Employee(val name: String) extends AnyRef with Namable

trait Namable {
  val name: String

  def display(): Unit = println(name)
}
