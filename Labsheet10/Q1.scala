object Q1 extends App {
  case class Rational(numerator: Int, denominator: Int) {
    require(denominator != 0, "Denominator cannot be zero")

    private val g = gcd(numerator, denominator)
    private val num: Int = numerator / g
    private val denom: Int = denominator / g

    
    val normalizedNum: Int = if (denom < 0) -num else num
    val normalizedDenom: Int = if (denom < 0) -denom else denom

    private def gcd(a: Int, b: Int): Int = {
      if (b == 0) a else gcd(b, a % b)
    }

    def neg: Rational = Rational(-normalizedNum, normalizedDenom)

    override def toString: String = s"$normalizedNum/$normalizedDenom"
  }

  
  val x = Rational(3, 4)
  println(x)           


  val negX = x.neg
  println(negX)       
}
