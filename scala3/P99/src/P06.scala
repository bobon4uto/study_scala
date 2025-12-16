//Find out whether a list is a palindrome.
def isPalindrome(l:List[Int]):Boolean  = 
 {for i <- 0 to l.size-1
  yield l(l.size -1 - i)==l(i)}.toList.reduce(_ && _) 



println(
  """
 isPalindrome(List(1, 2, 3, 2, 1))
  """)
println(
 isPalindrome(List(1, 2, 3, 2, 1))
  )

