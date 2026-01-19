 //huffman(List(("a", 45), ("b", 13), ("c", 12), ("d", 16), ("e", 9), ("f", 5)))
//res0: List[String, String] = List((a,0), (b,101), (c,100), (d,111), (e,1101), (f,1100))
// bacically encode binary tree in 101 etc
//              ?
//            0   1
//               0 1
// referencing wiki i see that the root is probability of * (any char)
// then left tree and right tree are split ~evenly and are propabilities of [abcd...] [...xyz]
// and every branch bacically narrows it down
// although that doesnt seem to help understand why do we need that...
// actually lets see if we treverse the tree and see that our prop is less than the current , but >= than the left(or right) 
// THEN we get into position of the free
// we construct by always calculating summ of props from below, and when we see that by trying to insers we have high prop but all
// is taken we recalculate it by breaking apart current tree and constructing it again
//
// it was way simpler and i didnt even have to use actual tree, since its encoded in 0101. (and even then we dont need to inspect them)
class HoldList(val prop:Int, val l:List[(String,Int,String)]) {
   override def toString: String = {
    l.toString
  }
}
object MainP50 {
  def merge(ll:HoldList, lr:HoldList) : HoldList = {
    var l = '0'
    var r = '1'
    if ll.prop > lr.prop then {l='1'; r='0'}
    val ll_l = for {el <- ll.l} yield { (el(0),el(1), l +: el(2)) }
    val lr_l = for {el <- lr.l} yield { (el(0),el(1), r +: el(2)) }
    new HoldList (ll.prop+lr.prop, ll_l ::: lr_l)
  }
  def _huffman(l:List[HoldList]):List[HoldList] = {
    if (l.size>1) {
      val sortl = l.sortWith((el1,el2)=>el1.prop<el2.prop)
      val mergedsmall = merge(sortl(0), sortl(1))
      val nosmall = sortl.tail.tail
      val res = mergedsmall +: nosmall
      _huffman(res)
    } else {
      l
    }
  }
  def huffman(l:List[(String,Int)]):List[(String,String)] = {
    val prephuff = for { elh<-l } yield { new HoldList(elh(1), List((elh(0), elh(1), "")) ) }
    val hfmn = _huffman(prephuff)
    val aftphuff = hfmn(0).l
    val ret = for { elh<-aftphuff } yield { (elh(0),elh(2)) }
    ret
  }

  @main def main() = {
    println(huffman(List(("a", 45), ("b", 13), ("c", 12), ("d", 16), ("e", 9), ("f", 5))))
    // It DOES work, the ordering is just off (eg it shows e 1101 before d)
  }
}
