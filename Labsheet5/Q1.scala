import scala.io.StdIn.readLine

object InventoryManagement {
  var products: List[String] = List[String]()

  def getProductList(): Unit = {
    var input = ""
    while (input != "done") {
      input = readLine("Enter product name (or type 'done' to finish): ")
      if (input != "done") {
        products = products :+ input
      }
    }
  }

  def printProductList(): Unit = {
    println("Product List:")
    products.zipWithIndex.foreach { case (product, index) =>
      println(s"${index + 1}. $product")
    }
  }

  def getTotalProducts(): Unit = {
    println(s"Total number of products: ${products.size}")
  }

  def main(args: Array[String]): Unit = {
    getProductList()
    printProductList()
    getTotalProducts()
  }
}
