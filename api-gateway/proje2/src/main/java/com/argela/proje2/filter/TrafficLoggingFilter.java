package com.argela.proje2.filter;

import com.argela.proje2.entity.TrafficLog;
import com.argela.proje2.queue.TrafficLogQueue;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

@Component
public class TrafficLoggingFilter implements GlobalFilter {

    private final TrafficLogQueue trafficLogQueue;

    public TrafficLoggingFilter(
            TrafficLogQueue trafficLogQueue) {
        this.trafficLogQueue = trafficLogQueue;
    }

    @Override
    public Mono<Void> filter(
            ServerWebExchange exchange,
            GatewayFilterChain chain) {

        long startTime = System.currentTimeMillis();

        String httpMethod = exchange.getRequest()
                .getMethod()
                .name();

        String requestPath = exchange.getRequest()
                .getURI()
                .getPath();

        return chain.filter(exchange)
                .then(
                        Mono.defer(() -> {

                            long responseTime =
                                    System.currentTimeMillis() - startTime;

                            HttpStatusCode statusCode =
                                    exchange.getResponse()
                                            .getStatusCode();

                            Integer responseStatus =
                                    statusCode != null
                                            ? statusCode.value()
                                            : null;

                            TrafficLog trafficLog =
                                    new TrafficLog(
                                            null,
                                            "TEST-SERVICE",
                                            httpMethod,
                                            requestPath,
                                            responseStatus,
                                            responseTime,
                                            LocalDateTime.now()
                                    );
                            boolean added = trafficLogQueue.add(trafficLog);

                            if (!added) {
                                System.err.println(
                                        "TrafficLog Queue dolu, kayit alinamadi."
                                );
                            }
                            return Mono.empty();
                        })
                );
    }
}