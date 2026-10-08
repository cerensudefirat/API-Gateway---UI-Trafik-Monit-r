package com.example.traffic_reporting_api.dto;

public class EndpointTrafficResponse {

    private String httpMethod;
    private String requestPath;
    private Long requestCount;

    public EndpointTrafficResponse(String httpMethod, String requestPath, Long requestCount) {
        this.httpMethod = httpMethod;
        this.requestPath = requestPath;
        this.requestCount = requestCount;
    }

    public EndpointTrafficResponse() {
    }

    public String getHttpMethod() {
        return httpMethod;
    }

    public void setHttpMethod(String httpMethod) {
        this.httpMethod = httpMethod;
    }

    public String getRequestPath() {
        return requestPath;
    }

    public void setRequestPath(String requestPath) {
        this.requestPath = requestPath;
    }

    public Long getRequestCount() {
        return requestCount;
    }

    public void setRequestCount(Long requestCount) {
        this.requestCount = requestCount;
    }
}
