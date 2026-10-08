package com.argela.proje2.repository;

import com.argela.proje2.entity.TrafficLog;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface TrafficLogRepository extends ReactiveCrudRepository<TrafficLog, Long> {
    
}
