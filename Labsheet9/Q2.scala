object Q2{

 
  val classifyNumber: Int => String = num => num match {
    case n if n <= 0 => "Negative/Zero is input"
    case n if n % 2 == 0 => "Even number is given"
    case _ => "Odd number is given"
  }

  def main(args: Array[String]): Unit = {
    if (args.length != 1) {
      println("Please provide exactly one integer argument.")
      sys.exit(1)
    }

    try {
      val input = args(0).toInt
      println(classifyNumber(input))
    } catch {
      case _: NumberFormatException =>
        println("Please provide a valid integer.")
    }
  }
}
