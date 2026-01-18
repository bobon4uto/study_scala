//   Group the elements of a set into disjoint subsets
//
//
// We have 3 projects and 9 ppl
// groups must be 2 3 4
// example solution is 3 3 3
// first idea is to just get all all all solutios and filter them to get only ones we need.
// then generalization to x y z instead of 2 3 4
// it slould be aeasy actually
//
//
//
//
//List[(List[String], List[String])] (1 2 3, )
//List[(List[String], List[String])] (2 3, 1)             (1 3, 2)
//List[(List[String], List[String])] (2, 1 3) (3, 1 2)    (1, 2 3) (3, 2 1)
//
//
import scala.util.Random


object MainP {

  def removeAt(n:Int, l:List[String]):List[String] = {
      l.slice(0,n) :::l.slice(n+1,l.size)
  }
  def rem1(l:List[(List[String], List[List[String]])], listn:Int ):List[(List[String], List[List[String]])] = {
      for { subli <- 0 to l.size-1} yield {
        for { index <- 0 to l(subli)(0).size-1} yield { val popped = l(subli)(0)(index)
          val newl = removeAt(index, l(subli)(0))
          val itsnotoldsitsoldss = l(subli)(1)
          //println("!!!!!")
          //println(itsnotoldsitsoldss)
          //println("!!!!!")
            val a:List[String] = List()
          val olds = if (itsnotoldsitsoldss.size <= listn) { itsnotoldsitsoldss :+ a :+ a :+a } else {itsnotoldsitsoldss}
          //println("?!!!!!")
          //println(olds)
          //println("?!!!!!")
          val news = olds.updated(listn,olds(listn):+ popped)
          (newl, news)
        }
      }.toList
    }.toList.reduce(_:::_)
  def remN(l:List[(List[String], List[List[String]])], n:Int,listn:Int ):List[(List[String], List[List[String]])] = {
    if (n>1) {
      remN(rem1(l,listn), n-1, listn)
    } else {
      rem1(l,listn)
    }
  }
  def group_rec(opt:List[Int],lin:List[String]) = {
    //for { i <- opt } yield {
      val a:List[List [String]] = List()
        val iter1 = remN(List( (lin,a) ), opt(0), 0 )
       // val curated1 = for (pos <- iter1) yield { (pos(0),a) }
        val iter2 = remN(iter1, opt(1), 1 )
       // val curated2 = for (pos <- iter2) yield { (pos(0),a) }
        val iter3 = remN(iter2, opt(2), 2 )
        //iter3
       for (pos <- iter3) yield { pos(1) }
    //}
  }
  def group(opt:List[Int],lin:List[String]) = {
    group_rec(opt, lin)
  }
  @main def main() = {
    println(group(List(1, 2, 3), List("A", "B", "C", "D", "E", "F")))
  }



}
