package com.example.traffic_reporting_api.dto;
public class MethodLatencyResponse {

    private String httpMethod;
    private Long requestCount;
    private Double averageResponseTime;
    private Long maxResponseTime;

    public MethodLatencyResponse(
            String httpMethod,
            Long requestCount,
            Double averageResponseTime,
            Long maxResponseTime) {
        this.httpMethod = httpMethod;
        this.requestCount = requestCount;
        this.averageResponseTime = averageResponseTime;
        this.maxResponseTime = maxResponseTime;
    }

    public MethodLatencyResponse() {
    }

    public String getHttpMethod() {
        return httpMethod;
    }

    public void setHttpMethod(String httpMethod) {
        this.httpMethod = httpMethod;
    }

    public Long getRequestCount() {
        return requestCount;
    }

    public void setRequestCount(Long requestCount) {
        this.requestCount = requestCount;
    }

    public Double getAverageResponseTime() {
        return averageResponseTime;
    }

    public void setAverageResponseTime(Double averageResponseTime) {
        this.averageResponseTime = averageResponseTime;
    }

    public Long getMaxResponseTime() {
        return maxResponseTime;
    }

    public void setMaxResponseTime(Long maxResponseTime) {
        this.maxResponseTime = maxResponseTime;
    }
}