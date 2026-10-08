package com.example.traffic_reporting_api.kafka;

import com.example.traffic_reporting_api.entity.TrafficLog;
import com.example.traffic_reporting_api.repository.TrafficLogRepository;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class TrafficLogConsumer {

    private final TrafficLogRepository trafficLogRepository;

    public TrafficLogConsumer(
            TrafficLogRepository trafficLogRepository) {
        this.trafficLogRepository = trafficLogRepository;
    }

    @KafkaListener(
            topics = "ui-traffic-logs",
            groupId = "traffic-reporting-test"
    )
    public void consume(TrafficLog trafficLog) {

        System.out.println(
                "Kafka mesajı alindi: " + trafficLog
        );

        trafficLogRepository.save(trafficLog)
                .subscribe(
                        savedLog -> System.out.println(
                                "TrafficLog MySQL'e kaydedildi: "
                                        + savedLog
                        ),
                        error -> System.err.println(
                                "MySQL kayit hatasi: "
                                        + error.getMessage()
                        )
                );
    }
}