//   Generate a random permutation of the elements of a list
import scala.util.Random


object Main {



  def removeAt(n:Int, l:List[Char]):List[Char] = {
      l.slice(0,n) :::l.slice(n+1,l.size)
  } 

  def syphonRandRec(lin:List[Char]):List[Char] = {
    if (lin.size > 1)
    {
      val i = Random.nextInt(lin.size)
      val c = lin(i)
      val nlin = removeAt(i,lin)
      syphonRandRec(nlin) :+ c
    } 
    else {
      val i = 0
      val c = lin(i)
      List(c)
    }
  }
  def randomPermute(l:List[Char]):List[Char] = {
    syphonRandRec(l);
  }
  @main def main() = {
    println("""
       randomPermute(List('a, 'b, 'c, 'd, 'e, 'f))
      """)
    println(
       randomPermute(List('a', 'b', 'c', 'd', 'e', 'f'))
      )
  }


}
