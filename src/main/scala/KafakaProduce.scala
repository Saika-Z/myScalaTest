import org.apache.kafka.clients.producer.{KafkaProducer, ProducerRecord}
import java.util.Properties
import scala.util.Random


object KafakaProduce {
    def main(args: Array[String]): Unit = {
        val topics = "test-topic"
        
        val props = new Properties()

        props.put("bootstrap.servers", "localhost:9092")
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer")
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer")

        val producer = new KafkaProducer[String, String](props)

        for (i <- 1 to 10) {
            val message = s"message-$i-${Random.alphanumeric.take(5).mkString}"
            val record = new ProducerRecord[String, String](topics, null, message)
            producer.send(record)
            println(s"Sent: $message")
            Thread.sleep(500)  // 模拟消息发送间隔

        }

        producer.close()

    }
  
}
