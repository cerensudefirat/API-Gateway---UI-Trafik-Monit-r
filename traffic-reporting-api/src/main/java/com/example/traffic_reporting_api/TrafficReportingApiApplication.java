package com.example.traffic_reporting_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TrafficReportingApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(
                TrafficReportingApiApplication.class,
                args
        );
    }

}