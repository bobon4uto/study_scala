// Duplicate the elements of a list.

object Main {
  def duplicate(l:List[Char]):List[Char] = {
    l.flatMap(c => List(c,c))
  } 

  @main def main() = {
    println("""
      duplicate(List('a, 'b, 'c, 'c, 'd))
      """)
    println(
      duplicate(List('a', 'b', 'c', 'c', 'd'))
      )
  }


}
