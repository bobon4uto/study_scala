//  Insert an element at a given position into a list.

object Main {
  //i still feel like im cheating...
  def insertAt(e:Char, n:Int,l:List[Char]):List[Char] = {
  { l.slice(0,n) :+ e} ::: l.slice(n,l.size)
  } 

  @main def main() = {
    println("""
      insertAt('new, 1, List('a, 'b, 'c, 'd))
      """)
    println(
      insertAt('n', 1, List('a', 'b', 'c', 'd'))
      )
  }


}
