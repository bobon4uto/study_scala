// Modified run-length encoding.
 object Main {
//its convinient that we can use previous task
def pack(l:List[Char]):List[List[Char]] = {var oldc = l(0); var oldi = 0
 for { (c, i) <- {l:+'\u0000'}.zipWithIndex
 if c!=oldc }
 yield {oldc=c;val uoldi=oldi; oldi=i;  l.slice(uoldi,i)}} 
def _internal_encode(l:List[List[Char]]):List[(Int ,Char)] = {
for {
lc <- l 
}
yield { (lc.size, lc(0))  }
}
def encode(l:List[Char]):List[(Int,Char)] = {
  _internal_encode(pack(l))
}
//                                         i didnt know about tuple lol 
//def encodeModified(l:List[Char]):List[Char|Int | List[Int | Char]] = {
def encodeModified(l:List[Char]):List[Char|Int | (Int, Char)] = {
  for {lc <- encode(l)} yield {if (lc(0)==1) {lc(1)} else {lc}  } 
}

@main def main() = 
{println(
  """
  encodeModified(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
  """)
println(
  encodeModified(List('a', 'a', 'a', 'a', 'b', 'c', 'c', 'a', 'a', 'd', 'e', 'e', 'e', 'e'))
  )}
}
