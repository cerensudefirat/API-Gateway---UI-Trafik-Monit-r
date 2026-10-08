package com.example.traffic_reporting_api.entity;


import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Table("ui_traffic_logs")
public class TrafficLog {

    @Id
    private Long id;

    private String targetApplication;

    private String httpMethod;

    private String requestPath;

    private Integer responseStatus;

    private Long responseTime;

    private LocalDateTime createdAt;

    public TrafficLog() {
    }

    public TrafficLog(
            Long id,
            String targetApplication,
            String httpMethod,
            String requestPath,
            Integer responseStatus,
            Long responseTime,
            LocalDateTime createdAt) {

        this.id = id;
        this.targetApplication = targetApplication;
        this.httpMethod = httpMethod;
        this.requestPath = requestPath;
        this.responseStatus = responseStatus;
        this.responseTime = responseTime;
        this.createdAt = createdAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTargetApplication() {
        return targetApplication;
    }

    public void setTargetApplication(String targetApplication) {
        this.targetApplication = targetApplication;
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

    public Integer getResponseStatus() {
        return responseStatus;
    }

    public void setResponseStatus(Integer responseStatus) {
        this.responseStatus = responseStatus;
    }

    public Long getResponseTime() {
        return responseTime;
    }

    public void setResponseTime(Long responseTime) {
        this.responseTime = responseTime;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
    @Override
    public String toString() {
        return "TrafficLog{" +
                "id=" + id +
                ", targetApplication='" + targetApplication + '\'' +
                ", httpMethod='" + httpMethod + '\'' +
                ", requestPath='" + requestPath + '\'' +
                ", responseStatus=" + responseStatus +
                ", responseTime=" + responseTime +
                ", createdAt=" + createdAt +
                '}';
    }
}