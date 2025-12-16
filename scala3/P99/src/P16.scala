// Drop every NNth element from a list.

object Main {
  def drop(n:Int, l:List[Char]):List[Char] = {
    for { (c,i) <- l.zipWithIndex 
    if i%3!=2} yield c
  } 

  @main def main() = {
    println("""
      drop(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k))
      """)
    println(
      drop(3, List('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k'))
      )
  }


}
