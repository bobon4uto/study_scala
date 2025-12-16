//Find the last but one element of a list. 
//scala> penultimate(List(1, 1, 2, 3, 5, 8))
//res0: Int = 5
def penultimate(l:List[Int]):Int  = {l(l.size - 2)}
println("penultimate(List(1, 1, 2, 3, 5, 8))")
println(penultimate(List(1, 1, 2, 3, 5, 8)))
