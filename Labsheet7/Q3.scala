object filterPrimeNumbers {
  // Function to check if a number is prime
  def isPrime(num: Int): Boolean = {
    if (num <= 1) false
    else if (num == 2) true
    else !(2 until num).exists(n => num % n == 0)
  }

  
  def filterPrime(numbers: List[Int]): List[Int] = {
    numbers.filter(isPrime)
  }

  def main(args: Array[String]): Unit = {
    if (args.isEmpty) {
      println("Please provide a list of integers as input.")
    } else {
     
      val input = args.toList.map(_.toInt)
      val output = filterPrime(input)
      println(s"Input: ${input.mkString(", ")}")
      println(s"Output: ${output.mkString(", ")}")
    }
  }
}
