object InventorySystem {
 
  val inventory1: Map[Int, (String, Int, Double)] = Map(
    101 -> ("Mouse", 12, 25.0),
    102 -> ("Keyboard", 5, 35.0),
    103 -> ("Monitor", 20, 75.0)
  )

  val inventory2: Map[Int, (String, Int, Double)] = Map(
    102 -> ("Keyboard", 8, 30.0), 
    104 -> ("Mouse", 20, 45.0)    
  )

  // I. Retrieve All Product Names from inventory1
  def getProductNames(inventory: Map[Int, (String, Int, Double)]): List[String] = {
    inventory.values.map(_._1).toList
  }

  // II. Calculate the Total Value of All Products in inventory1
  def calculateTotalValue(inventory: Map[Int, (String, Int, Double)]): Double = {
    inventory.values.map { case (_, quantity, price) => quantity * price }.sum
  }

  // III. Check If inventory1 is Empty
  def isInventoryEmpty(inventory: Map[Int, (String, Int, Double)]): Boolean = {
    inventory.isEmpty
  }

  // IV. Merge inventory1 and inventory2, Updating Quantities and Retaining the Highest Price
  def mergeInventories(
    inventory1: Map[Int, (String, Int, Double)],
    inventory2: Map[Int, (String, Int, Double)]
  ): Map[Int, (String, Int, Double)] = {
    val mergedInventory = scala.collection.mutable.Map[Int, (String, Int, Double)]()

    // Add all items from inventory1
    mergedInventory ++= inventory1

    // Update or add items from inventory2
    for ((id, (product, quantity, price)) <- inventory2) {
      mergedInventory.get(id) match {
        case Some((existingProduct, existingQuantity, existingPrice)) =>
          // Update quantity and keep the highest price
          mergedInventory(id) = (existingProduct, existingQuantity + quantity, math.max(existingPrice, price))
        case None =>
          // Add new item
          mergedInventory(id) = (product, quantity, price)
      }
    }

    mergedInventory.toMap
  }

  // V. Check if a Product with Specific ID (e.g., 102) Exists and Print Its Details
  def checkAndPrintProductDetails(inventory: Map[Int, (String, Int, Double)], productId: Int): Unit = {
    inventory.get(productId) match {
      case Some((name, quantity, price)) =>
        println(s"Product ID: $productId, Name: $name, Quantity: $quantity, Price: $price")
      case None =>
        println(s"Product with ID $productId does not exist.")
    }
  }

  def main(args: Array[String]): Unit = {
    // I. Retrieve and print all product names from inventory1
    val productNames = getProductNames(inventory1)
    println("Product Names in Inventory1: " + productNames.mkString(", "))

    // II. Calculate and print the total value of all products in inventory1
    val totalValue = calculateTotalValue(inventory1)
    println(f"Total Value of Inventory1: $$${totalValue}%.2f")

    // III. Check if inventory1 is empty and print the result
    val isEmpty = isInventoryEmpty(inventory1)
    println(s"Is Inventory1 Empty? $isEmpty")

    // IV. Merge inventory1 and inventory2 and print the merged inventory
    val mergedInventory = mergeInventories(inventory1, inventory2)
    println("\nMerged Inventory:")
    retrieveProducts(mergedInventory)

    // V. Check if a product with ID 102 exists in inventory1 and print its details
    val productIdToCheck = 102
    checkAndPrintProductDetails(inventory1, productIdToCheck)
  }

  // Utility method to retrieve and print products
  def retrieveProducts(inventory: Map[Int, (String, Int, Double)]): Unit = {
    println(s"\n-------------=====[INVENTORY]=====--------------")
    println("[ID]\t[Product]\t[Quantity]\t[Price]")
    for ((id, (product, quantity, price)) <- inventory) {
      println(f"$id%2d\t$product%10s\t$quantity%8d\t$$${price}%.2f")
    }
  }
}



