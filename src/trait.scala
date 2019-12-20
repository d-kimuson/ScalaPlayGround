object PlayGround {
  def main(args: Array[String]): Unit = {
    val e1 = new Employee(name="Taro")
    e1.display()
  }
}

class Employee(val name: String) extends AnyRef with Namable

trait Namable {
  val name: String
  def display(): Unit = println(name)
}
