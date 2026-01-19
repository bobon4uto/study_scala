object MainP49 {
  def count1(str:String):Int = {
    var count = 0
    for { c <- str } { if c == '1' then count += 1 }
    count
  }
  def givenstrgetnext(str:String):List[String] = {
    if (count1(str)%2 != 0) { List(str :+ '1',str :+ '0' ) }
    else { List(str :+ '0',str :+ '1' ) }
  }
  def next01(l:List[String]):List[String] = {
    for str <- l yield { givenstrgetnext(str) }
  }.reduce(_:::_)
  def grayrec(l:List[String],n:Int):List[String] = {
    if (n>0) { grayrec(next01(l),n-1) } else { l }
  }
  def gray(n:Int):List[String] = {
    grayrec(List("0", "1"),n-1)
  }
  @main def main() = {
    println(gray(3))
  }
}
