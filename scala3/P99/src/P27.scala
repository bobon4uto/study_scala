//   Group the elements of a set into disjoint subsets
//
//
// We have 3 projects and 9 ppl
// groups must be 2 3 4
// example solution is 3 3 3
// first idea is to just get all all all solutios and filter them to get only ones we need.
// then generalization to x y z instead of 2 3 4
// it slould be aeasy actually
import scala.util.Random


object MainP {

  def removeAt(n:Int, l:List[Any]):List[Any] = {
      l.slice(0,n) :::l.slice(n+1,l.size)
  }
  def rem1(l:List[Any]):List[(List[Any],Any)] = {
    for {i <- 0 to l.size-1} yield { ( removeAt(i, l), l(i) ) }
  }.toList
  def remN(l:(List[Any], List[Any]) , n : Int):List[(List[Any], List[Any])] = {
    println(l)
    if (n>1) {
      for {rem <- rem1(l(0))} yield { remN(rem,n-1)}
    } else {
      for {rem <- rem1(l(0))} yield { rem }
    }
  }.toList
  def group_rec(opt:List[Int],lin:List[String]) = {
    //for { i <- opt } yield {
      remN((lin,List()), 3)
    //}
  }
  def group(opt:List[Int],lin:List[String]) = {
    group_rec(opt, lin)
  }
  @main def main() = {
    println("""
       group(List(2, 2, 5), List("Aldo", "Beat", "Carla", "David", "Evi", "Flip", "Gary", "Hugo", "Ida"))
      """
      )
    println(
       group(List(2, 3, 4), List("A", "B", "C", "D"))
         //"E", "F", "G", "H", "I"))
      )
  }


}
