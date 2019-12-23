package samplepackage

// class, obhect, traitが所属できる

case class Point(x: Int, y: Int) {}

// 関数とかをパッケージ化したい => パッケージオブジェクトを使う

package object samplePackageObject {
  def helloWorld() = {
    println("Hello World")
  }
}
