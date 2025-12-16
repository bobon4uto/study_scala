// Decode a run-length encoded list.
 object Main {


///
// P07 cameo

def tolist(e:Any):List[?] = 
  e match {
    case el: List[?] => el
    case nel: Char => List(nel)
  }
def tolistrec(e:Any):List[?] = 
  e match {
    case el: List[?] => flatten(el)
    case nel: Char => List(nel)
  }

def flatten(l:List[?]):List[?] = 
 tolist( l.reduce(tolistrec(_).toList ::: tolistrec(_).toList) )
//
///




def unroll(twop:(Int,Char)) : List[Char] = {
for {i <- 0 to twop(0)-1} yield { twop(1) }
}.toList
//WHY ranges are like that??
//
//
def decode(l:List[(Int,Char)]):List[?] = flatten({
for {twop <- l} yield { unroll(twop) }

})

@main def main() = 
{println(
  """
  decode(List((4, 'a), (1, 'b), (2, 'c), (2, 'a), (1, 'd), (4, 'e)))
  """)
println(
  decode(List((4, 'a'), (1, 'b'), (2, 'c'), (2, 'a'), (1, 'd'), (4, 'e')))
  )}
}
