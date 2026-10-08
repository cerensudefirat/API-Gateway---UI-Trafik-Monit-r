package com.argela.proje2.kafka;

import com.argela.proje2.entity.TrafficLog;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JacksonJsonSerializer;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaConfig {

    @Bean
    public ProducerFactory<String, TrafficLog> producerFactory() {

        Map<String, Object> config = new HashMap<>();

        config.put(
                ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,
                "localhost:9092"
        );

        config.put(
                ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,
                StringSerializer.class
        );

        config.put(
                ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,
                JacksonJsonSerializer.class
        );

        config.put(
                ProducerConfig.MAX_BLOCK_MS_CONFIG,
                1000
        );

        config.put(
                ProducerConfig.REQUEST_TIMEOUT_MS_CONFIG,
                1000
        );

        config.put(
                ProducerConfig.DELIVERY_TIMEOUT_MS_CONFIG,
                2000
        );

        return new DefaultKafkaProducerFactory<>(config);
    }

    @Bean
    public KafkaTemplate<String, TrafficLog> kafkaTemplate(
            ProducerFactory<String, TrafficLog> producerFactory) {

        return new KafkaTemplate<>(producerFactory);
    }
}