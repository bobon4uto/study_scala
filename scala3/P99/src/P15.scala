// Duplicate the elements of a list a given number of times.

object Main {
  // honestly recursive functions feel a bit better, but what am I writing? 
  // LISP???
  def listN(n:Int,c:Char):List[Char] = { if (n > 1) { listN(n-1,c) :+ c } else {List(c)}   }
  def duplicateN(n:Int, l:List[Char]):List[Char] = {
    l.flatMap(c => listN(n,c))
  } 

  @main def main() = {
    println("""
      duplicateN(3, List('a, 'b, 'c, 'c, 'd))
      """)
    println(
      duplicateN(3, List('a', 'b', 'c', 'c', 'd'))
      )
  }


}
