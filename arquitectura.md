# Arquitectura del Core Financiero Multi-Región

## 1. Vista de Contexto

> **Diagrama proporcionado en `diagramas/contexto.mmd`**.

**Descripción del sistema actual (as-is):**
- El core financiero interactúa con:
  - **Clientes**: Aplicaciones móviles y web.
  - **Sistemas externos**: Proveedores de pagos (SWIFT, Visa, Mastercard), bancos corresponsales.
  - **Reguladores**: PCI-DSS, GDPR, bancos centrales.
- **Fronteras actuales**:
  - API REST expuesta a clientes.
  - Conexiones directas a bases de datos relacionales.
  - Integración síncrona con sistemas externos.

**Preguntas guía para el diseño propuesto (to-be):**
- ¿Qué nuevos actores se integrarán? (ej: servicios de caching regional, colas de eventos)
- ¿Cómo se simplifican las fronteras? (ej: API Gateway, desacoplamiento con colas)
- ¿Qué protocolos de comunicación se usarán? (ej: gRPC, Kafka, HTTP/2)

---

## 2. Vista de Contenedores

> **Preguntas guía:**
> - ¿Qué contenedores componen el sistema? (ej: microservicios, bases de datos, colas)
> - ¿Cómo se distribuyen entre regiones? (ej: activos-activos, activos-pasivos)
> - ¿Qué patrones de despliegue se usan? (ej: Serverless, Kubernetes)

| Contenedor | Tecnología | Regiones | Responsabilidad |
|------------|------------|----------|-----------------|
|            |            |          |                 |

**Ejemplo de contenedores esperados:**
- **API Gateway**: Enrutamiento regional, autenticación, rate limiting.
- **Servicio de Pagos**: Procesamiento de transacciones (CQRS + Sagas).
- **Base de Datos**: PostgreSQL/ DynamoDB con replicación multi-región.
- **Cola de Eventos**: Kafka/Kinesis para eventos financieros.
- **Cache Regional**: Redis/DAX para datos frecuentes.

---

## 3. Vista de Componentes

### 3.1 Servicio de Pagos

> **Preguntas guía:**
> - ¿Qué componentes internos tiene? (ej: Command Handler, Query Handler, Saga Orchestrator)
> - ¿Cómo interactúan entre sí? (ej: colas, eventos)
> - ¿Qué tácticas de resiliencia implementan? (ej: Circuit Breaker, Retry)

| Componente | Responsabilidad | Tecnología | Patrones |
|------------|-----------------|------------|----------|
|            |                 |            |          |

**Ejemplo de componentes esperados:**
- **Command Handler**: Procesa comandos de transacciones.
- **Query Handler**: Consulta datos optimizados (CQRS).
- **Saga Orchestrator**: Coordina transacciones distribuidas.
- **Event Publisher**: Publica eventos a Kafka.
- **Resilience Wrapper**: Circuit Breaker + Bulkhead.

---

### 3.2 Base de Datos

> **Preguntas guía:**
> - ¿Qué estrategias de consistencia se usan? (ej: eventual, quórum)
> - ¿Cómo se manejan las réplicas? (ej: multi-región activas-activas)
> - ¿Qué índices/materialized views se crean? (ej: para consultas frecuentes)

| Componente | Responsabilidad | Tecnología | Patrones |
|------------|-----------------|------------|----------|
|            |                 |            |          |

---

## 4. Vista de Despliegue

> **Preguntas guía:**
> - ¿Cómo se despliega el sistema en múltiples regiones? (ej: activos-activos, activos-pasivos)
> - ¿Qué herramientas de infraestructura se usan? (ej: Terraform, Kubernetes)
> - ¿Cómo se monitorea y opera? (ej: Prometheus, Grafana, CloudWatch)

| Región | Contenedores | Herramientas | Patrones de Resiliencia |
|--------|--------------|--------------|-------------------------|
|        |              |              |                         |

**Ejemplo de despliegue:**
- **Región Primaria (us-east-1)**: Activa para procesamiento.
- **Región Secundaria (eu-west-1)**: Activa para lectura y failover.
- **Herramientas**: AWS EKS, DynamoDB Global Tables, Kafka Multi-Region.
- **Patrones**: Circuit Breaker, Bulkhead, Retry.

---

## 5. Contratos y Fronteras

> **Preguntas guía:**
> - ¿Qué contratos definen las fronteras entre componentes? (ej: APIs, eventos)
> - ¿Cómo se versionan los contratos? (ej: semántica de versiones)
> - ¿Qué protocolos se usan? (ej: REST, gRPC, Kafka)

| Frontera | Contrato | Protocolo | Versión |
|----------|----------|-----------|---------|
|          |          |           |         |

**Ejemplo de contratos:**
- **API Gateway ↔ Servicio de Pagos**: REST (OpenAPI).
- **Servicio de Pagos ↔ Base de Datos**: DynamoDB SDK.
- **Servicio de Pagos ↔ Cola de Eventos**: Kafka (Event Sourcing).