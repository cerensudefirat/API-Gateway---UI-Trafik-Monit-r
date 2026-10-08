package com.example.traffic_reporting_api.controller;

import com.example.traffic_reporting_api.entity.TrafficLog;
import com.example.traffic_reporting_api.service.TrafficReportService;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/traffic")
public class TrafficLogController {

    private final TrafficReportService trafficReportService;

    public TrafficLogController(
            TrafficReportService trafficReportService) {

        this.trafficReportService = trafficReportService;
    }

    @PostMapping
    public Mono<TrafficLog> receiveTraffic(
            @RequestBody TrafficLog trafficLog) {

        return trafficReportService.saveTrafficLog(trafficLog);
    }
}