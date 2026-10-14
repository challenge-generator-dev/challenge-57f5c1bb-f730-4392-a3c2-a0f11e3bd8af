# Prompt para Mejorar el Codigo Base

Copia y pega el contenido del bloque de abajo en un asistente de IA (Claude, ChatGPT)
para obtener un ZIP con el proyecto completo y arrancable.

Si preferis trabajar en tu editor con un agente local (Claude Code, Cursor, Copilot), usa `AGENTS.md` en vez de este archivo: dice lo mismo pero para que escriba los archivos en disco.

## Las dos reglas que no se negocian

1. **Completa el boilerplate.** Todo lo que el proyecto necesita para compilar y arrancar: manifiesto de dependencias, punto de entrada, configuracion, capa de interfaz, y las capas del patron arquitectonico declarado. Eso es andamiaje y es tu trabajo.
2. **NO resuelvas el reto.** Los entregables de las fases son el trabajo de la persona. El hueco pedagogico se deja como esta: el proyecto arranca, pero lo que el reto pide implementar NO esta implementado.

Dicho de otra forma: si algo impide compilar, arreglalo. Si algo es logica de negocio incompleta, validaciones ausentes, un secreto hardcodeado o un patron mejorable, dejalo exactamente como esta — es lo que la persona tiene que encontrar.

## Superficie de practica — NO resuelvas

Estos archivos SON el ejercicio de la persona. No los implementes; deja stubs.

- `adr/002-tacticas-resiliencia-multi-region.md` — El topic pide resiliencia: este archivo es el ejercicio.
- `poc/CircuitBreakerConfig.java` — El topic pide resiliencia: este archivo es el ejercicio.
- `adr/001-seleccion-patrones-arquitectura.md` — El topic pide decisiones de arquitectura: el ADR es el ejercicio.

## Como saber que terminaste

```bash
python3 -c "import glob,sys; assert glob.glob('adr/*.md') and glob.glob('diagramas/*.mmd'), 'faltan ADRs o diagramas'"
```

Ese comando corriendo sin errores es la definicion de "listo".

---

