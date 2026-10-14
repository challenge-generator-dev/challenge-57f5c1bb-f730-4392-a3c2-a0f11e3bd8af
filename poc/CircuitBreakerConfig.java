package com.financial.core.resilience;

import io.github.resilience4j.bulkhead.Bulkhead;
import io.github.resilience4j.bulkhead.BulkheadConfig;
import io.github.resilience4j.circuitbreaker.CircuitBreaker;
import io.github.resilience4j.circuitbreaker.CircuitBreakerConfig;
import io.github.resilience4j.retry.Retry;
import io.github.resilience4j.retry.RetryConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Duration;
import java.util.function.Supplier;

@Configuration
public class CircuitBreakerConfig {

    // Simulación de servicio regional fallido
    private final RegionalServiceClient regionalServiceClient = new RegionalServiceClient();

    @Bean
    public CircuitBreaker circuitBreaker() {
        CircuitBreakerConfig config = CircuitBreakerConfig.custom()
                .failureRateThreshold(50) // % de fallos para abrir el circuito
                .waitDurationInOpenState(Duration.ofSeconds(30)) // tiempo en estado abierto
                .slidingWindowType(CircuitBreakerConfig.SlidingWindowType.COUNT_BASED)
                .slidingWindowSize(10) // número de llamadas para calcular tasa de fallos
                .permittedNumberOfCallsInHalfOpenState(3) // llamadas permitidas en estado semiabierto
                .recordExceptions(RuntimeException.class)
                .build();
        
        return CircuitBreaker.of("regionalServiceCircuitBreaker", config);
    }

    @Bean
    public Retry retry() {
        RetryConfig config = RetryConfig.custom()
                .maxAttempts(3) // intentos máximos
                .waitDuration(Duration.ofMillis(500)) // espera inicial entre reintentos
                .retryExceptions(RuntimeException.class)
                .build();
        
        return Retry.of("regionalServiceRetry", config);
    }

    @Bean
    public Bulkhead bulkhead() {
        BulkheadConfig config = BulkheadConfig.custom()
                .maxConcurrentCalls(10) // llamadas concurrentes máximas
                .maxWaitDuration(Duration.ofMillis(100)) // tiempo máximo de espera
                .build();
        
        return Bulkhead.of("regionalServiceBulkhead", config);
    }

    // Método decorado con patrones de resiliencia
    public Double getAccountBalanceWithResilience(String accountId) {
        Supplier<Double> decoratedSupplier = CircuitBreaker
                .decorateSupplier(circuitBreaker(),
                        Retry.decorateSupplier(retry(),
                                Bulkhead.decorateSupplier(bulkhead(),
                                        () -> regionalServiceClient.getAccountBalance(accountId))));
        
        try {
            return decoratedSupplier.get();
        } catch (Exception e) {
            return fallbackForGetAccountBalance(accountId, e);
        }
    }

    // HUECO: Implementar método de fallback
    // Preguntas guía:
    // 1. ¿Qué valor seguro puedes devolver cuando falla el servicio regional?
    // 2. ¿Cómo garantizarías consistencia eventual con la última transacción conocida?
    // 3. ¿Debe el fallback registrar el error para análisis posterior?
    private Double fallbackForGetAccountBalance(String accountId, Exception e) {
        // TODO: Implementar lógica de fallback
        // Sugerencia: Usa un valor por defecto o cache local
        throw new UnsupportedOperationException("Método de fallback no implementado");
    }
}

class RegionalServiceClient {
    // Simula un servicio regional que puede fallar
    public Double getAccountBalance(String accountId) {
        // Simulación de fallo regional (configurable via propiedad)
        if (Boolean.getBoolean("simulate.region-failure")) {
            throw new RuntimeException("Fallo en región: servicio no disponible");
        }
        return 1500.0; // Valor simulado
    }
}