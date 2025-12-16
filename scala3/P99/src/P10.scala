// Run-length encoding of a list.
 object Main {
//its convinient that we can use previous task
def pack(l:List[Char]):List[List[Char]] = {var oldc = l(0); var oldi = 0
 for { (c, i) <- {l:+'\u0000'}.zipWithIndex
 if c!=oldc }
 yield {oldc=c;val uoldi=oldi; oldi=i;  l.slice(uoldi,i)}} 
def _internal_encode(l:List[List[Char]]):List[(Int, Char)] = {
for {
lc <- l 
}
yield { (lc.size, lc(0))  }
}
def encode(l:List[Char]):List[(Int, Char)] = {
  _internal_encode(pack(l))
}

@main def main() = 
{println(
  """
  encode(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
  """)
println(
  encode(List('a', 'a', 'a', 'a', 'b', 'c', 'c', 'a', 'a', 'd', 'e', 'e', 'e', 'e'))
  )}
}
