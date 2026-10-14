# ADR 002: Tácticas de Resiliencia para Multi-Region Active-Active

**Estado:** Propuesto
**Fecha:** 2024-05-20

## Contexto

El core financiero debe operar en múltiples regiones de la nube (AWS us-east-1, eu-west-1, ap-southeast-1) con los siguientes requisitos:
- **Disponibilidad:** 99.99% (RTO < 5 min, RPO < 1 min).
- **Consistencia eventual:** Máximo 30 segundos de inconsistencia en escenarios de failover.
- **Latencia:** p99 < 80 ms para transacciones críticas.
- **Resiliencia:** Tolerancia a la caída completa de una región sin pérdida de datos.

El sistema actual enfrenta los siguientes desafíos:
- Dependencia de una sola región primaria para operaciones críticas.
- Falta de replicación asíncrona eficiente entre regiones.
- Mecanismos de failover manuales con tiempos de recuperación superiores a 30 minutos.
- Monitoreo limitado a métricas básicas de disponibilidad.

## Fuerzas

1. **Replicación de datos vs. latencia:**
   - La replicación síncrona garantiza consistencia fuerte pero aumenta la latencia.
   - La replicación asíncrona mejora la latencia pero introduce inconsistencia eventual.
   - **Métrica:** Tiempo de inconsistencia tolerable (30 segundos) vs. impacto en la experiencia del usuario.

2. **Failover automático vs. costo:**
   - Un failover automático reduce el RTO pero requiere infraestructura redundante.
   - **Métrica:** Costo de infraestructura adicional vs. reducción del RTO.

3. **Multi-region active-active vs. degradación controlada:**
   - Active-active mejora la resiliencia pero requiere mecanismos de degradación controlada.
   - **Métrica:** Throughput en escenarios de degradación vs. complejidad de implementación.

4. **Consistencia de eventos vs. throughput:**
   - Garantizar el ordenamiento de eventos mejora la consistencia pero reduce el throughput.
   - **Métrica:** Throughput de eventos vs. complejidad de manejo de duplicados.

5. **Monitoreo proactivo vs. ruido:**
   - Un monitoreo proactivo permite detectar fallos antes de que impacten al usuario, pero puede generar alertas falsas.
   - **Métrica:** Tasa de falsos positivos vs. tiempo de detección de fallos.

## Opciones consideradas

> **Preguntas guía:**
> 1. ¿Qué tácticas de resiliencia evaluarías para implementar un modelo multi-region active-active? Considera:
>    - Replicación de datos (síncrona vs. asíncrona).
>    - Failover automático vs. manual.
>    - Mecanismos de degradación controlada.
>    - Estrategias de consistencia eventual.
>    - Monitoreo proactivo con umbrales dinámicos.
> 2. Para cada táctica, ¿qué ventajas y desventajas identificas en el contexto del core financiero?
> 3. ¿Qué combinación de tácticas podría garantizar los ASRs sin aumentar excesivamente la complejidad o el costo?
> 4. ¿Qué tácticas descartarías y por qué?

## Decisión

> **Preguntas guía:**
> 1. ¿Qué combinación de tácticas seleccionarías para cumplir con los ASRs?
> 2. ¿Cómo justificarías tu elección con métricas cuantificables (ej. mejora en RTO/RPO, reducción de latencia p99)?
> 3. ¿Qué herramientas o servicios de la nube utilizarías para implementar las tácticas seleccionadas?

## Consecuencias

> **Preguntas guía:**
> 1. ¿Qué nuevos riesgos introducen las tácticas seleccionadas?
> 2. ¿Cómo afectan las tácticas al costo operativo y a la complejidad del sistema?
> 3. ¿Qué dependencias adicionales se generan (ej. servicios de replicación, herramientas de monitoreo)?
> 4. ¿Qué métricas implementarías para validar la efectividad de las tácticas en producción?