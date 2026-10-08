package com.example.traffic_reporting_api.controller;


import com.example.traffic_reporting_api.dto.*;
import com.example.traffic_reporting_api.service.TrafficReportService;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/reports")
public class TrafficReportController {

    private final TrafficReportService trafficReportService;

    public TrafficReportController(
            TrafficReportService trafficReportService) {

        this.trafficReportService = trafficReportService;
    }

    @GetMapping("/endpoint-traffic")
    public Flux<EndpointTrafficResponse> getMostUsedEndpoints() {
        return trafficReportService.getMostUsedEndpoints();
    }

    @GetMapping("/security/recent/total")
    public Mono<Long> getRecentSecurityTrafficCount() {
        return trafficReportService.getRecentSecurityTrafficCount();
    }

    @GetMapping("/method-latency")
    public Flux<MethodLatencyResponse> getMethodLatency() {
        return trafficReportService.getMethodLatency();
    }

    @GetMapping("/performance")
    public Flux<TopLatencyResponse> getTop5Latency() {
        return trafficReportService.getTop5Latency();
    }

    @GetMapping("/latency/recent")
    public Mono<Double> getRecentAverageResponseTime() {
        return trafficReportService.getRecentAverageResponseTime();
    }

    @GetMapping("/traffic-distribution")
    public Flux<TrafficDistributionResponse> getTrafficDistribution() {
        return trafficReportService.getTrafficDistribution();
    }

    @GetMapping("/security")
    public Flux<SecurityTrafficResponse> getSecurityTraffic() {
        return trafficReportService.getSecurityTraffic();
    }

}