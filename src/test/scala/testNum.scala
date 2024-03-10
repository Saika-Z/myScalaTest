import scala.annotation.tailrec
import scala.collection.mutable
import scala.collection.mutable.LinkedList

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

    val arr: Array[Int] = Array(-4, -1, 0, 3, 10)
    val node: TreeNode = TreeNode.mkTree("1,2,3,4,null,6,null,8")
    val i1 = new TreeNode().beforeTraverse(node)
    val i2 = new TreeNode().afterTraverse(node)
    val i3 = new TreeNode().sequenceTraverse(node)
    printf("前序: %s\n", i1.toString)
    printf("后序: %s\n", i2.toString)
    printf("层序: %s\n", i3.toString)

    println(intersection(Array(1,2,2,1),Array(2,2)))
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

}