```
## Briefing del reto (autoridad)
Este bloque manda sobre los archivos adjuntos. El stack y el rol salen de AQUÍ, no de un topic genérico ni de markdown placeholder.

### Perfil
Chapter Arquitectura, Especialidad Soluciones, Tecnología Arquitectura de Soluciones, Senior L2

### Brecha de conocimiento
Disena y justifica decisiones de arquitectura con trade-offs explicitos.

### Reto
- Tema: Resiliencia de un core financiero multi-region
- Seniority: senior-l2
- Tipo: practical
- Título: Diseño de Arquitectura Resiliente para Core Financiero Multi-Región
- Tiempo estimado: 180 minutos

### Fases (trabajo del HUMANO — PROHIBIDO completarlas)
No implementes estos entregables. Dejalos como hueco pedagógico. El asistente solo materializa el proyecto arrancable para que el participante pueda trabajar.
- Fase 1: Análisis de Requisitos y Definición de Patrones — objetivo: Identificar y analizar los requisitos arquitectónicos significativos y seleccionar los patrones de arquitectura apropiados. — entregable (NO resolver): Lista de ASRs y patrones de arquitectura seleccionados con sus ventajas y desventajas.
- Fase 2: Diseño de la Arquitectura — objetivo: Crear un diseño detallado de la arquitectura que incluya tácticas de resiliencia avanzadas. — entregable (NO resolver): Diagramas de arquitectura y descripción detallada del diseño.
- Fase 3: Evaluación de Trade-offs y Documentación de Decisiones — objetivo: Evaluar los trade-offs de la arquitectura diseñada y documentar las decisiones tomadas. — entregable (NO resolver): Registro de Decisiones de Arquitectura (ADR) con trade-offs evaluados y riesgos residuales.
- Fase 4: Validación y Entrega del Diseño — objetivo: Validar el diseño de la arquitectura y preparar la entrega final. — entregable (NO resolver): Entrega final del diseño de la arquitectura con todos los diagramas, ADRs y documentación relevante.

Eres un asistente experto en análisis, corrección y generación de archivos de cualquier tipo:
código fuente, documentación, hojas de cálculo, documentos Word, configuraciones, entre otros.
Voy a enviarte una cadena de texto que contiene uno o más archivos. Cada archivo está delimitado por un marcador con el siguiente formato:
// === ARCHIVO: ruta/del/archivo.extension ===
o también puede aparecer como:
## === ARCHIVO: ruta/del/archivo.extension ===
Lo que sigue al marcador puede ser:

El contenido real del archivo (código, texto, YAML, etc.)
Una descripción en lenguaje natural de lo que debe contener el archivo


TU TAREA
PASO 0 — ¿Esto es un proyecto o una carcasa?
Antes de extraer archivos, leé el Briefing (si está) y diagnosticá el adjunto.

Es CARCASA si ocurre CUALQUIERA de estas:
- No hay manifiesto de dependencias del stack del briefing (manifest.json de VTEX IO / package.json / pom.xml / build.gradle / requirements.txt / go.mod / *.tf / *.csproj, según corresponda)
- Hay un "binario" que en realidad es un comentario ("no puede ser mostrado como texto plano", placeholder .fig/.docx vacío)
- Los markdowns ya completan entregables de fases posteriores ("se implementó fade-in", lista de áreas ya resuelta)

Si es CARCASA:
- MATERIALIZÁ un proyecto que arranca en el stack del briefing (VTEX IO Store Framework, Angular, Terraform, pytest, Nest, etc.). Incluí manifiesto, punto de entrada y capa de interfaz reales.
- NO copies los markdowns de "solución" como si fueran el producto. Son ruido de generación.
- NO resuelvas las fases del briefing (están marcadas PROHIBIDO). Dejá el hueco pedagógico: el flujo existe, las microinteracciones/calidad/infra que el reto pide NO están hechas.
- Después seguí al PASO 5 (ZIP).

Si es un proyecto REAL (manifiesto + código que compila o arranca):
- Seguí PASO 1 en adelante. 🔴 compilación sí. 🟡 pedagógico no.

PASO 1 — Detección y extracción
Identifica todos los archivos presentes en la cadena. Para cada archivo extrae:

Su ruta completa (ej: src/main/java/com/pragma/Service.java)
Su contenido o descripción

PASO 2 — Clasificación por tipo
Clasifica cada archivo en una de estas categorías:
A) Código fuente (Java, Python, TypeScript, JavaScript, Kotlin, etc.)
B) Configuración / documentación (YAML, properties, Markdown, JSON, txt, etc.)
C) Excel (.xlsx, .xls, .csv)
D) Word (.docx, .doc)
E) Otro tipo de archivo binario o especial
PASO 3 — Clasificación de errores en código fuente

Objetivo prioritario: que el proyecto compile. No corrijas flujo de negocio ni lógica funcional.

Antes de modificar cualquier archivo de código fuente, clasifica cada problema encontrado en una de estas dos categorías:
🔴 ERROR DE COMPILACIÓN — corregir siempre
Son errores que impiden que el proyecto arranque, sin valor pedagógico:

Import faltante o incorrecto
Clase, método o variable referenciada que no existe en ningún archivo del proyecto
Error de sintaxis
Anotación con atributos inválidos
Dependencia ausente en pom.xml, package.json, etc.
Archivo referenciado que no existe y debe ser creado con implementación mínima

→ CORREGIR estos errores.
🟡 PROBLEMA FUNCIONAL O DE CALIDAD — preservar siempre
Son problemas que no impiden compilar. Pueden ser intencionales para el aprendizaje:

Clave secreta hardcodeada ("secret", "password123")
API deprecada que funciona pero tiene reemplazo moderno
Lógica de negocio incorrecta o incompleta
Código redundante o de baja legibilidad
Falta de validaciones en flujo de negocio
Patrones de diseño incorrectos pero funcionales
Concurrencia no segura
Configuración funcional pero no óptima

→ PRESERVAR tal cual. No corregir, no mejorar, no comentar.
PASO 4 — Procesamiento según tipo de archivo
Tipo A — Código fuente
Aplica únicamente las correcciones clasificadas como 🔴 ERROR DE COMPILACIÓN.
No alteres ningún elemento clasificado como 🟡 PROBLEMA FUNCIONAL O DE CALIDAD.
Si falta un archivo referenciado, créalo con la implementación mínima necesaria para compilar.
Tipo B — Configuración / documentación
Extrae el contenido tal cual, sin modificaciones salvo errores evidentes de sintaxis
(ej: YAML mal indentado).
Tipo C — Excel (.xlsx)
Si viene con contenido real, genera el archivo respetando ese contenido.
Si viene con descripción en lenguaje natural, genera un archivo Excel funcional con:

Fila de encabezados en negrita con color de fondo distintivo
Columnas con ancho ajustado al contenido
Tipos de dato correctos por columna
Validaciones si la descripción lo indica
Hojas nombradas descriptivamente si hay más de una
Filas de ejemplo si no hay datos reales

Tipo D — Word (.docx)
Si viene con contenido real, genera el archivo respetando ese contenido.
Si viene con descripción en lenguaje natural, genera un documento Word funcional con:

Estilos de título (Título 1, Título 2) para jerarquía de secciones
Fuente legible (Calibri o equivalente), tamaño 11-12pt para cuerpo
Márgenes estándar
Tabla de contenido si tiene múltiples secciones
Tablas con encabezados en negrita si aplica

Tipo E — Otro
Genera el archivo con el contenido o estructura más apropiada según la descripción.
PASO 5 — Exportación en ZIP
Empaqueta todos los archivos en un único archivo ZIP descargable respetando exactamente
la estructura de rutas indicada por los marcadores.
El ZIP debe incluir:

Archivos de código con únicamente los errores de compilación corregidos
Archivos de configuración y documentación sin cambios
Archivos nuevos creados para resolver dependencias de compilación faltantes
Archivos Excel y Word generados desde descripción

IMPORTANTE: El ZIP debe estar listo para descargar al finalizar. No preguntes si el usuario
quiere generarlo. Simplemente genera el archivo y proporciona el enlace de descarga; No debes desplegar en el chat el resumen de lo que arreglaste al Zip, solo entregalo.

REGLAS IMPORTANTES

No omitas ningún archivo aunque no tenga errores ni modificaciones
Respeta los nombres y rutas exactas indicadas por los marcadores
Si un archivo no tiene marcador claro, infiere el nombre desde su contenido
Si la cadena contiene solo documentación, placeholders o binarios fake, NO la reproduzcas:
aplicá PASO 0 (materializar el proyecto del briefing). Reproducir la carcasa es un fallo.
No agregues texto después del enlace de descarga del ZIP
No preguntes si el usuario quiere el ZIP: simplemente generalo siempre
Si detectas que falta un archivo de configuración necesario para compilar
(pom.xml, package.json, requirements.txt, build.gradle, etc.), créalo e inclúyelo
inferiendo su contenido desde los imports y frameworks detectados en el código
Nunca corrijas problemas 🟡 aunque parezcan obvios o fáciles de mejorar.
El participante que recibirá este proyecto los debe encontrar y resolver él mismo.


INPUT
Aquí está la cadena con los archivos:

// === ARCHIVO: poc/pom.xml ===
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>
    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>3.2.0</version>
        <relativePath/>
    </parent>

    <groupId>com.financial.core</groupId>
    <artifactId>resilience-poc</artifactId>
    <version>1.0.0</version>
    <name>Resilience4j POC for Multi-Region Financial Core</name>
    <description>Proof of Concept for implementing resilience patterns in a multi-region financial core system</description>

    <properties>
        <java.version>17</java.version>
        <resilience4j.version>2.1.0</resilience4j.version>
    </properties>

    <dependencies>
        <!-- Spring Boot Starters -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-actuator</artifactId>
        </dependency>

        <!-- Resilience4j -->
        <dependency>
            <groupId>io.github.resilience4j</groupId>
            <artifactId>resilience4j-spring-boot2</artifactId>
            <version>${resilience4j.version}</version>
        </dependency>
        <dependency>
            <groupId>io.github.resilience4j</groupId>
            <artifactId>resilience4j-circuitbreaker</artifactId>
            <version>${resilience4j.version}</version>
        </dependency>
        <dependency>
            <groupId>io.github.resilience4j</groupId>
            <artifactId>resilience4j-retry</artifactId>
            <version>${resilience4j.version}</version>
        </dependency>
        <dependency>
            <groupId>io.github.resilience4j</groupId>
            <artifactId>resilience4j-bulkhead</artifactId>
            <version>${resilience4j.version}</version>
        </dependency>
        <dependency>
            <groupId>io.github.resilience4j</groupId>
            <artifactId>resilience4j-timelimiter</artifactId>
            <version>${resilience4j.version}</version>
        </dependency>

        <!-- Testing -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>org.junit.jupiter</groupId>
            <artifactId>junit-jupiter-api</artifactId>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>org.mockito</groupId>
            <artifactId>mockito-core</artifactId>
            <scope>test</scope>
        </dependency>
    </dependencies>

    <build>
        <plugins>
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
            </plugin>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-compiler-plugin</artifactId>
                <configuration>
                    <source>${java.version}</source>
                    <target>${java.version}</target>
                </configuration>
            </plugin>
        </plugins>
    </build>
</project>


// === ARCHIVO: atributos-de-calidad.md ===
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


// === ARCHIVO: README.md ===
# Core Financiero Multi-Región: Arquitectura Resiliente

## Contexto del Negocio

Una institución financiera global opera un **core bancario** que procesa **25,000 transacciones por segundo** en horario pico, con clientes en **más de 50 países**. El sistema actual está desplegado en una única región de AWS (us-east-1), lo que genera los siguientes problemas:

- **Alto riesgo de downtime**: Un fallo en us-east-1 deja sin servicio a todos los clientes.
- **Latencia inaceptable**: Clientes en Asia y Europa experimentan latencias > 300ms.
- **Pérdida de datos**: En caso de fallo regional, se pierden transacciones en proceso.
- **Escalabilidad limitada**: No puede manejar eventos de mercado inesperados (ej: crisis financiera).

## Actores y Restricciones

| Actor | Descripción | Restricciones |
|-------|-------------|---------------|
| **Cliente** | Usuario final (app/web) | Latencia < 200ms para transacciones críticas |
| **Regulador** | Entidades como PCI-DSS, GDPR | Cumplimiento de auditorías, cifrado de datos |
| **Proveedor de Nube** | AWS/Azure/GCP | Costos operativos < $5M/mes, multi-región activas |
| **Equipo de Operaciones** | SREs y DevOps | RTO < 5 minutos, RPO < 2 segundos |

## Arquitectura Actual (As-Is)

El sistema actual tiene:
- **Monolito Java** desplegado en EC2 (us-east-1).
- **Base de datos relacional** (PostgreSQL) con replicas de solo lectura.
- **API REST** sin mecanismos de resiliencia (circuit breakers, retries).
- **Procesamiento síncrono** de transacciones.

**Problemas clave**:
1. **Acoplamiento regional**: Todo el sistema depende de us-east-1.
2. **Falta de consistencia multi-región**: Réplicas con desfase de hasta 10 segundos.
3. **Escalabilidad vertical**: No puede escalar más allá de 10,000 TPS.
4. **Recuperación manual**: Failover a réplicas requiere intervención humana.

## Requisitos Arquitectónicamente Significativos (ASRs)

| ASR | Valor Medible | Prioridad |
|-----|---------------|-----------|
| Disponibilidad | 99.99% | Alta |
| Latencia | p99 < 80ms | Alta |
| Recuperación | RTO < 5min | Crítica |
| Consistencia | Desfase máximo de 2 segundos | Media |
| Escalabilidad | 25,000 TPS | Alta |
| Seguridad | 0 incidentes de datos sensibles | Crítica |

## Objetivo del Reto

Diseñar una **arquitectura resiliente y multi-región** que:
1. **Elimine el single point of failure** mediante despliegues activos-activos.
2. **Reduzca la latencia** usando caching regional y CQRS.
3. **Garantice consistencia** con estrategias distribuidas (Sagas, Event Sourcing).
4. **Escale horizontalmente** con Serverless y colas.
5. **Automatice la recuperación** con patrones como Circuit Breaker y Bulkhead.

**Patrones obligatorios a considerar**:
- Multi-Region Active-Active
- CQRS + Event Sourcing
- Sagas para transacciones distribuidas
- Serverless para procesamiento asíncrono
- Circuit Breaker + Retry + Bulkhead
- API Gateway con weighted routing
- Cache regional (Redis/DAX)

## Estructura del Proyecto

```
.
├── adr/                      # Architectural Decision Records (ADRs)
│   ├── 001-seleccion-patrones-arquitectura.md
│   └── 002-tacticas-resiliencia-multi-region.md
├── arquitectura.md           # Vistas C4 y descripción del diseño
├── atributos-de-calidad.md   # ASRs y escenarios de calidad
├── diagramas/                # Diagramas C4 en Mermaid
│   └── contexto.mmd           # Diagrama de contexto (proporcionado)
├── riesgos-y-mitigaciones.md # Matriz de riesgos
├── contratos/                # Esqueletos de contratos OpenAPI
│   └── core-financiero-api.yaml
├── poc/                      # Spike de 150 líneas (opcional)
│   ├── CircuitBreakerConfig.java
│   └── pom.xml
└── README.md                 # Este documento
```

## Instrucciones para la Entrega

1. **Completar los artefactos**:
   - **ADRs**: Analizar opciones, tomar decisiones y documentar trade-offs.
   - **Diagramas C4**: Crear vistas de contenedores, componentes y despliegue.
   - **Escenarios de calidad**: Llenar las tablas con respuestas y métricas.
   - **Matriz de riesgos**: Identificar riesgos y proponer mitigaciones.

2. **Validar el diseño**:
   - Asegurar que cumple con los ASRs.
   - Verificar que los patrones seleccionados resuelven los problemas del sistema actual.

3. **Entregar**:
   - Archivos modificados en formato Markdown/Diagrama.
   - Capturas de pantalla de los diagramas (si se usan herramientas externas).

**Nota**: El spike en `poc/` es opcional y solo debe usarse si el reto lo requiere. Representa el **problema actual** (ej: acoplamiento regional) y debe refactorizarse para demostrar la solución.


// === ARCHIVO: arquitectura.md ===
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


// === ARCHIVO: riesgos-y-mitigaciones.md ===
# Matriz de Riesgos y Mitigaciones

**Contexto:**
El sistema de core financiero multi-región debe operar con alta disponibilidad (99.99%) y tolerancia a fallos en regiones completas de la nube. Los riesgos identificados deben priorizarse según su impacto en los ASRs (disponibilidad, consistencia eventual, latencia de transacciones y costo operativo).

## Matriz de Riesgos

| Riesgo                                                                 | Probabilidad (Alta/Media/Baja) | Impacto (Alto/Medio/Bajo) | Tratamiento (Prevenir/Mitigar/Aceptar) |
|------------------------------------------------------------------------|-------------------------------|--------------------------|------------------------------------------|
| Caída completa de una región de la nube (ej. AWS us-east-1)           | Media                        | Alto                     |                                          |
| Latencia elevada en la replicación de datos entre regiones           | Alta                          | Alto                     |                                          |
| Inconsistencia de datos en escenarios de failover                     | Media                        | Alto                     |                                          |
| Sobrecarga en la región activa durante un failover                    | Media                        | Alto                     |                                          |
| Fallo en el mecanismo de circuit breaker durante alta carga          | Baja                          | Alto                     |                                          |
| Errores en la implementación de compensaciones en Sagas               | Media                        | Medio                    |                                          |
| Costos operativos excesivos por replicación multi-region              | Alta                          | Medio                    |                                          |
| Vulnerabilidades en la sincronización de eventos en EDA               | Media                        | Alto                     |                                          |
| Dependencia crítica de servicios externos (ej. proveedores de pagos)  | Baja                          | Alto                     |                                          |
| Fallo en el mecanismo de retry exponencial durante degradación        | Media                        | Medio                    |                                          |

> **Preguntas guía para completar la matriz:**
> 1. ¿Qué riesgos adicionales podrían surgir al implementar los patrones seleccionados (Serverless, CQRS, Sagas, EDA, etc.)?
> 2. Para cada riesgo identificado, ¿qué tácticas de mitigación aplicarías y cómo medirías su efectividad?
> 3. ¿Cómo priorizarías los riesgos según su impacto en los ASRs (ej. disponibilidad vs. consistencia eventual)?
> 4. ¿Qué riesgos aceptarías y cuáles son inaceptables para el negocio?

---

// === ARCHIVO: adr/001-seleccion-patrones-arquitectura.md ===
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

// === ARCHIVO: adr/002-tacticas-resiliencia-multi-region.md ===
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

// === ARCHIVO: diagramas/contexto.mmd ===
C4Context
    title Contexto del Core Financiero Multi-Región

    Enterprise_Boundary(b0, "Institución Financiera Global") {
        Person(customer, "Cliente", "Cliente final que realiza transacciones financieras", "$descriptor=retail,corporativo")
        Person(operations, "Equipo de Operaciones", "Equipo responsable de monitorear y mantener el sistema", "$descriptor=24/7")

        SystemDb_Ext(legacyCore, "Core Financiero Legacy", "Sistema monolítico existente que procesa transacciones financieras", "$tags=legacy")
        System_Ext(audit, "Sistema de Auditoría", "Sistema externo responsable de registrar todas las operaciones para cumplimiento regulatorio", "$tags=regulatorio")
        System_Ext(fraudDetection, "Servicio de Detección de Fraude", "Servicio externo que analiza transacciones en tiempo real para detectar actividades sospechosas", "$tags=seguridad")
        System_Ext(swift, "Red SWIFT", "Red global para transferencias interbancarias", "$tags=interbancario")
    }

    System_Boundary(multiRegionCore, "Core Financiero Multi-Región (Sistema Objetivo)") {
        SystemDb(coreService, "Core Financiero Multi-Región", "Nuevo sistema distribuido que procesa transacciones financieras con alta disponibilidad y resiliencia multi-región", "$tags=active-active")
    }

    Rel(customer, coreService, "Realiza transacciones financieras", "HTTPS")
    Rel(operations, coreService, "Monitorea y opera el sistema", "HTTPS")
    Rel(coreService, audit, "Envía registros de operaciones", "gRPC")
    Rel(coreService, fraudDetection, "Consulta análisis de fraude", "gRPC")
    Rel(coreService, swift, "Envía transferencias interbancarias", "SWIFT FIN")
    Rel(coreService, legacyCore, "Sincronización de datos (fase de migración)", "SFTP")

    UpdateLayoutConfig($c4ShapeInRow="3", $c4BoundaryInRow="1")

    %% Preguntas guía para completar el diseño multi-region:
    %% 1. ¿Qué actores adicionales deberían incluirse en el contexto para soportar operaciones multi-región?
    %% 2. ¿Cómo se comunican las regiones entre sí para mantener consistencia eventual? ¿Qué protocolos y mecanismos usarías?
    %% 3. ¿Qué sistemas externos requieren integración regionalizada (ej: réplicas locales de SWIFT o servicios de fraude)?
    %% 4. ¿Cómo impacta la latencia inter-región en los contratos de servicio con los clientes? ¿Qué umbrales establecerías para garantizar la experiencia del usuario?
    %% 5. ¿Qué métricas clave (ej: RPO, RTO) debe cumplir el sistema para ser considerado resiliente? ¿Cómo las medirías y monitorearías?
    %% 6. ¿Qué patrones arquitectónicos (ej: Multi-Region Active-Active, CQRS, Sagas) aplicarías para garantizar la disponibilidad y consistencia de datos?

// === ARCHIVO: contratos/core-financiero-api.yaml ===
openapi: 3.1.0
info:
  title: Core Financiero Multi-Región API
  description: |
    API del Core Financiero Multi-Región que soporta operaciones financieras con alta disponibilidad
    y consistencia eventual entre regiones. Implementa patrones como CQRS, Sagas y Event Sourcing
    para garantizar resiliencia en escenarios de fallo regional.

    **Requisitos Arquitectónicos Significativos (ASRs):**
    - Disponibilidad: 99.99% mensual (SLA), con caída máxima de 1 región completa sin impacto en el servicio.
    - Latencia: p99 < 80ms para transacciones dentro de la región primaria del cliente.
    - Consistencia: Consistencia eventual con RPO < 5s y RTO < 2min para operaciones críticas.
    - Escalabilidad: Soportar 50,000 TPS con crecimiento del 20% anual sin cambios arquitectónicos.
    - Seguridad: Cumplimiento con PCI-DSS, SOC2 e ISO 27001 para todas las operaciones.

    **Patrones Implementados:**
    1. **Multi-Region Active-Active:** Réplicas activas en múltiples regiones con balanceo de carga regional.
    2. **CQRS:** Separación de modelos de lectura y escritura para optimizar rendimiento y escalabilidad.
    3. **Sagas:** Coordinación de transacciones distribuidas con compensación automática.
    4. **Event Sourcing:** Registro inmutable de todas las operaciones para auditoría y replay.
    5. **Circuit Breaker:** Protección contra fallos en cascada en dependencias externas.
    6. **Retry con Backoff Exponencial:** Reintentos inteligentes para operaciones transitorias.
    7. **Bulkhead:** Aislamiento de recursos para evitar contención.
    8. **Rate Limiting:** Control de tráfico para proteger contra abusos y picos de carga.
  version: 1.0.0
  contact:
    name: Equipo de Arquitectura Financiera
    email: architecture@financialglobal.com
  license:
    name: Propietario - Confidencial
    url: https://internal.financialglobal.com/license

servers:
  - url: https://core-financiero-{region}.financialglobal.com/api/v1
    description: Servidor regionalizado del Core Financiero
    variables:
      region:
        enum:
          - us-east-1
          - eu-west-1
          - ap-southeast-1
          - sa-east-1
        default: us-east-1
        description: |
          Región AWS donde se despliega la instancia del Core Financiero.
          Cada región opera en modo Active-Active con réplicas de datos.

          **Requisitos de Consistencia:**
          - Las operaciones de escritura se replican asíncronamente entre regiones con un RPO < 5s.
          - Las operaciones de lectura pueden retornar datos ligeramente desactualizados (stale reads)
            dentro de la misma región con un staleness máximo de 30s.

          **Latencia Esperada:**
          | Región Origen | Región Destino | Latencia p99 (ms) |
          |---------------|----------------|-------------------|
          | us-east-1     | eu-west-1      | 120               |
          | us-east-1     | ap-southeast-1 | 180               |
          | eu-west-1     | ap-southeast-1 | 150               |

  - url: https://core-financiero-global.financialglobal.com/api/v1
    description: |
      Endpoint global para operaciones que requieren consistencia fuerte entre regiones.
      Utilizado únicamente para casos de uso que no pueden tolerar consistencia eventual
      (ej: consultas de saldo consolidado para clientes corporativos).

      **Limitaciones:**
      - Latencia p99 < 300ms para operaciones globales.
      - Throughput máximo de 1,000 TPS para evitar saturación de la red inter-región.
      - No disponible durante fallos de red entre regiones (circuit breaker activado).

paths:
  /accounts:
    post:
      tags:
        - Account Management
      summary: Crear una nueva cuenta financiera
      description: |
        Crea una nueva cuenta en el Core Financiero. La operación se procesa como una Saga
        distribuida para garantizar consistencia en todas las regiones.

        **Flujo de la Saga:**
        1. **Crear Cuenta Local:** Se crea la cuenta en la región primaria del cliente.
        2. **Replicar Datos:** Los datos de la cuenta se replican asíncronamente a las otras regiones.
        3. **Notificar Sistemas Externos:** Se envían eventos a sistemas de auditoría y fraude.
        4. **Confirmar Operación:** La operación se confirma solo después de que todas las regiones
           hayan recibido los datos (con consistencia eventual).

        **Escenarios de Fallo:**
        - Si una región está caída, la cuenta se crea localmente y se sincroniza cuando la región se recupere.
        - Si la replicación falla, se reintenta con backoff exponencial (máximo 5 intentos).
        - Si la notificación a sistemas externos falla, se envía a una cola de dead letter para reprocesamiento.

        **Preguntas para completar la definición:**
        1. ¿Qué información mínima requiere el request para crear una cuenta? ¿Cómo garantizas la validación de datos en todas las regiones?
        2. ¿Qué headers deben incluirse para identificar la región primaria del cliente y el contexto de la transacción?
        3. ¿Cómo manejarías la idempotencia para evitar duplicados en casos de reintentos?
        4. ¿Qué códigos de respuesta específicos devolverías para los escenarios de fallo descritos?
        5. ¿Cómo integrarías este endpoint con el patrón CQRS para separar las operaciones de escritura y lectura?
      operationId: createAccount
      requestBody:
        description: Detalles de la cuenta a crear
        required: true
        content:
          application/json:
            schema:
              $ref: '#/components/schemas/AccountCreationRequest'
      responses:
        '201':
          description: Cuenta creada exitosamente
          content:
            application/json:
              schema:
                $ref: '#/components/schemas/AccountCreationResponse'
        '400':
          description: Solicitud inválida (ej: datos faltantes o inválidos)
        '409':
          description: Conflicto (ej: la cuenta ya existe)
        '503':
          description: Servicio no disponible (ej: fallo en la replicación entre regiones)
        default:
          description: Error inesperado

  /accounts/{accountId}/transactions:
    post:
      tags:
        - Transaction Processing
      summary: Procesar una transacción financiera
      description: |
        Procesa una transacción financiera (ej: transferencia, pago, retiro) con garantías
        de resiliencia multi-región. La operación sigue el patrón Sagas para coordinar
        los pasos distribuidos.

        **Flujo de la Saga:**
        1. **Validar Transacción:** Verifica que la cuenta origen tenga fondos suficientes.
        2. **Reservar Fondos:** Bloquea los fondos en la cuenta origen.
        3. **Procesar Transacción:** Debita la cuenta origen y acredita la cuenta destino.
        4. **Replicar Cambios:** Replica los cambios a todas las regiones.
        5. **Notificar Sistemas Externos:** Envía eventos a auditoría, fraude y sistemas de notificación.
        6. **Confirmar Transacción:** Libera los fondos reservados y confirma la operación.

        **Tácticas de Resiliencia:**
        - **Circuit Breaker:** Protege contra fallos en dependencias externas (ej: SWIFT).
        - **Retry con Backoff Exponencial:** Reintenta operaciones transitorias (máximo 3 intentos).
        - **Bulkhead:** Aísla las operaciones de procesamiento de transacciones para evitar contención.
        - **Compensación:** Revierte la transacción si algún paso de la Saga falla.

        **Preguntas para completar la definición:**
        1. ¿Qué información debe incluirse en el request para procesar una transacción? ¿Cómo garantizas la atomicidad en un entorno multi-región?
        2. ¿Cómo manejarías la idempotencia para evitar duplicados en casos de reintentos?
        3. ¿Qué estrategias de compensación implementarías si la replicación a una región falla?
        4. ¿Cómo integrarías este endpoint con Event Sourcing para registrar todas las operaciones?
        5. ¿Qué métricas expondrías para monitorear el rendimiento y la salud de las Sagas?
      operationId: processTransaction
      parameters:
        - name: accountId
          in: path
          description: Identificador de la cuenta origen
          required: true
          schema:
            type: string
            format: uuid
            example: "123e4567-e89b-12d3-a456-426614174000"
        - name: X-Region-Primary
          in: header
          description: Región primaria del cliente para esta transacción
          required: true
          schema:
            type: string
            enum: ["us-east-1", "eu-west-1", "ap-southeast-1", "sa-east-1"]
      requestBody:
        description: Detalles de la transacción a procesar
        required: true
        content:
          application/json:
            schema:
              $ref: '#/components/schemas/TransactionRequest'
      responses:
        '200':
          description: Transacción procesada exitosamente
          content:
            application/json:
              schema:
                $ref: '#/components/schemas/TransactionResponse'
        '400':
          description: Solicitud inválida (ej: fondos insuficientes, datos inválidos)
        '404':
          description: Cuenta no encontrada
        '429':
          description: Límite de tasa excedido
        '500':
          description: Error interno del servidor (ej: fallo en la Saga)
        '503':
          description: Servicio no disponible (ej: fallo en la replicación entre regiones)

  /accounts/{accountId}/balance:
    get:
      tags:
        - Account Management
      summary: Consultar el saldo de una cuenta
      description: |
        Consulta el saldo actual de una cuenta con consistencia eventual. Este endpoint
        implementa el modelo de lectura del patrón CQRS para optimizar el rendimiento.

        **Consistencia de Datos:**
        - El saldo retornado puede estar ligeramente desactualizado (stale reads) dentro de la misma región,
          con un staleness máximo de 30s.
        - Para operaciones que requieren consistencia fuerte (ej: transacciones), se debe usar el endpoint
          de transacciones en lugar de este endpoint.

        **Tácticas de Resiliencia:**
        - **Cache:** Los saldos se cachean con una TTL de 10s para reducir la carga en la base de datos.
        - **Circuit Breaker:** Protege contra fallos en la base de datos.
        - **Bulkhead:** Aísla las consultas de saldo para evitar afectar otras operaciones.

        **Preguntas para completar la definición:**
        1. ¿Qué headers deben incluirse para identificar la región del cliente y el nivel de consistencia requerido?
        2. ¿Cómo manejarías las consultas desde regiones no primarias para minimizar la latencia?
        3. ¿Qué estrategias de caché implementarías para garantizar que los saldos no estén muy desactualizados?
        4. ¿Cómo integrarías este endpoint con el modelo de escritura de CQRS para garantizar consistencia eventual?
        5. ¿Qué métricas expondrías para monitorear la frescura de los datos y el rendimiento de las consultas?
      operationId: getAccountBalance
      parameters:
        - name: accountId
          in: path
          description: Identificador de la cuenta
          required: true
          schema:
            type: string
            format: uuid
            example: "123e4567-e89b-12d3-a456-426614174000"
        - name: X-Region-Primary
          in: header
          description: Región primaria del cliente para esta consulta
          required: true
          schema:
            type: string
            enum: ["us-east-1", "eu-west-1", "ap-southeast-1", "sa-east-1"]
        - name: consistency
          in: query
          description: |
            Nivel de consistencia requerido para la consulta:
            - eventual: Retorna datos con consistencia eventual (staleness < 30s).
            - strong: Retorna datos con consistencia fuerte (solo disponible en el endpoint global).
          required: false
          schema:
            type: string
            enum: ["eventual", "strong"]
            default: "eventual"
      responses:
        '200':
          description: Saldo consultado exitosamente
          content:
            application/json:
              schema:
                $ref: '#/components/schemas/AccountBalanceResponse'
        '404':
          description: Cuenta no encontrada
        '429':
          description: Límite de tasa excedido
        '503':
          description: Servicio no disponible (ej: fallo en la base de datos)

components:
  schemas:
    AccountCreationRequest:
      type: object
      description: |
        Datos requeridos para crear una nueva cuenta financiera.
        **Preguntas para completar el esquema:**
        1. ¿Qué campos son obligatorios para cumplir con regulaciones como KYC (Know Your Customer)?
        2. ¿Cómo estructurarías el objeto para soportar múltiples tipos de cuentas (retail, corporativa, etc.)?
        3. ¿Qué validaciones aplicarías a nivel de esquema para garantizar la integridad de los datos?
        4. ¿Cómo manejarías la información sensible (ej: PII) para cumplir con normativas como GDPR?
      properties:
        customerId:
          type: string
          format: uuid
          description: Identificador único del cliente
          example: "123e4567-e89b-12d3-a456-426614174000"
        accountType:
          type: string
          enum: ["SAVINGS", "CHECKING", "INVESTMENT", "LOAN"]
          description: Tipo de cuenta
        currency:
          type: string
          pattern: "^[A-Z]{3}$"
          description: Código ISO de la moneda (ej: USD, EUR)
          example: "USD"
        initialBalance:
          type: number
          format: double
          minimum: 0
          description: Saldo inicial de la cuenta
          example: 1000.00
      required:
        - customerId
        - accountType
        - currency

    AccountCreationResponse:
      type: object
      description: |
        Respuesta de la creación de una cuenta.
        **Preguntas para completar el esquema:**
        1. ¿Qué información adicional debería incluirse para soportar la trazabilidad y auditoría?
        2. ¿Cómo manejarías los metadatos de la región donde se creó la cuenta?
        3. ¿Qué campos incluirías para facilitar la integración con otros sistemas (ej: sistemas de fraude)?
      properties:
        accountId:
          type: string
          format: uuid
          description: Identificador único de la cuenta creada
          example: "123e4567-e89b-12d3-a456-426614174000"
        status:
          type: string
          enum: ["ACTIVE", "PENDING", "SUSPENDED"]
          description: Estado inicial de la cuenta
        createdAt:
          type: string
          format: date-time
          description: Fecha y hora de creación de la cuenta
        region:
          type: string
          enum: ["us-east-1", "eu-west-1", "ap-southeast-1", "sa-east-1"]
          description: Región donde se creó la cuenta
      required:
        - accountId
        - status
        - createdAt
        - region

    TransactionRequest:
      type: object
      description: |
        Datos requeridos para procesar una transacción financiera.
        **Preguntas para completar el esquema:**
        1. ¿Qué campos son obligatorios para cumplir con regulaciones como AML (Anti-Money Laundering)?
        2. ¿Cómo estructurarías el objeto para soportar múltiples tipos de transacciones (transferencia, pago, retiro)?
        3. ¿Qué validaciones aplicarías para garantizar que la transacción es válida antes de procesarla?
        4. ¿Cómo manejarías la información de referencia para idempotencia y trazabilidad?
      properties:
        transactionId:
          type: string
          format: uuid
          description: Identificador único de la transacción para idempotencia
          example: "123e4567-e89b-12d3-a456-426614174000"
        type:
          type: string
          enum: ["TRANSFER", "DEPOSIT", "WITHDRAWAL", "PAYMENT"]
          description: Tipo de transacción
        amount:
          type: number
          format: double
          minimum: 0.01
          description: Monto de la transacción
          example: 150.75
        currency:
          type: string
          pattern: "^[A-Z]{3}$"
          description: Código ISO de la moneda
          example: "USD"
        destinationAccountId:
          type: string
          format: uuid
          description: Identificador de la cuenta destino (requerido para transferencias)
          example: "123e4567-e89b-12d3-a456-426614174001"
        reference:
          type: string
          maxLength: 255
          description: Referencia adicional para la transacción (ej: número de factura)
      required:
        - transactionId
        - type
        - amount
        - currency

    TransactionResponse:
      type: object
      description: |
        Respuesta del procesamiento de una transacción.
        **Preguntas para completar el esquema:**
        1. ¿Qué información adicional debería incluirse para soportar la trazabilidad y auditoría?
        2. ¿Cómo manejarías los metadatos de la región donde se procesó la transacción?
        3. ¿Qué campos incluirías para indicar el estado de la Saga (ej: pasos completados, pasos pendientes)?
        4. ¿Cómo representarías los errores o compensaciones en caso de fallo en algún paso de la Saga?
      properties:
        transactionId:
          type: string
          format: uuid
          description: Identificador único de la transacción
          example: "123e4567-e89b-12d3-a456-426614174000"
        status:
          type: string
          enum: ["COMPLETED", "PENDING", "FAILED", "COMPENSATED"]
          description: Estado final de la transacción
        processedAt:
          type: string
          format: date-time
          description: Fecha y hora de procesamiento de la transacción
        region:
          type: string
          enum: ["us-east-1", "eu-west-1", "ap-southeast-1", "sa-east-1"]
          description: Región donde se procesó la transacción
        sagaStatus:
          type: object
          description: Estado de los pasos de la Saga
          properties:
            stepsCompleted:
              type: array
              items:
                type: string
                enum: ["VALIDATE", "RESERVE_FUNDS", "PROCESS", "REPLICATE", "NOTIFY"]
              description: Pasos de la Saga completados exitosamente
            stepsPending:
              type: array
              items:
                type: string
                enum: ["VALIDATE", "RESERVE_FUNDS", "PROCESS", "REPLICATE", "NOTIFY"]
              description: Pasos de la Saga pendientes
            compensations:
              type: array
              items:
                type: object
                properties:
                  step:
                    type: string
                    enum: ["VALIDATE", "RESERVE_FUNDS", "PROCESS", "REPLICATE", "NOTIFY"]
                    description: Paso que requirió compensación
                  action:
                    type: string
                    description: Acción de compensación realizada
                  timestamp:
                    type: string
                    format: date-time
                    description: Fecha y hora de la compensación
      required:
        - transactionId
        - status
        - processedAt
        - region

    AccountBalanceResponse:
      type: object
      description: |
        Respuesta de la consulta de saldo de una cuenta.
        **Preguntas para completar el esquema:**
        1. ¿Cómo representarías el saldo en múltiples monedas si la cuenta es multidivisa?
        2. ¿Qué información adicional incluirías para indicar la frescura de los datos (ej: timestamp de la última actualización)?
        3. ¿Cómo manejarías los saldos bloqueados o reservados en transacciones pendientes?
        4. ¿Qué metadatos incluirías para soportar auditoría y trazabilidad?
      properties:
        accountId:
          type: string
          format: uuid
          description: Identificador único de la cuenta
          example: "123e4567-e89b-12d3-a456-426614174000"
        balance:
          type: number
          format: double
          description: Saldo disponible de la cuenta
          example: 1500.75
        currency:
          type: string
          pattern: "^[A-Z]{3}$"
          description: Código ISO de la moneda
          example: "USD"
        lastUpdated:
          type: string
          format: date-time
          description: Fecha y hora de la última actualización del saldo
        region:
          type: string
          enum: ["us-east-1", "eu-west-1", "ap-southeast-1", "sa-east-1"]
          description: Región donde se consultó el saldo
      required:
        - accountId
        - balance
        - currency
        - lastUpdated
        - region

// === ARCHIVO: poc/README.md ===
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

// === ARCHIVO: poc/CircuitBreakerConfig.java ===
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
```
