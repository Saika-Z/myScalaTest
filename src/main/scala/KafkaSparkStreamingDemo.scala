import org.apache.spark.sql.SparkSession
import org.apache.spark.streaming._
import org.apache.spark.streaming.kafka010._
import org.apache.kafka.common.serialization.StringDeserializer
import org.apache.spark.streaming.kafka010.LocationStrategies.PreferConsistent
import org.apache.spark.streaming.kafka010.ConsumerStrategies.Subscribe

object KafkaSparkStreamingDemo {
  def main(args: Array[String]): Unit = {
    // 创建 SparkSession
    val spark = SparkSession.builder()
      .appName("KafkaSparkStreamingDemo")
      .master("local[*]") // 本地运行
      .getOrCreate()

    // 创建 StreamingContext，批次间隔 5 秒
    val ssc = new StreamingContext(spark.sparkContext, Seconds(5))

    // Kafka 配置
    val kafkaParams = Map[String, Object](
      "bootstrap.servers" -> "localhost:9092",
      "key.deserializer" -> classOf[StringDeserializer],
      "value.deserializer" -> classOf[StringDeserializer],
      "group.id" -> "test-group",
      "auto.offset.reset" -> "latest",
      "enable.auto.commit" -> (false: java.lang.Boolean)
    )

    val topics = Array("test-topic")

    // 创建 Kafka Direct Stream
    val stream = KafkaUtils.createDirectStream[String, String](
      ssc,
      PreferConsistent,
      Subscribe[String, String](topics, kafkaParams)
    )

    // 打印接收到的消息
    stream.foreachRDD { rdd =>
    if (!rdd.isEmpty()) {
  
      val offsetRanges = rdd.asInstanceOf[HasOffsetRanges].offsetRanges

      offsetRanges.foreach { offsetRange =>
        println(s"Topic: ${offsetRange.topic}, Partition: ${offsetRange.partition}, FromOffset: ${offsetRange.fromOffset}, UntilOffset: ${offsetRange.untilOffset}")

      }
      // 处理每条消息
      rdd.foreach { record =>
        println(s"-----------------------------------")
        println(s"Received message: ${record.value()}, partition: ${record.partition()},offset: ${record.offset()}")
        
        }
      // 提交偏移量
      stream.asInstanceOf[CanCommitOffsets].commitAsync(offsetRanges)
      }
    }
    // 启动流式计算
    ssc.start()
    ssc.awaitTerminationOrTimeout(60000)  // 运行 60 秒后停止
    ssc.stop(stopSparkContext = true, stopGracefully = true)  // 优雅停止
  }
}
