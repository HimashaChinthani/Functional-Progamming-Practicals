object Q2 extends App {
  case class Rational(numerator: Int, denominator: Int) {
    require(denominator != 0, "Denominator cannot be zero")

   
    private val g = gcd(numerator, denominator)
    private val num: Int = numerator / g
    private val denom: Int = denominator / g

    
    private val normalizedNum: Int = if (denom < 0) -num else num
    private val normalizedDenom: Int = if (denom < 0) -denom else denom

    private def gcd(a: Int, b: Int): Int = {
      if (b == 0) a else gcd(b, a % b)
    }

   
    def neg: Rational = Rational(-normalizedNum, normalizedDenom)

    def sub(that: Rational): Rational = {
      val newNumerator = normalizedNum * that.normalizedDenom - normalizedDenom * that.normalizedNum
      val newDenominator = normalizedDenom * that.normalizedDenom
      Rational(newNumerator, newDenominator)
    }

    override def toString: String = s"$normalizedNum/$normalizedDenom"
  }

  
  val x = Rational(3, 5)
  val y = Rational(7, 8)
  val z = Rational(3, 8)


  val intermediateResult = y.sub(z)
  val result = x.sub(intermediateResult)


  println(s"x = $x")                 
  println(s"y = $y")                  
  println(s"z = $z")                  
  println(s"y - z = $intermediateResult") 
  println(s"x - (y - z) = $result")   
}
