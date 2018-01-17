package edu.knoldus

class ListOperations {

  def length[A](list: List[A]): Int = list.foldRight(0)((_, length) => length + 1)

  def concatenateList[A](list1: List[A], list2: List[A]): List[A] = {
    if (list1.isEmpty && list2.isEmpty) {
      throw new Exception("both lists are empty")
    }
    else {
      list2 match {
        case Nil => list1
        case firstElement :: restList => concatenateList(list1 :+ firstElement, restList)
      }
    }
  }

  def hasSubSequence[A](list: List[A], subList: List[A]): Boolean = {
    def contains[T](list: List[T], subList: List[T]): Boolean = {
      (list, subList) match {
        case (_, Nil) => true
        case ((firstElement1 :: restList1), (firstElement2 :: restList2)) if firstElement1 == firstElement2 =>
          contains(restList1, restList2)
        case _ => false
      }
    }

    if (list.isEmpty) {
      throw new Exception("list is empty")
    }
    else {
      list match {
        case Nil => false
        case _ if contains(list, subList) => true
        case _ :: restList => hasSubSequence(restList, subList)
      }
    }
  }

  def splitList[A](list: List[A], function: A => Boolean): (List[A], List[A]) = {
    def splitListRecursive[T](list: List[A], splitList1: List[A], splitList2: List[A]): (List[A], List[A]) = {
      list match {
        case Nil => (splitList1, splitList2)
        case firstElement :: restList if function(firstElement) => splitListRecursive(restList, splitList1 :+ firstElement, splitList2)
        case firstElement :: restList => splitListRecursive(restList, splitList1, splitList2 :+ firstElement)
      }
    }

    if (list.isEmpty) {
      throw new Exception("list is empty")
    }
    else {
      splitListRecursive(list, Nil, Nil)
    }
  }

}
