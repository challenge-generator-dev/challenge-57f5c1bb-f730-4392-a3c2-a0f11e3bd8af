# Atributos de Calidad y Escenarios

## Requisitos Arquitectónicamente Significativos (ASRs)

El sistema del core financiero multi-región debe cumplir con los siguientes ASRs:

| ASR | Valor Medible |
|-----|---------------|
| **Disponibilidad** | 99.99% (4.38 minutos de downtime al mes) |
| **Latencia** | p99 < 80ms para transacciones financieras críticas |
| **Recuperación** | RTO < 5 minutos en caso de fallo regional completo |
| **Consistencia** | Consistencia eventual para datos no críticos (máximo 2 segundos de desfase) |
| **Escalabilidad** | 25,000 TPS (transacciones por segundo) en horario pico |
| **Seguridad** | 0 incidentes de datos sensibles expuestos (cumplimiento PCI-DSS) |

## Escenarios de Calidad

Cada escenario sigue el formato **Fuente → Estímulo → Artefacto → Entorno → Respuesta → Medida** (ISO 25010).

### Escenario 1: Disponibilidad ante Fallo Regional

> **Fuente:** Proveedor de nube (AWS/Azure/GCP).
> **Estímulo:** Fallo completo de una región (ej: us-east-1).
> **Artefacto:** Core financiero multi-región.
>
> **Preguntas guía:**
> - ¿En qué entorno ocurre el fallo? (ej: producción, región primaria)
> - ¿Cómo responde el sistema? (ej: failover automático a región secundaria)
> - ¿Qué métrica se usa para validar la respuesta? (ej: tiempo de recuperación, % de transacciones procesadas)

| Fuente | Estímulo | Artefacto | Entorno | Respuesta | Medida |
|--------|----------|-----------|----------|-----------|--------|
|        |          |           |          |           |        |

---

### Escenario 2: Latencia en Transacciones Críticas

> **Fuente:** Cliente (app móvil/web).
> **Estímulo:** Solicitud de transferencia internacional.
> **Artefacto:** Servicio de pagos.
>
> **Preguntas guía:**
> - ¿Cuál es el entorno de ejecución? (ej: horario pico, región con alta latencia de red)
> - ¿Qué patrón arquitectónico mitiga la latencia? (ej: CQRS, caching regional)
> - ¿Cómo se mide el cumplimiento? (ej: p99 < 80ms, throughput)

| Fuente | Estímulo | Artefacto | Entorno | Respuesta | Medida |
|--------|----------|-----------|----------|-----------|--------|
|        |          |           |          |           |        |

---

### Escenario 3: Consistencia de Datos Multi-Región

> **Fuente:** Servicio de autorización de pagos.
> **Estímulo:** Transacción aprobada en región A pero rechazada en región B.
> **Artefacto:** Base de datos distribuida.
>
> **Preguntas guía:**
> - ¿Qué estrategia de consistencia se aplica? (ej: eventual, fuerte, quórum)
> - ¿Cómo se garantiza la atomicidad en operaciones multi-región? (ej: Sagas, 2PC)
> - ¿Qué métrica evalúa la consistencia? (ej: desfase máximo, % de conflictos)

| Fuente | Estímulo | Artefacto | Entorno | Respuesta | Medida |
|--------|----------|-----------|----------|-----------|--------|
|        |          |           |          |           |        |

---

### Escenario 4: Escalabilidad bajo Carga Pico

> **Fuente:** Mercado financiero.
> **Estímulo:** Evento de alta volatilidad (ej: apertura de mercados).
> **Artefacto:** Servicio de procesamiento de transacciones.
>
> **Preguntas guía:**
> - ¿Qué patrón escala horizontalmente? (ej: Serverless, colas)
> - ¿Cómo se distribuye la carga entre regiones? (ej: weighted routing)
> - ¿Qué métrica valida la escalabilidad? (ej: TPS, % de recursos utilizados)

| Fuente | Estímulo | Artefacto | Entorno | Respuesta | Medida |
|--------|----------|-----------|----------|-----------|--------|
|        |          |           |          |           |        |

---

### Escenario 5: Seguridad en Transacciones

> **Fuente:** Actor malicioso.
> **Estímulo:** Intento de acceso no autorizado a datos sensibles.
> **Artefacto:** API de pagos.
>
> **Preguntas guía:**
> - ¿Qué tácticas de seguridad se implementan? (ej: cifrado en tránsito/reposo, IAM)
> - ¿Cómo se auditan los accesos? (ej: logs centralizados, SIEM)
> - ¿Qué métrica valida la seguridad? (ej: 0 incidentes, tiempo de detección)

| Fuente | Estímulo | Artefacto | Entorno | Respuesta | Medida |
|--------|----------|-----------|----------|-----------|--------|
|        |          |           |          |           |        |