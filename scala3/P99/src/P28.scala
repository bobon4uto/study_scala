//Sorting a list of lists according to length of sublists. 


object MainP28 {
  def lsort(l:List[List[Char]]):List[List[Char]] = {
    l.sortWith((e1,e2) => e1.size < e2.size) // c++ ahh sh
  }
  def lsortFreq(l:List[List[Char]]):List[List[Char]] = {
    val maxi = l.sortWith((e1,e2) => e1.size > e2.size)(0).size
    var sizes :List[Int] = List.fill(maxi+1)(0)
    for {le <- l} { sizes =sizes.updated(le.size, sizes(le.size)+1) }
    l.sortWith((e1,e2) => sizes(e1.size) < sizes(e2.size))
  }
  @main def main() = {
    println(
       lsort(List(List('a', 'b', 'c'), List('d', 'e'), List('f', 'g', 'h'), List('d', 'e'), List('i', 'j', 'k', 'l'), List('m', 'n'), List('o')))
      )
    println(List())
    println(
       lsortFreq(List(List('a', 'b', 'c'), List('d', 'e'), List('f', 'g', 'h'), List('d', 'e'), List('i', 'j', 'k', 'l'), List('m', 'n'), List('o')))
      )
  }


}
