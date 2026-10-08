package com.example.traffic_reporting_api.dto;

public record TrafficTimelineResponse(
        String time,
        Long requestCount,
        Double averageResponseTime
) {
}