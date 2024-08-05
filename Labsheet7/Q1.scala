object EvenNumberFilter {
  def filterEvenNumbers(numbers: List[Int]): List[Int] = {
    numbers.filter(num => num % 2 == 0)
  }

  def main(args: Array[String]): Unit = {
    if (args.isEmpty) {
      println("Please provide a list of integers as input.")
    } else {
     
      val input = args.toList.map(_.toInt)
      val output = filterEvenNumbers(input)
      println(s"Input: ${input.mkString(", ")}")
      println(s"Output: ${output.mkString(", ")}")  
    }
  }
}
