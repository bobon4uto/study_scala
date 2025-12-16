//  Create a list containing all integers within a given range. 

object Main {
  //i still feel like im cheating...
  def range(start:Int, end:Int) : List[Int]= {
    for i <- start to end yield i
  }.toList

  @main def main() = {
    println("""
      range(4, 9)
      """)
    println(
      range(4, 9)
      )
  }


}
