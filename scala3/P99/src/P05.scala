//Reverse a list

def reverse(l:List[Int])  = 
{for i <- 0 to l.size-1
  yield l(l.size -1 - i)}.toList



println(
  """
  reverse(List(1, 1, 2, 3, 5, 8))
  """)
println(
  reverse(List(1, 1, 2, 3, 5, 8))
  )

