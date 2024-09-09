class Account(val accountNumber: Int, val owner: String, private var balance: Double) {

 
  def deposit(amount: Double): Unit = {
    if (amount > 0) {
      balance += amount
      println(s"Deposit successful. New balance: $$${balance}")
    } else {
      println("Invalid deposit amount.")
    }
  }

 
  def withdraw(amount: Double): Unit = {
    if (amount > 0 && amount <= balance) {
      balance -= amount
      println(s"Withdrawal successful. New balance: $$${balance}")
    } else if (amount > balance) {
      println("Insufficient funds for withdrawal.")
    } else {
      println("Invalid withdrawal amount.")
    }
  }

  
  def transfer(amount: Double, toAccount: Account): Unit = {
    if (amount > 0 && amount <= balance) {
      balance -= amount
      toAccount.deposit(amount)
      println(s"Transfer successful. New balance: $$${balance}")
    } else if (amount > balance) {
      println("Insufficient funds to transfer.")
    } else {
      println("Invalid transfer amount.")
    }
  }


  def displayInfo(): Unit = {
    println(s"Account Number: $accountNumber\nOwner: $owner\nBalance: $$${balance}")
  }

 
  def getBalance: Double = balance
}

object BankApp {
  def main(args: Array[String]): Unit = {

    val account1 = new Account(1001, "John Doe", 500.0)
    val account2 = new Account(1002, "Jane Smith", 300.0)

   
    account1.displayInfo()
    account2.displayInfo()


    account1.deposit(200.0)

   
    account1.withdraw(150.0)

   
    account1.transfer(100.0, account2)

    println("\nFinal account balances:")
    account1.displayInfo()
    account2.displayInfo()
  }
}
