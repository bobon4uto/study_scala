package logic {
  class S99Logic(val a: Boolean) {
    import S99Logic._
    infix def and (b:Boolean):Boolean = a&&b
    infix def nand(b:Boolean):Boolean = not(a and b)
    infix def or  (b:Boolean):Boolean = a||b
    infix def nor (b:Boolean):Boolean = not(a or b)
    infix def xor (b:Boolean):Boolean = if a then not(b) else b
    infix def impl(b:Boolean):Boolean = if a&& not(b) then false else true
  }


  object S99Logic {
    implicit def boolean2S99Logic(b:Boolean): S99Logic = new S99Logic(b)
    def not (a:Boolean):Boolean = !a
    def band(a:Boolean, b:Boolean):Boolean = a&&b
    def bnand(a:Boolean, b:Boolean):Boolean = !band(a,b)
    def bor(a:Boolean, b:Boolean):Boolean = a||b
    def bnor(a:Boolean, b:Boolean):Boolean = !bor(a,b)
    def bxor(a:Boolean, b:Boolean):Boolean = if a then !b else b
    def bimpl(a:Boolean, b:Boolean):Boolean = if a&& !b then false else true
    def bequl(f1:(Boolean, Boolean)=>Boolean):List[Boolean] = {
      val a=true
      val b=false
      val ret: List[Boolean]= List() :+ f1(a,a) :+ f1(a,b) :+ f1(b,a) :+ f1(b,b)
      ret
    }
    def table2(f1:(Boolean, Boolean)=>Boolean):Unit = {
      val tabl = bequl(f1)
      println(s"A     B     result")
      println(s"true  true  ${tabl(0)}")
      println(s"true  false ${tabl(1)}")
      println(s"false true  ${tabl(2)}")
      println(s"false false ${tabl(3)}")
    }
    def equ(f1:(Boolean, Boolean)=>Boolean, f2:(Boolean, Boolean)=>Boolean):Boolean = {
      bequl(f1) == bequl(f2)
    }
  }
}
import logic.S99Logic._
object MainP46 {
  @main def main() = {
    table2((a: Boolean, b: Boolean) => band(a, bor(a, b)))
    table2((a: Boolean, b: Boolean) => a and (a or not(b)))
  }
}
