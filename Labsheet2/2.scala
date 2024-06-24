object Q2{
    def main(args:Array[String]):Unit ={
        var a=2 ; 
        var b=3 ; 
        var c=4 ;
        var d=5;
        var k=4.3f;
        var g=6.0f//assume a value for g
        
        println(s"Question 02");
        //a
        println(s"- -b * a + c * d- -= ${(b-1) * a + c * d}");
        b-=1;
        d-=1;
        //b
        printf(s"a++=${(a)}\n");
        a+=1;
        //c
        println(s"-2 * (g - k) + c=${-2*(g-k)+c}");
        //d
        println(s"c = c++= $c");
        c += 1;
        //e
        c +=1;
        println(s"c = ++c * a++=${c*a}");
        a+=1;

    }
}
