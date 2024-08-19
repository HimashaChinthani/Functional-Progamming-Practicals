object Q3 {
def toUpper(input: String): String = input.toUpperCase
def toLower(input: String): String = input.toLowerCase
def formatNames(name: String, formatter: String => String): String = formatter(name)
def main(args: Array[String]): Unit = {
val names = List("Benny", "Niroshan", "Saman", "Kumara")
val formattedNames = names.map {
      case "Benny"   => formatNames("Benny", toUpper)
      case "Niroshan" => formatNames("Niroshan", (s: String) => s.capitalize)
      case "Saman"   => formatNames("Saman", toLower)
      case "Kumara"  => formatNames("Kumara", (s: String) => s.init + s.last.toUpper)
    }
 formattedNames.foreach(println)
  }
}
