package com.example.traffic_reporting_api.dto;

public record TrafficDistributionResponse(
        String application,
        Long requestCount,
        Double percentage
) {
}