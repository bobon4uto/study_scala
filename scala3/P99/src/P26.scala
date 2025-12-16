//   Generate the combinations of KK distinct objects chosen from the NN elements of a list
import scala.util.Random


object Main {



  def removeAt(n:Int, l:List[Char]):List[Char] = {
      l.slice(0,n) :::l.slice(n+1,l.size)
  } 

  def syphonRandRec(num:Int,lin:List[Char]):List[List[Char]] = {
 
for {choice <- 0 to {lin.size -1} } yield {
    if (num > 1)
    {
      val i = choice
      val c = lin(i)
      val nlin = removeAt(i,lin)
      {for {ret <- syphonRandRec(num-1, nlin) } yield {ret :+ c}}
    } 
    else {
      val i = choice
      val c = lin(i)
      List(List(c))
      
    }
}
  }.toList.reduce(_:::_)



  def combinations(n:Int, l:List[Char]):List[List[Char]] = {
    syphonRandRec(n, l);
  }
  @main def main() = {
    println("""
       combinations(3, List('a, 'b, 'c, 'd, 'e, 'f))
      """)
    println(
       combinations(3, List('a', 'b', 'c','d','e','f'))
      )
  }


}
