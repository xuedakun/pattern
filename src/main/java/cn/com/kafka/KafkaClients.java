package cn.com.kafka;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;

/**
 * @author xuekun
 * @create 2017-08-30 18:26
 **/
public class KafkaClients {
    public static void main(String[] args) {
        Properties props = new Properties();
        props.put("bootstrap.servers", "172.28.40.59:9092,172.28.40.59:9093,172.28.40.59:9094");
        props.put("acks", "all");
        props.put("retries", 0);
        props.put("batch.size", 16384);
        props.put("linger.ms", 1);
        props.put("buffer.memory", 33554432);
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        Producer<String, String> producer = new KafkaProducer<>(props);
        for(int i = 100; i < 200; i++)
            producer.send(new ProducerRecord<String, String>("big", Integer.toString(i), Integer.toString(i)));

        producer.close();
    }
}
