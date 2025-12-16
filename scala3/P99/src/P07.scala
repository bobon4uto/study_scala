// Flatten a nested list structure.
//

def tolist(e:Any):List[?] = 
  e match {
    case el: List[?] => el
    case nel: Any => List(nel)
  }

def flatten(l:List[?])  = 
  l.reduce(tolist(_):::tolist(_))


println(
  """
  flatten(List(List(1, 1), 2, List(3, List(5, 8))))
  """)
println(
  flatten(List(List(1, 1), 2, List(3, List(5, 8))))
  )

