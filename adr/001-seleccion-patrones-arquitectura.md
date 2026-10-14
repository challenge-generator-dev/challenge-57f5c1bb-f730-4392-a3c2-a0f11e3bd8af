# ADR 001: Selección de Patrones Arquitectónicos para Core Financiero Multi-Región

**Estado:** Propuesto
**Fecha:** 2024-05-20

## Contexto

El core financiero de la institución opera en múltiples regiones de la nube (AWS us-east-1, eu-west-1, ap-southeast-1) y debe garantizar:
- **Disponibilidad:** 99.99% (RTO < 5 min, RPO < 1 min).
- **Consistencia eventual:** Máximo 30 segundos de inconsistencia en escenarios de failover.
- **Latencia:** p99 < 80 ms para transacciones críticas.
- **Escalabilidad:** Soportar 25,000 TPS con crecimiento del 30% anual.
- **Resiliencia:** Tolerancia a la caída completa de una región sin pérdida de datos.

El sistema actual presenta los siguientes problemas:
- Acoplamiento regional con dependencias síncronas entre servicios.
- Falta de mecanismos de compensación para transacciones distribuidas.
- Alta latencia en la replicación de datos entre regiones.
- Monitoreo reactivo en lugar de proactivo.

## Fuerzas

1. **Trade-off entre consistencia y disponibilidad:**
   - La replicación síncrona garantiza consistencia fuerte pero aumenta la latencia y reduce la disponibilidad.
   - La replicación asíncrona mejora la disponibilidad pero introduce inconsistencia eventual.
   - **Métrica:** Tiempo de inconsistencia tolerable (30 segundos) vs. impacto en la experiencia del usuario.

2. **Complejidad vs. resiliencia:**
   - Patrones como Sagas y CQRS mejoran la resiliencia pero aumentan la complejidad del sistema.
   - **Métrica:** Número de componentes adicionales vs. reducción del RTO/RPO.

3. **Costo vs. escalabilidad:**
   - Serverless reduce costos operativos pero puede introducir latencia en cold starts.
   - **Métrica:** Costo por millón de transacciones vs. latencia p99.

4. **Consistencia de eventos vs. ordenamiento:**
   - EDA (Event-Driven Architecture) mejora la escalabilidad pero requiere garantizar el ordenamiento de eventos.
   - **Métrica:** Throughput de eventos vs. complejidad de manejo de duplicados.

5. **Failover vs. degradación controlada:**
   - Multi-region active-active mejora la resiliencia pero requiere mecanismos de degradación controlada.
   - **Métrica:** Tiempo de failover vs. impacto en la experiencia del usuario.

## Opciones consideradas

> **Preguntas guía:**
> 1. ¿Qué patrones arquitectónicos evaluarías para abordar los ASRs del sistema? Considera al menos 8 patrones (ej. Serverless, CQRS, Sagas, EDA, Multi-Region Active-Active, Circuit Breaker, Retry con backoff exponencial, Bulkhead).
> 2. Para cada patrón, ¿qué ventajas y desventajas identificas en el contexto del core financiero? ¿Cómo impactan en los ASRs?
> 3. ¿Qué combinaciones de patrones podrían trabajar en sinergia para mejorar la resiliencia y escalabilidad?
> 4. ¿Qué patrones descartarías y por qué?

## Decisión

> **Preguntas guía:**
> 1. ¿Qué combinación de patrones seleccionarías para cumplir con los ASRs?
> 2. ¿Cómo justificarías tu elección con métricas cuantificables (ej. mejora en RTO/RPO, reducción de latencia p99)?
> 3. ¿Qué criterios usarías para priorizar la implementación de los patrones seleccionados?

## Consecuencias

> **Preguntas guía:**
> 1. ¿Qué nuevos riesgos introducen los patrones seleccionados?
> 2. ¿Cómo afectan los patrones a la complejidad operativa y al costo total de propiedad (TCO)?
> 3. ¿Qué dependencias adicionales se generan (ej. servicios de mensajería, bases de datos multi-region)?
> 4. ¿Qué métricas de monitoreo implementarías para validar el impacto de los patrones?

---