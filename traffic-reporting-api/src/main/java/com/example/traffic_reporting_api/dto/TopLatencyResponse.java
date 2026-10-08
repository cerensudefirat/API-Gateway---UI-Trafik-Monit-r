package com.example.traffic_reporting_api.dto;

public record TopLatencyResponse(
        String requestPath,
        String targetApplication,
        Long responseTime
) {
}