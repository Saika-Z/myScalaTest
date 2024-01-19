

import java.util
import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer


/** ************************************************************************************
 * *
 *
 * Project:
 * ClassName: sss
 * Description: ${Description}
 * Author: Zhao Wenqing
 * Date:  2022/1/24 23:50
 *
 * ************************************************************************************ */
object sss {
  def uniqueMorseRepresentations(words: Array[String]): Int = {
    val mapMorse = (0 until 26).zip(Array(".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---",
      ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--..")).toMap
    val arr = "abcdefghijklmnopqrstuvwxyz".zipWithIndex.toMap
    val result = words.foldLeft(List.empty[String]) { (list, a) =>
      val x = a.foldLeft("") { (str, ch) =>
        str + mapMorse.get(arr.getOrElse(ch, -1)).mkString
      }
      list :+ x

    }
    result.toSet.size
  }


  def main(args: Array[String]): Unit = {
    // val ss: Array[String] = Array[String](".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--",
    //   "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--..")
    val parater = Array("abc")
    // parater.map(_.map(f=>ss(f.toInt-97))).foreach(println)
    // println( ss("g".toInt))
    val i = uniqueMorseRepresentations(parater)


    val array = ArrayBuffer.empty[Double]
    array += 9
    println(array.toArray.mkString)
  }
}
