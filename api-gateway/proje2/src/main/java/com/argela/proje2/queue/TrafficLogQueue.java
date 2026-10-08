package com.argela.proje2.queue;

import com.argela.proje2.entity.TrafficLog;
import com.argela.proje2.kafka.TrafficLogProducer;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class TrafficLogQueue extends Thread {

    private final BlockingQueue<TrafficLog> queue;
    private final TrafficLogProducer trafficLogProducer;

    public TrafficLogQueue(
            int capacity,
            TrafficLogProducer trafficLogProducer) {

        this.trafficLogProducer = trafficLogProducer;
        this.queue = new LinkedBlockingQueue<>(capacity);
    }

    @Override
    public void run() {

        while (true) {

            try {

                TrafficLog trafficLog = queue.peek();

                if (trafficLog == null) {
                    Thread.sleep(100);
                    continue;
                }

                System.out.println(
                        "Queue'dan gonderilecek: " + trafficLog
                );

                boolean sent =
                        trafficLogProducer.send(trafficLog);

                if (sent) {

                    queue.poll();

                    System.out.println(
                            "TrafficLog Queue'dan cikarildi."
                    );

                } else {

                    System.out.println(
                            "Kafka gonderimi basarisiz. "
                                    + "TrafficLog Queue'da tutuluyor."
                    );

                    Thread.sleep(1000);
                }

            } catch (InterruptedException e) {

                Thread.currentThread().interrupt();
                break;
            }
        }
    }

    public boolean add(TrafficLog trafficLog) {
        return queue.offer(trafficLog);
    }

    public int size() {
        return queue.size();
    }
}