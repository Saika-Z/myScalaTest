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

/*

    val session = SparkSession.builder().master("local[*]").appName("test file").getOrCreate()
    val inpath = "E:\\file\\wechat\\WeChat Files\\zhaowenqingtnt\\FileStorage\\File\\2023-08\\123.csv"
    val readDF: DataFrame = session.read.format("CSV").option("header","true").load(inpath).drop("1")

    val frame = readDF.toDF("EXAMINAIM", "name", "en", "gender", "age", "chname", "result", "unit")
    frame.select(col="EXAMINAIM").distinct().show()
    frame.where(frame.col("name")<=>"安维智")
      .createTempView("map")



    session.sql(
      """
        |select name,concat_ws(" ",en,EXAMINAIM,gender,age,chname,result,unit) as en from map
        |-- group by name
        |
        |""".stripMargin).collect().foreach(println)
*/

  }

}
