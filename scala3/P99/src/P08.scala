//Eliminate consecutive duplicates of list elements. 
 object Main {
def compress(l:List[Char]):List[Char] = {var oldc = '0'
 for { c <- l
 if c!=oldc }
 yield {oldc=c; c}} 
// how do you do it without { and } ????? 
// also, I heard for loops are discouraged...

@main def main() = 
{println(
  """
  compress(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
  """)
println(
  compress(List('a', 'a', 'a', 'a', 'b', 'c', 'c', 'a', 'a', 'd', 'e', 'e', 'e', 'e'))
  )}
}
