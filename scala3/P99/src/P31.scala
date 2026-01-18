//wait where did P29 and 30 go...
//
//
package arithmetic {
  class S99Int(val self: Int) {
    import S99Int._
    def isEven:Boolean = self%2==0
    def isOdd:Boolean = self%2!=0
    def isPrime:Boolean = {for {preself <- 2 to self-1} yield { self%preself != 0 }}.forall(identity)
    def isCoprimeTo(i:Int):Boolean = gcd(self,i)==1
    //Euler’s so-called totient function ϕ(m) is defined as the number of positive integers r(1<=r<=m)r(1<=r<=m) that are coprime to mm.
    def totient:Int = {
      var count = 0
      for {i <- 1 to self} { if self.isCoprimeTo(i) then count +=1 }
      count
    }
    def primeFactors:List[Int] = {
      var resl:List[Int] = List()
      var mutself:Int = self
      while (!mutself.isPrime) {
        for { i <- 2 to mutself } {
          while (i.isPrime && !mutself.isCoprimeTo(i) ) {
            resl = resl :+ i
            mutself = mutself/i
          }
        }
      }
      resl
    }
    def primeFactorMultiplicity:List[(Int,Int)] = {
      var resl:List[(Int,Int)] = List()
      var tmpl:List[Int] = List()
      for (f <- self.primeFactors) {
        if (tmpl.contains(f)) {
          resl = for (li <- resl) yield { 
            if ( f == li(0) ) {
              (li(0),li(1)+1)
            } else {
              li
            }
          }
        } else {
          resl = resl :+ (f,1)
        }
        tmpl = tmpl :+ f
      }
      resl
    }
    //ϕ(m)=(p1​−1)∗p1m1​−1​∗(p2​−1)∗p2m2​−1​∗(p3​−1)∗p3m3​−1​∗…
    def **(b:Int):Int = {math.pow(self,b).toInt}
    def totient2:Int = {
      var res = 1
      val primes = self.primeFactorMultiplicity
      for {p <- primes} {
        //res = res * (p(0)-1) * math.pow(p(0),p(1)-1).toInt
        //res = res * (p(0)-1) * (p(0)**(p(1)-1))
        res = res * (p(0)-1) * p(0).**(p(1)-1)
        //havent found how to make it take presedence by default
      }
      res
    }
    def goldbach:(Int,Int) = {
      (1,1)
    }

  }

  object S99Int {
    implicit def int2S99Int(i: Int): S99Int = new S99Int(i)
    def max(num1:Int,num2:Int):Int = if num1>num2 then num1 else num2
    def min(num1:Int,num2:Int):Int = if num1<num2 then num1 else num2
    def gcd(num1:Int,num2:Int):Int = {
      val upto = min(num1,num2)
      var lastgcd =0;
      for {i <- 1 to upto} { if (num1%i==0 && num2%i==0) {lastgcd=i} }
      lastgcd
    }
  }
}
import arithmetic.S99Int._
object MainP30 {
  @main def main() = {
    println(7.isPrime)
    println(4.isPrime)
    println(gcd(36,63))
    println(35.isCoprimeTo(64))
    println(10.totient)
    println(315.primeFactors)
    println(315.primeFactorMultiplicity)
    println(10.totient2)
    println(10090.totient2)
    val startTime = System.currentTimeMillis()
    val tot1 = 10090.totient
    val endTime = System.currentTimeMillis()

    val startTime2 = System.currentTimeMillis()
    val tot2 = 10090.totient2
    val endTime2 = System.currentTimeMillis()
    println(endTime-startTime)
    println(endTime2-startTime2)
    // huh, second method is worse, who would've thought
    println(28.goldbach)
  }
}
