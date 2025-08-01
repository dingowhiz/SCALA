object Main {
  def main(args: Array[String]): Unit = {
    hello()
  }

  def hello(): Unit = {
    println("Hello world!")
    println(msg)
  }

  def msg = "I was compiled by Scala 3. :)"
}