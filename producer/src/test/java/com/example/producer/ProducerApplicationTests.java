package com.example.producer;

import com.example.producer.service.KafkaProducer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ProducerApplicationTests {
    @Autowired
    private KafkaProducer kafkaProducer;

    @Test
    void contextLoads() {
    }

    @Test
    void testSeparation() {
        kafkaProducer.send("Where will we arrive, can you tell me?");
    }
}
