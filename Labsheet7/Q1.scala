object EvenNumberFilter {
  def filterEvenNumbers(numbers: List[Int]): List[Int] = {
    numbers.filter(num => num % 2 == 0)
  }

  def main(args: Array[String]): Unit = {
    if (args.isEmpty) {
      println("Please provide a list of integers as input.")
    } else {
      // Convert command line arguments to a list of integers
      val input = args.toList.map(_.toInt)
      val output = filterEvenNumbers(input)
      println(s"Input: ${input.mkString(", ")}")
      println(s"Output: ${output.mkString(", ")}")  // Output: List(2, 4, 6, 8, 10)
    }
  }
}
