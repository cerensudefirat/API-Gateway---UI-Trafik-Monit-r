package com.argela.proje2;

import com.argela.proje2.kafka.TrafficLogProducer;
import com.argela.proje2.queue.TrafficLogQueue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Proje2Application {

    public static void main(String[] args) {
        SpringApplication.run(Proje2Application.class, args);
    }

    @Bean
    public TrafficLogQueue trafficLogQueue(
            TrafficLogProducer trafficLogProducer,
            @Value("${traffic.queue.capacity}") int queueCapacity) {

        TrafficLogQueue queue =
                new TrafficLogQueue(queueCapacity, trafficLogProducer);

        queue.start();

        return queue;
    }
}