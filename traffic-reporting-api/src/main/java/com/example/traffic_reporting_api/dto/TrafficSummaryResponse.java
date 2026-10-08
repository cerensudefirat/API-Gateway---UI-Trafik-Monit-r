package com.example.traffic_reporting_api.dto;

public record TrafficSummaryResponse(
        Long totalRequests,
        Long successfulRequests,
        Long failedRequests,
        Double averageResponseTime
) {
}