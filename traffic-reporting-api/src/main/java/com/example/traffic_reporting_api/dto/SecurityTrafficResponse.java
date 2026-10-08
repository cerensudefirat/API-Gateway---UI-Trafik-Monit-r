package com.example.traffic_reporting_api.dto;

public record SecurityTrafficResponse(
        Integer statusCode,
        Long requestCount
) {
}