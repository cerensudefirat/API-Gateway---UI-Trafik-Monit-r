package com.example.traffic_reporting_api.dto;

public record ApplicationTrafficResponse(
        String application,
        Long requestCount,
        Double averageResponseTime
) {
}
