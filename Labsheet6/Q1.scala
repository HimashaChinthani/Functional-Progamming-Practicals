object  inventorysystem  {
    var inventory1: Map[Int, (String, Int, Double)] = Map(
        1 -> ("Laptop", 5, 1500.0),
        2 -> ("Mouse", 15, 25.0),
        3 -> ("Keyboard", 10, 75.0)
    )

    var inventory2: Map[Int, (String, Int, Double)] = Map(
        2 -> ("Mouse", 10, 25.0),
        3 -> ("Keyboard", 5, 80.0),
        4 -> ("Monitor", 8, 200.0)
    )

    // I. Retrieve Products
    def retrieveProducts(inventory: Map[Int, (String, Int, Double)]): Unit = {
        println(s"\n-------------=====[INVENTORY]=====--------------")
        println("[ID]\t[Product]\t[Quantity]\t[Price]")
        for ((id, (product, quantity, price)) <- inventory) {
            println(f"$id%2d\t$product%10s\t$quantity%8d\t$$${price}%.2f")
        }
    }

    // II. Calculate Total Value of Products
    def calculateTotalValue(inventory: Map[Int, (String, Int, Double)]): Double = {
        inventory.values.map { case (_, quantity, price) => quantity * price }.sum
    }

    // III. Check If Inventory is Empty
    def isInventoryEmpty(inventory: Map[Int, (String, Int, Double)]): Boolean = {
        inventory.isEmpty
    }

    // IV. Merge Two Inventories
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

    // V. Check if a Product with Specific ID Exists
    def checkProductExists(specificID: Int, inventory: Map[Int, (String, Int, Double)]): Boolean = {
        inventory.contains(specificID)
    }

    def main(args: Array[String]): Unit = {
        // Retrieve and display products from both inventories
        println("Inventory 1:")
        retrieveProducts(inventory1)

        println("\nInventory 2:")
        retrieveProducts(inventory2)

        // Calculate and display the total value of Inventory 1
        println(f"\nTotal value of Inventory 1: $$${calculateTotalValue(inventory1)}%.2f")

        // Check if Inventory 1 is empty and display the result
        println(s"Is Inventory 1 empty? ${isInventoryEmpty(inventory1)}")

        // Merge inventories and display the merged inventory
        val mergedInventory = mergeInventories(inventory1, inventory2)
        println("\nMerged Inventory:")
        retrieveProducts(mergedInventory)

        // Check if a specific product (ID 2) exists in Inventory 1
        val productIdToCheck = 2
        println(s"\nIs product with ID $productIdToCheck in Inventory 1? ${checkProductExists(productIdToCheck, inventory1)}")
    }
}


