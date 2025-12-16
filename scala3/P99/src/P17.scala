// Split a list into two parts.

object Main {
  def halflife1(n:Int, l:List[Char]):List[Char] = {l.slice(0,n)}
  def halflife2(n:Int, l:List[Char]):List[Char] = {l.slice(n,l.size)}
  def split(n:Int, l:List[Char]):(List[Char],List[Char]) = {
    (halflife1(n,l),halflife2(n,l))
  } 

  @main def main() = {
    println("""
      split(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k))
      """)
    println(
      split(3, List('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k'))
      )
  }


}
