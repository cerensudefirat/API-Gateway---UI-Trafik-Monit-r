package com.example.traffic_reporting_api.repository;

import com.example.traffic_reporting_api.dto.*;
import com.example.traffic_reporting_api.entity.TrafficLog;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface TrafficLogRepository
        extends ReactiveCrudRepository<TrafficLog, Long> {

    @Query("""
        SELECT
            request_path AS request_path,
            target_application AS target_application,
            response_time AS response_time
        FROM ui_traffic_logs
        WHERE created_at >= NOW() - INTERVAL 1 HOUR
        ORDER BY response_time DESC
        LIMIT 5
        """)
    Flux<TopLatencyResponse> findTop5Latency();

    @Query("""
        SELECT
            target_application AS application,
            COUNT(*) AS request_count,
            COUNT(*) * 100.0 / (SELECT COUNT(*) FROM ui_traffic_logs) AS percentage
        FROM ui_traffic_logs
        GROUP BY target_application
        """)
    Flux<TrafficDistributionResponse> findTrafficDistribution();

    @Query("""
    SELECT
        http_method AS http_method,
        request_path AS request_path,
        COUNT(*) AS request_count
    FROM ui_traffic_logs
    GROUP BY http_method, request_path
    ORDER BY request_count DESC
    LIMIT 10
    """)
    Flux<EndpointTrafficResponse> findMostUsedEndpoints();

    @Query("""
    SELECT
        http_method AS http_method,
        COUNT(*) AS request_count,
        ROUND(AVG(response_time), 2) AS average_response_time,
        MAX(response_time) AS max_response_time
    FROM ui_traffic_logs
    GROUP BY http_method
    ORDER BY average_response_time DESC
    """)
    Flux<MethodLatencyResponse> findMethodLatency();

    @Query("""
        SELECT
            response_status AS status_code,
            COUNT(*) AS request_count
        FROM ui_traffic_logs
        WHERE created_at >= NOW() - INTERVAL 24 HOUR
          AND response_status IN (401, 403)
        GROUP BY response_status
        ORDER BY response_status
        """)
    Flux<SecurityTrafficResponse> findSecurityTraffic();

    @Query("""
        SELECT COUNT(*)
        FROM ui_traffic_logs
        WHERE created_at >= NOW() - INTERVAL 5 MINUTE
          AND response_status IN (401, 403)
        """)
    Mono<Long> countRecentSecurityTraffic();

    @Query("""
        SELECT COALESCE(AVG(response_time), 0)
        FROM ui_traffic_logs
        WHERE created_at >= NOW() - INTERVAL 5 MINUTE
        """)
    Mono<Double> calculateRecentAverageResponseTime();
}