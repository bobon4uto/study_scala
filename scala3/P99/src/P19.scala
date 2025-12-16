// Rotate a list NN places to the left

object Main {
  //i still feel like im cheating...
  def rotate(n:Int, l:List[Char]):List[Char] = {
    if (n>0) {l.slice(n,l.size) :::  l.slice(0,n) }
  else{l.slice(l.size+n,l.size) :::  l.slice(0,l.size+n) }
  } 

  @main def main() = {
    println("""
      rotate(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k))
      rotate(-2, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k))
      """)
    println(
      rotate(3, List('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k'))
    )
    println(
      rotate(-2, List('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k'))
      )
  }


}
