// Flatten a nested list structure.
//
 object Main {
def tolist(e:Any):List[?] = 
  e match {
    case el: List[?] => el
    case nel: Int => List(nel)
  }
def tolistrec(e:Any):List[?] = 
  e match {
    case el: List[?] => flatten(el)
    case nel: Int => List(nel)
  }

def flatten(l:List[?]):List[?] = 
 tolist( l.reduce(tolistrec(_).toList ::: tolistrec(_).toList) )
// so why reduce returns Any in this case? Im passing List ::: List
// which is always a List, or am I wrong, and it can return something else?
@main def main() = 
{println(
  """
  flatten(List(List(1, 1), 2, List(3, List(5, 8))))
  """)
println(
  flatten(List(List(1, 1), 2, List(3, List(5, 8))))
  //flatten(List(1,List(1,List(1))))
  )}
}
