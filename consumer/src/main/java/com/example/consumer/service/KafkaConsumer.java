package com.example.consumer.service;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {
    @KafkaListener(topics = "${spring.kafka.topic}")
    public void listen(ConsumerRecord<?, ?> record) {
        System.out.println("topic = " + record.topic() + ", offset = " + record.offset() + ", message = " + record.value());
    }
}
