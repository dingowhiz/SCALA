case class Point (val x: Int, val y: Int) {
  def add(that: Point): Point = new Point(this.x + that.x, this.y + that.y)
  //* override def toString: String = s"($x, $y)"
}

object Main extends App {
  println("Hello, World!")

  val p1 = new Point(1, 2)
  val p2 = new Point(3, 4)
  val p3 = p1.add(p2)
  println("p3 = " + p3)
}
