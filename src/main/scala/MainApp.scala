import org.apache.spark.sql.SparkSession
import org.apache.hadoop.conf.Configuration
import org.apache.hadoop.fs.FileSystem
import java.net.URI

object MainApp {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder()
      .appName("verify-app")
      .master("local[*]")
      .getOrCreate()

    // log a message from app to check log4j level
    val log = org.apache.log4j.LogManager.getLogger("com.yourorg.yourapp")
    log.info("APPLICATION INFO: log4j test message")
    log.warn("APPLICATION WARN: log4j test warning")

    // Check HDFS config loaded from classpath
    val conf = new Configuration()
    // 强制加载 classpath 下的 core-site.xml/hdfs-site.xml（通常自动）
    conf.addResource(new java.io.FileInputStream("src/main/resources/core-site.xml"))
    conf.addResource(new java.io.FileInputStream("src/main/resources/hdfs-site.xml"))
    // 或直接设置 fs.defaultFS（快速测试）
    conf.set("fs.defaultFS", "hdfs://mycluster")

    // print a couple of key values
    println("dfs.nameservices = " + conf.get("dfs.nameservices"))
    println("dfs.namenode.rpc-address.mycluster.nn1 = " + conf.get("dfs.namenode.rpc-address.mycluster.nn1"))

    // Try to get FileSystem (will attempt to connect if real HDFS configured)
    try {
      val fs = FileSystem.get(conf)
      println("DefaultFS: " + fs.getUri)
      // list root (may fail if no HDFS available; catch and print)
      //val it = fs.listStatus(new org.apache.hadoop.fs.Path("/"))
      //println(s"Root listing count: ${it.length}")
      // 如果不想连接，可以使用本地 FS 代替
      val localFs = org.apache.hadoop.fs.FileSystem.getLocal(conf)
      println("Using local FS: " + localFs.getUri)
    } catch {
      case e: Throwable =>
        println("HDFS access failed (expected if no HDFS). Exception: " + e.getMessage)
    }

    spark.stop()
  }
}
