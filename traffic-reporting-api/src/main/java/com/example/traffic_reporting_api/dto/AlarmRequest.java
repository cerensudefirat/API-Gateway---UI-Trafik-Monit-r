package com.example.traffic_reporting_api.dto;

import java.util.Map;

public class AlarmRequest {

    private Map<String, Integer> ruleValues;
    private int category;
    private boolean isAlarm;
    private boolean isActive;
    private String alarmComponentType;
    private String componentId;
    private String occurredTime;
    private String resource;
    private String description;

    public Map<String, Integer> getRuleValues() {
        return ruleValues;
    }

    public void setRuleValues(Map<String, Integer> ruleValues) {
        this.ruleValues = ruleValues;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public boolean isAlarm() {
        return isAlarm;
    }

    public void setAlarm(boolean alarm) {
        isAlarm = alarm;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public String getAlarmComponentType() {
        return alarmComponentType;
    }

    public void setAlarmComponentType(String alarmComponentType) {
        this.alarmComponentType = alarmComponentType;
    }

    public String getComponentId() {
        return componentId;
    }

    public void setComponentId(String componentId) {
        this.componentId = componentId;
    }

    public String getOccurredTime() {
        return occurredTime;
    }

    public void setOccurredTime(String occurredTime) {
        this.occurredTime = occurredTime;
    }

    public String getResource() {
        return resource;
    }

    public void setResource(String resource) {
        this.resource = resource;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}