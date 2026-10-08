package com.example.traffic_reporting_api.dto;

public record StatusTrafficResponse(
        Integer statusCode,
        Long requestCount
) {
}