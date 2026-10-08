package com.argela.proje2.kafka;

import com.argela.proje2.entity.TrafficLog;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class TrafficLogProducer {

    private static final String TOPIC = "ui-traffic-logs";

    private final KafkaTemplate<String, TrafficLog> kafkaTemplate;

    public TrafficLogProducer(
            KafkaTemplate<String, TrafficLog> kafkaTemplate) {

        this.kafkaTemplate = kafkaTemplate;
    }

    public boolean send(TrafficLog trafficLog) {

        try {

            kafkaTemplate.send(TOPIC, trafficLog)
                    .get(3, TimeUnit.SECONDS);

            System.out.println(
                    "TrafficLog Kafka'ya gonderildi."
            );

            return true;

        } catch (Exception e) {

            System.err.println(
                    "Kafka gonderilemedi: "
                            + e.getMessage()
            );

            return false;
        }
    }
}