
import scala.io.StdIn

object Q1 {

def getInterestRate: Double => Double = depositAmount => {
    depositAmount match {
      case amount if amount <= 20000 => 0.02
      case amount if amount <= 200000 => 0.04
      case amount if amount <= 2000000 => 0.035
      case _ => 0.065
    }
  }
 def calculateInterest(depositAmount: Double): Double = {
    val rate = getInterestRate(depositAmount)
    depositAmount * rate
  }

def main(args: Array[String]): Unit = {
    println("Enter the deposit amount:")
    val depositAmount = StdIn.readDouble()
    val interest = calculateInterest(depositAmount)
    println(f"Deposit Amount: Rs. $depositAmount%.2f, Interest Earned: Rs. $interest%.2f")
  }
}
