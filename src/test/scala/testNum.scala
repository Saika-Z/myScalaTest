import scala.annotation.tailrec
import scala.collection.mutable
import scala.collection.mutable.LinkedList
import scala.util.control.Breaks.break

/** *************************************************************************************
 * *
 *
 * Project:
 * ClassName: testNum
 * Description: ${Description}
 * Author: Zhao Wenqing
 * Date:  2024/1/21 12:58
 *
 * ************************************************************************************ */
object testNum {
  def main(args: Array[String]): Unit = {

    /*val arr: Array[Int] = Array(-4, -1, 0, 3, 10)
    val node: TreeNode = TreeNode.mkTree("1,2,3,4,null,6,null,8")
    val i1 = new TreeNode().beforeTraverse(node)
    val i2 = new TreeNode().afterTraverse(node)
    val i3 = new TreeNode().sequenceTraverse(node)
    printf("前序: %s\n", i1.toString)
    printf("后序: %s\n", i2.toString)
    printf("层序: %s\n", i3.toString)*/
    val l1: ListNode = ListNode.createListNode(Array(1,2,3,4))
    /*val l2: ListNode = ListNode.createListNode(Array(1000000, 1000001, 1000002))
    val node: ListNode = mergeInBetween(l1, 3, 4, l2)
    ListNode.printListNode(node)*/
    ListNode.printListNode(l1)
    reorderList(l1)
    ListNode.printListNode(l1)
  }

  def findAllPeople(n: Int, meetings: Array[Array[Int]], firstPerson: Int): List[Int] = {
    @tailrec def conquer(conquerer: Set[Int], rem: List[Set[Int]]): (Set[Int], List[Set[Int]]) = {
      val (next, others) = rem.partition(_.exists(conquerer contains _))
      (next, others) match {
        case (Nil, _) => (conquerer, others)
        case (n, Nil) => (conquerer ++ n.reduce(_ ++ _), others)
        case (n, o) => conquer(conquerer ++ n.reduce(_ ++ _), o)
      }
    }

    (Array(0, firstPerson, 0) :: meetings.toList).map(arr => (arr.take(2).toSet, arr(2)))
      .groupBy(_._2).map { case (k, v) => (k, v.toList) }
      .toList.sortBy(_._1)
      .map(_._2)
      .map(_.map(_._1))
      .foldLeft(Set(0))((conq, others) => conquer(conq, others)._1)
      .toList.sorted
  }

  def intersection(nums1: Array[Int], nums2: Array[Int]): Array[Int] = {
    nums1.distinct.filter(nums2.distinct.contains(_))

  }

  def reorderList(head: ListNode): Unit = {
    var current: ListNode = head
    var reList: ListNode = head
    val list = scala.collection.mutable.ListBuffer.empty[Int]
    val arr = scala.collection.mutable.ListBuffer.empty[Int]
    while (current != null) {
      list += current.`val`
      current = current.next
    }
    arr += head.`val`
    var i = 1
    var j = list.size - 1
    while (i <= j) {
      arr += list(j)
      if (i != j) arr += list(i)
      i += 1
      j -= 1
    }
    i = 1
    while (i < arr.size) {
      reList.next = new ListNode(arr(i))
      reList = reList.next
      i += 1
    }
  }

  def isPalindrome(head: ListNode): Boolean = {
    var slow: ListNode = head
    var fast: ListNode = head
    var prev: ListNode = null
    var next: ListNode = head

    while (fast != null && fast.next != null) {
      fast = fast.next.next // Move fast pointer
      next = slow.next // Store next node for reversing
      slow.next = prev // Reverse the slow pointer's next node
      prev = slow // Update prev to current slow node
      slow = next // Move slow pointer
    }
    if (fast != null) slow = slow.next

    while (slow != null) {
      if (slow.`val` != prev.`val`) return false
      slow = slow.next
      prev = prev.next
    }
    true
  }

  def mergeInBetween(list1: ListNode, a: Int, b: Int, list2: ListNode): ListNode = {
    var dummy = new ListNode(0, list1)
    var workList1: ListNode = null
    var workList2: ListNode = null
    var workList3: ListNode = list2
    var workB: Int = b + 1
    var workA: Int = a
    while (dummy.next != null) {
      workA -= 1
      workB -= 1
      dummy = dummy.next
      if (workA == 0) workList1 = dummy
      if (workB == 0) {
        workList2 = dummy
      }
    }
    if (workList1 == null) workList1 = list1
    workList1.next = list2

    while (workList3.next != null) {
      workList3 = workList3.next
    }
    workList3.next = workList2.next

    list1
  }
}
