import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.sql.functions
import org.apache.log4j._
import org.apache.spark.sql.{DataFrame, SparkSession}

import java.lang.management.ManagementFactory
/** ************************************************************************************
 * *
 *
 * Project:
 * ClassName: demo
 * Description: ${Description}
 * Author: Zhao Wenqing
 * Date:  2023/5/6 12:18
 *
 * ************************************************************************************ */
object demo {
  Logger.getLogger("org").setLevel(Level.ERROR)

  def main(args: Array[String]): Unit = {

    val bean = ManagementFactory.getMemoryMXBean

    val usage = bean.getNonHeapMemoryUsage

    val usage1 = bean.getHeapMemoryUsage
    println(usage+"/"+usage1)

    println(bean)

  }

}
