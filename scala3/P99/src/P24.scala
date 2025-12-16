//   Lotto: Draw NN different random numbers from the set 1..M1..M
import scala.util.Random


object Main {
  def removeAt(n:Int, l:List[Int]):List[Int] = {
      l.slice(0,n) :::l.slice(n+1,l.size)
  } 
  def removeAtRec(repeat:Int,n:Int, l:List[Int]):List[Int] = {
    if (repeat>0){
      removeAtRec(repeat-1,Random.nextInt(l.size-1), l.slice(0,n) ::: l.slice(n+1,l.size))}
    else {l}
  } 

  def lotto(n:Int, lsize:Int) : List[Int]= {
    val l = {1 to lsize}.toList
  removeAtRec(l.size - n, Random.nextInt(l.size), l)
// now thats cheating for sure!!
  }.toList
  @main def main() = {
    println("""
      lotto(6, 49)
      """)
    println(
      lotto(6, 49)
      )
  }


}
