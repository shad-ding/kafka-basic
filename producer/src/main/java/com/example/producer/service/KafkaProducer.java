package com.example.producer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;

@Service
public class KafkaProducer {
    @Autowired
    private KafkaTemplate kafkaTemplate;

    @Value("${spring.kafka.topic}")
    private String topic;

    public void send(String jsonString) {
        ListenableFuture future = kafkaTemplate.send(topic, jsonString);
        future.addCallback(o -> System.out.println("kafka succeeded to send: " + jsonString), throwable -> System.out.println("Kafka failed to send ：" + jsonString));
    }
}
