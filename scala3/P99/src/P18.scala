// Extract a slice from a list.

object Main {
  //i feel like im cheating...
  def slice(start:Int,end:Int, l:List[Char]):List[Char] = {
    l.slice(start,end)
  } 

  @main def main() = {
    println("""
      slice(3, 7, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k))
      """)
    println(
      slice(3, 7, List('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k'))
      )
  }


}
