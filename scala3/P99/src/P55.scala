sealed abstract class Tree[+T] {
  def isMirrorOf[V](ot:Tree[V]):Boolean 
}
case class Node[+T](value: T, left: Tree[T], right: Tree[T]) extends Tree[T] {
  override def toString = "T(" + value.toString + " " + left.toString + " " + right.toString + ")"
  def isMirrorOf[V](tree: Tree[V]): Boolean = {
    tree match {
      case t: Node[V] => {
        left.isMirrorOf(t.right) && right.isMirrorOf(t.left)
      }
      case _ => false
    }
  }
  def isSymmetric: Boolean = left.isMirrorOf(right)

}
case object End extends Tree[Nothing] {
  override def toString = "."
  def isMirrorOf[V](tree: Tree[V]): Boolean = tree == End
  def isSymmetric: Boolean = true
}
object Node {
  def apply[T](value: T): Node[T] = Node(value, End, End)
}
object Tree {
  def cBalanced_rec_single[T](n:Int,value:T):Tree[T] = {
    if n > 1 then {
    var ret = Node(value)
    //if n>=2 then { ret=Node(value, cBalanced_rec_single(n-1, value), cBalanced_rec_single(n-2, value))
    //} else { ret=Node(value, cBalanced_rec_single(n-1, value), End) }
    ret = add_safe(n,value)
    ret
    } else {End}
  }
  def add_safe[T](n:Int, value:T):Node[T] = {
    if n>=2 then {
      Node(value, cBalanced_rec_single(n-1, value), cBalanced_rec_single(n-2, value))
    } else {
      Node(value, cBalanced_rec_single(n-1, value), End)
    }
  }
  def get_nodes_from_List[T](value:T, tl_l:List[Tree[T]],tl_r:List[Tree[T]]):List[Node[T]]= {
    for { lres <- tl_l } yield {
      for { rres <- tl_r } yield {
        Node(value,lres,rres)
      }
    }
  }.reduce(_:::_)
  def add_safe_many[T](n:Int, value:T):List[Node[T]] = {
    if n>=2 then {
      List(
        get_nodes_from_List(value, cBalanced_rec(n-1, value), cBalanced_rec(n-2, value)),
        get_nodes_from_List(value, cBalanced_rec(n-2, value), cBalanced_rec(n-1, value))
        ).reduce(_:::_)
    } else {
      List(
        get_nodes_from_List(value, cBalanced_rec(n-1, value), List(End)),
        get_nodes_from_List(value, List(End), cBalanced_rec(n-1, value))
        ).reduce(_:::_)
    }
    //val ret :List[Node[T]] = List()
    //ret
  }

  def cBalanced_rec[T](n:Int,value:T):List[Tree[T]] = {
    if n > 1 then {
    //var ret:List[Tree[T]] = List()
    add_safe_many(n,value)
    } else {List(End)}
  }

  def cBalanced[T](n:Int,value:T):List[Tree[T]] = {
    cBalanced_rec(n,value)
  }
}

object MainP55 {
  @main def main() = {
    println(Node('a',
         Node('b', Node('d'), Node('e')),
         Node('c', End, Node('f', Node('g'), End)))
    )
    //println(Tree.cBalanced(4, "x"))
    println (Node('a', Node('b'), Node('c')).isMirrorOf( Node('a', Node('c'), Node('b')) ))
    println (Node('a', Node('b'), Node('c')).isSymmetric)
  }
}
