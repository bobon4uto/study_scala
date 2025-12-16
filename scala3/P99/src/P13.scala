// Run-length encoding of a list (direct solution). 
// Can't use already written code.

object Main {
  


  
  def encodeDirect(l:List[Char]):List[(Int, Char)] = { var oldc = l(0); var oldi = 0;
    for { 
      (c, i) <- {l :+ '\u0000'}.zipWithIndex 
      if c!=oldc
    } yield {val lastoldc=oldc; oldc=c; val lastoldi=oldi; oldi=i; (i-lastoldi,lastoldc)  }
  } 

  @main def main() = {
    println("""
      encodeDirect(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
      """)
    println(
      encodeDirect(List('a', 'a', 'a', 'a', 'b', 'c', 'c', 'a', 'a', 'd', 'e', 'e', 'e', 'e'))
      )
  }


}
