//Pack consecutive duplicates of list elements into sublists.
 object Main {
def pack(l:List[Char]):List[List[Char]] = {var oldc = l(0); var oldi = 0
 for { (c, i) <- {l:+'\u0000'}.zipWithIndex
 if c!=oldc }
 yield {oldc=c;val uoldi=oldi; oldi=i;  l.slice(uoldi,i)}} 

@main def main() = 
{println(
  """
   pack(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
  """)
println(
   pack(List('a', 'a', 'a', 'a', 'b', 'c', 'c', 'a', 'a', 'd', 'e', 'e', 'e', 'e'))
  )}
}
