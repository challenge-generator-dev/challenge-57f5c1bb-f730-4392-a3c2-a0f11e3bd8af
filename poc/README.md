# Resilience4j POC para Core Financiero Multi-Región

## Descripción del Problema
El core financiero actual opera en una arquitectura activa-activa multi-región, pero presenta un punto crítico de fallo:
cuando una región completa cae (ej: AWS us-east-1), los servicios que dependen de proveedores regionales (como bases
de datos o APIs de terceros) comienzan a fallar en cascada. Actualmente, no existe un mecanismo de resiliencia que:

1. Detecte automáticamente la caída de una región
2. Redirija el tráfico a regiones disponibles
3. Proporcione fallbacks funcionales para operaciones críticas
4. Limite el impacto de fallos recurrentes ("flapping")

## Objetivo del POC
Implementar patrones de resiliencia usando Resilience4j para simular:
- **Circuit Breaker**: Bloquear llamadas a servicios regionales caídos
- **Retry**: Reintentar operaciones fallidas con backoff exponencial
- **Bulkhead**: Limitar el número de llamadas concurrentes a servicios regionales
- **Fallback**: Proporcionar respuestas alternativas cuando un servicio regional falla

## Instrucciones para el Candidato
1. Completa la implementación en `CircuitBreakerConfig.java` para:
   - Configurar el CircuitBreaker con umbrales apropiados para detección de fallos regionales
   - Implementar la lógica de retry con backoff exponencial
   - Configurar bulkheads para limitar llamadas concurrentes a servicios regionales
   - Definir un método de fallback que devuelva una respuesta segura cuando falle la región

2. El cliente `RegionalServiceClient` simula llamadas a servicios regionales. Debes:
   - Anotar los métodos con `@CircuitBreaker`, `@Retry` y `@Bulkhead` según corresponda
   - Implementar el método `fallbackForGetAccountBalance` que devuelva un saldo seguro (ej: último saldo conocido)

3. Prueba tu implementación:
   ```bash
   mvn spring-boot:run -Dspring-boot.run.arguments="--simulate.region-failure=true"
   ```
   El endpoint `/actuator/health` mostrará el estado del CircuitBreaker.

## Restricciones
- El POC debe ser autocontenido (max 150 líneas en total)
- Usa exclusivamente las dependencias declaradas en `pom.xml`
- No modifiques la estructura de paquetes ni los nombres de clases/métodos
- La implementación debe ser thread-safe y no bloqueante

## Métricas a Evaluar
- Tiempo de recuperación (RTO) tras caída de región
- Porcentaje de llamadas fallidas bloqueadas por el CircuitBreaker
- Latencia introducida por los mecanismos de resiliencia
- Consistencia eventual de los datos en fallback