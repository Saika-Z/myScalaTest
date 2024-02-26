import org.apache.spark.sql.SparkSession

/** ************************************************************************************
 * *
 *
 * Project:
 * ClassName: mapsideJoin
 * Description: ${Description}
 * Author: Zhao Wenqing
 * Date:  2023/5/15 11:58
 *
 * ************************************************************************************ */
object mapsideJoin {

  def main(args: Array[String]): Unit = {
    val  arrow =  "===================> "

    val sparkSession = SparkSession.builder().master("local[*]").appName("BigRDD Join SmallRDD").getOrCreate()
    val sc = sparkSession.sparkContext
    val list1 = List(("jame", 23), ("wade", 3), ("kobe", 24))
    val list2 = List(("jame", 13), ("wade", 6), ("kobe", 16))
    val bigRDD = sc.makeRDD(list1)
    val smallRDD = sc.makeRDD(list2)

    printf("%-8s\t%-8s\t%-8s\n","bigRDD",arrow,bigRDD.getNumPartitions)
    printf("%-8s\t%-8s\t%-8s\n","smallRDD",arrow,smallRDD.getNumPartitions)
    printf("%s\t%s\t%s\n","smallRDD",arrow,smallRDD.getNumPartitions)

    println(
      s"""
         |driver端rdd不broadcast广播smallRDD到各executor，RDD不能被broadcast，需要转换成数组array
         |各个executor端的task读取广播 value
         |         partition.map(element => {
         |          println(joinUtil(element, smallRDDBV))joinUtil(element, smallRDDBV)})})joinedRDD.foreach(x => println(x))}
         |""".stripMargin)
    // driver端rdd不broadcast广播smallRDD到各executor，RDD不能被broadcast，需要转换成数组array
    val smallRDDB = sc.broadcast(smallRDD.collect())
    /*  val joinedRDD = bigRDD.mapPartitions(partition => {
        val smallRDDBV = smallRDDB.value
        // 各个executor端的task读取广播 value
         partition.map(element => {
          println(joinUtil(element, smallRDDBV))joinUtil(element, smallRDDBV)})})joinedRDD.foreach(x => println(x))}*/
    /** * join操作：对两个rdd中的相同key的value1和value2进行聚合，即(key,value1).join(key,value2)得到(key,(value1, vlaue2))
     * * 如果bigRDDEle的key和smallRDD的某个key一致，那么返回(key,(value1, vlaue2))* 该方法会在各executor的task上执行* */
    /*  def joinUtil(bigRDDEle:(String,Int), smallRDD: Array[(String, Int)]): (String, (Int,Int)) = {
 var joinEle:(String, (Int, Int)) = null
 // 遍历数组
 smallRDDsmallRDD.foreach(smallRDDEle => {if(smallRDDEle._1.equals(bigRDDEle._1)){
   // 如果bigRDD中某个元素的key和数组smallRDD的key一致，返回join结果joinEle = (bigRDDEle._1, (bigRDDEle._2, smallRDDEle._2))}})joinEle}
 }
    }

}*/
  }
}