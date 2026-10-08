# API Gateway – UI Trafik Monitörü

Spring Cloud Gateway, Spring Boot, Apache Kafka, MySQL ve Apache NiFi kullanılarak geliştirilen trafik izleme ve alarm sistemidir. HTTP isteklerini kaydeder, trafik verilerini raporlar ve belirlenen eşiklere göre alarm akışları oluşturur.

## Teknolojiler

* Java, Spring Boot, Spring Cloud Gateway
* Apache Kafka
* MySQL, R2DBC
* Apache NiFi, Docker

## Kurulum ve Çalıştırma

### 1. Gereksinimler

* JDK 21 veya projeyle uyumlu JDK sürümü
* Docker Desktop
* MySQL
* Proje kaynak kodları

### 2. Altyapı servislerini başlatın

Docker üzerinden Kafka ve NiFi servislerini başlatın. MySQL servisinin çalıştığından ve veritabanı bağlantı bilgilerinin uygulama yapılandırmasıyla eşleştiğinden emin olun.

### 3. Veritabanını yapılandırın

MySQL üzerinde `ui_traffic_monitor` veritabanını oluşturun. Bağlantı adresi, kullanıcı adı ve parola bilgilerini ilgili uygulamanın `application.properties` veya `application.yml` dosyasında yapılandırın.

### 4. Uygulamaları başlatın

Gateway, Reporting API ve test servisini kendi proje dizinlerinden ayrı ayrı çalıştırın.

Maven Wrapper bulunan projelerde:

```bash
# Windows
.\mvnw.cmd spring-boot:run
```

```bash
# Linux / macOS
./mvnw spring-boot:run
```

Uygulamaları IDE üzerinden ilgili Spring Boot ana sınıflarını çalıştırarak da başlatabilirsiniz.

Örnek servis portları:

* API Gateway: `8080`
* Test servisi: `8081`
* Reporting API: `8082`

### 5. Trafiği test edin

Gateway'e örnek istek gönderin:

```bash
curl http://localhost:8080/test/get
```

Kafka mesajlarını görüntülemek için:

```bash
docker exec -it kafka /opt/kafka/bin/kafka-console-consumer.sh \
  --bootstrap-server localhost:9092 \
  --topic ui-traffic-logs
```

Gateway üzerinden gönderilen isteklerin trafik kayıtları Kafka topic'inde görüntülenebilir.

## Temel Özellikler

* HTTP isteklerini ve yanıt sürelerini izleme
* Kafka üzerinden trafik verisi aktarımı
* Trafik ve güvenlik raporları
* NiFi ile eşik tabanlı performans ve güvenlik alarm akışları
* Basic Authentication korumalı alarm API'si
