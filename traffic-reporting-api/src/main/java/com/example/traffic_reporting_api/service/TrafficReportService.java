package com.example.traffic_reporting_api.service;


import com.example.traffic_reporting_api.dto.*;
import com.example.traffic_reporting_api.entity.TrafficLog;
import com.example.traffic_reporting_api.repository.TrafficLogRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Service
public class TrafficReportService {

    private final TrafficLogRepository trafficLogRepository;

    public TrafficReportService(TrafficLogRepository trafficLogRepository) {
        this.trafficLogRepository = trafficLogRepository;
    }

    public Mono<Long> getRecentSecurityTrafficCount() {
        return trafficLogRepository.countRecentSecurityTraffic();
    }
    public Flux<EndpointTrafficResponse> getMostUsedEndpoints() {
        return trafficLogRepository.findMostUsedEndpoints();
    }
    public Flux<MethodLatencyResponse> getMethodLatency() {
        return trafficLogRepository.findMethodLatency();
    }

    public Flux<TopLatencyResponse> getTop5Latency() {
        return trafficLogRepository.findTop5Latency();
    }

    public Flux<TrafficDistributionResponse> getTrafficDistribution() {
        return trafficLogRepository.findTrafficDistribution();
    }

    public Flux<SecurityTrafficResponse> getSecurityTraffic() {
        return trafficLogRepository.findSecurityTraffic();
    }


    public Mono<Double> getRecentAverageResponseTime() {
        return trafficLogRepository.calculateRecentAverageResponseTime();
    }

    public Mono<TrafficLog> saveTrafficLog(TrafficLog trafficLog) {
        return trafficLogRepository.save(trafficLog);
    }

}