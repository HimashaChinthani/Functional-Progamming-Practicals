object CalculateSquareNumbers {
  def calculateSquare(numbers: List[Int]): List[Int] = {
    numbers.map(x => x * x)
  }

  def main(args: Array[String]): Unit = {
    if (args.isEmpty) {
      println("Please provide a list of integers as input.")
    } else {
      // Convert command line arguments to a list of integers
      val input = args.toList.map(_.toInt)
      val output = calculateSquare(input)
      println(s"Input: ${input.mkString(", ")}")
      println(s"Output: ${output.mkString(", ")}")
    }
  }
}
