//   Group the elements of a set into disjoint subsets
import scala.util.Random


object Main {


  def removeAt(n:Int, l:List[String]):List[String] = {
      l.slice(0,n) :::l.slice(n+1,l.size)
  } 

  def syphonRandRec(num:Int,lin:List[String]):List[List[String]] = {
 
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



  def combinations(n:Int, l:List[String]):List[List[String]] = {
    syphonRandRec(n, l);
  }
// opt(0) = n
// opt(1) = k_0
// opt(2) = k_max
def group(opt:List[Int], l:List[String]):List[List[List[String]]] = {
for { i <- opt(1) to opt(2) } yield /* my flesh*/ {combinations(i, l)}
}.toList

  @main def main() = {
    println("""
       group(List(2, 2, 5), List("Aldo", "Beat", "Carla", "David", "Evi", "Flip", "Gary", "Hugo", "Ida"))
      """)
    println(
       group(List(2, 2, 5), List("Aldo", "Beat", "Carla", "David", 
         "Evi", "Flip", "Gary", "Hugo", "Ida"))
      )
  }


}
