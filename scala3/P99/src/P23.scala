//  Extract a given number of randomly selected elements from a list.
import scala.util.Random


object Main {
  def removeAt(n:Int, l:List[Char]):List[Char] = {
      l.slice(0,n) :::l.slice(n+1,l.size)
  } 
  def removeAtRec(repeat:Int,n:Int, l:List[Char]):List[Char] = {
    if (repeat>0){
      println(n);
      removeAtRec(repeat-1,Random.nextInt(l.size), l.slice(0,n) ::: l.slice(n+1,l.size))}
    else {l}
  } 

  def randomSelect(n:Int, l:List[Char]) : List[Char]= {
  removeAtRec(n, Random.nextInt(l.size), l)

  }.toList

  @main def main() = {
    println("""
      randomSelect(3, List('a, 'b, 'c, 'd, 'f, 'g, 'h))
      """)
    println(
      randomSelect(3, List('a', 'b', 'c', 'd', 'f', 'g', 'h'))
      )
  }


}
