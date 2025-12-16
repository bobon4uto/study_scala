// Remove the KKth element from a list

object Main {
  //i still feel like im cheating...
  def removeAt(n:Int, l:List[Char]):List[Char] = {
      l.slice(0,n) :::l.slice(n+1,l.size)
  } 

  @main def main() = {
    println("""
      removeAt(1, List('a, 'b, 'c, 'd))
      """)
    println(
      removeAt(1, List('a', 'b', 'c', 'd'))
      )
  }


}
