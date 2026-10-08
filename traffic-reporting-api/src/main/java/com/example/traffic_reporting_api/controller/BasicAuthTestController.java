package com.example.traffic_reporting_api.controller;

import com.example.traffic_reporting_api.dto.AlarmRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/test")
public class BasicAuthTestController {

    @PostMapping("/alarm")
    public ResponseEntity<?> receiveAlarm(
            @RequestBody String body) {

        System.out.println("GELEN BODY = [" + body + "]");

        return ResponseEntity.ok("OK");
    }
}