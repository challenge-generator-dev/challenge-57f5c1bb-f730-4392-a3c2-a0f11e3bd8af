# Diseño de Arquitectura Resiliente para Core Financiero Multi-Región

Eres el arquitecto de una institución financiera global que busca implementar un core financiero resiliente y multi-región. El objetivo es garantizar la disponibilidad y el rendimiento del sistema en caso de fallos en una o más regiones de la nube. Debes diseñar una arquitectura que combine al menos 8 patrones modernos (Serverless, CQRS, Sagas, EDA, etc.) y tácticas de resiliencia avanzadas para soportar la caída completa de una región de la nube.

## Informacion General

| Campo | Valor |
|-------|-------|
| **Tema** | Resiliencia de un core financiero multi-region |
| **Nivel** | senior-l2 |
| **Tipo** | practical |
| **Tiempo estimado** | 180 minutos |

## Fases del Reto

### Fase 0: Configuración del Proyecto

**Objetivo:** Obtener el proyecto base funcional enviando el Código Base a un asistente de IA, que lo analizará, corregirá errores y generará un ZIP listo para usar.

**Tiempo estimado:** 15-30 minutos

**Instrucciones:**

- Asegúrate de tener instalado para ejecutar el proyecto: JDK 17+, Maven 3.9+, IDE con soporte Java.
- Copia todo el contenido del campo **Código Base** de este reto — incluyendo el texto de instrucciones que aparece al inicio.
- Abre un asistente de IA (Claude en claude.ai, ChatGPT o Gemini — se recomienda Claude), pega el contenido copiado en el chat y envíalo.
- El asistente analizará los archivos, corregirá errores y generará un archivo ZIP descargable. Descárgalo y extráelo en la carpeta donde quieras trabajar.
- Ejecuta `mvn compile` en la raíz. Si no hay errores, estás listo.

**Entregable:** El proyecto compila/arranca sin errores.

<details>
<summary>Pistas de conocimiento</summary>

- Copia el Código Base completo incluyendo el texto de instrucciones al inicio — esas instrucciones le indican al asistente exactamente qué hacer con los archivos.
- Si el asistente no genera el ZIP automáticamente al terminar el análisis, escríbele: "genera el ZIP ahora".
- Si el proyecto tiene errores al arrancar, comparte el mensaje de error con el mismo asistente para que lo corrija.

</details>

### Fase 1: Análisis de Requisitos y Definición de Patrones

**Objetivo:** Identificar y analizar los requisitos arquitectónicos significativos y seleccionar los patrones de arquitectura apropiados.

**Tiempo estimado:** 45 minutos

**Instrucciones:**

- Identifica los requisitos arquitectónicos significativos (ASRs) del core financiero multi-región.
- Selecciona al menos 8 patrones de arquitectura modernos que se ajusten a los ASRs.
- Documenta las ventajas y desventajas de cada patrón seleccionado.

**Entregable:** Lista de ASRs y patrones de arquitectura seleccionados con sus ventajas y desventajas.

<details>
<summary>Pistas de conocimiento</summary>

- Considera la escalabilidad, disponibilidad, seguridad y latencia en la selección de patrones.
- Investiga patrones como Serverless, CQRS, Sagas y EDA.

</details>

### Fase 2: Diseño de la Arquitectura

**Objetivo:** Crear un diseño detallado de la arquitectura que incluya tácticas de resiliencia avanzadas.

**Tiempo estimado:** 60 minutos

**Instrucciones:**

- Diseña la arquitectura del core financiero multi-región utilizando los patrones seleccionados.
- Incorpora tácticas de resiliencia avanzadas para soportar la caída completa de una región de la nube.
- Crea diagramas de arquitectura en Mermaid o PlantUML que representen la estructura del sistema.

**Entregable:** Diagramas de arquitectura y descripción detallada del diseño.

<details>
<summary>Pistas de conocimiento</summary>

- Utiliza vistas C4 para representar la arquitectura en diferentes niveles de abstracción.
- Considera la replicación de datos, el balanceo de carga y la tolerancia a fallos en el diseño.

</details>

### Fase 3: Evaluación de Trade-offs y Documentación de Decisiones

**Objetivo:** Evaluar los trade-offs de la arquitectura diseñada y documentar las decisiones tomadas.

**Tiempo estimado:** 45 minutos

**Instrucciones:**

- Evalúa los trade-offs de la arquitectura diseñada, considerando aspectos como costo, complejidad, rendimiento y seguridad.
- Documenta las decisiones arquitectónicas en un Registro de Decisiones de Arquitectura (ADR) siguiendo el formato MADR o Nygard.
- Identifica los riesgos residuales y las estrategias para mitigarlos.

**Entregable:** Registro de Decisiones de Arquitectura (ADR) con trade-offs evaluados y riesgos residuales.

<details>
<summary>Pistas de conocimiento</summary>

- Considera el impacto de cada decisión en los ASRs y en la resiliencia del sistema.
- Documenta las razones detrás de cada decisión y las alternativas consideradas.

</details>

### Fase 4: Validación y Entrega del Diseño

**Objetivo:** Validar el diseño de la arquitectura y preparar la entrega final.

**Tiempo estimado:** 30 minutos

**Instrucciones:**

- Valida el diseño de la arquitectura contra los ASRs y las tácticas de resiliencia.
- Realiza una revisión final del diseño y corrige cualquier inconsistencia o error.
- Prepara la entrega final del diseño, incluyendo todos los diagramas, ADRs y documentación relevante.

**Entregable:** Entrega final del diseño de la arquitectura con todos los diagramas, ADRs y documentación relevante.

<details>
<summary>Pistas de conocimiento</summary>

- Realiza una revisión exhaustiva del diseño para asegurar que cumple con todos los requisitos.
- Asegúrate de que la documentación sea clara y completa.

</details>

## Dimensiones Evaluadas

- **queEs**: ¿Qué es un Registro de Decisiones de Arquitectura (ADR) y por qué es importante en este reto?
- **paraQueSirve**: ¿Para qué sirve el patrón CQRS en la arquitectura del core financiero multi-región?
- **comoSeUsa**: ¿Cómo se usa el patrón Serverless en la arquitectura diseñada?
- **erroresComunes**: ¿Cuáles son los errores comunes al implementar tácticas de resiliencia en una arquitectura multi-región?
- **queDecisionesImplica**: ¿Qué decisiones implica la selección del patrón EDA en la arquitectura del core financiero?

## Criterios de Evaluacion

- Alineación con los ASRs
- Uso justificado de patrones y herramientas frente a alternativas
- Calidad de los diagramas y del ADR con trade-offs explícitos
- Viabilidad y madurez (seguridad, observabilidad y operación realista)

## Como trabajar con un asistente de IA

Hay dos caminos, elegi uno:

- **AGENTS.md** (recomendado) — instrucciones nativas del repo. Abri esta carpeta con tu agente local (Claude Code, Cursor, Codex, Copilot, Gemini) y las carga solo. Sabe que archivos faltan y con que comando se verifica, y completa el scaffold escribiendo en disco.
- **PROMPT_MEJORA.md** — para copiar y pegar en un chat (claude.ai, ChatGPT). Devuelve un ZIP con el proyecto. Sirve si no tenes un agente en el IDE.

Ninguno de los dos resuelve las fases del reto: eso es tu trabajo.

## Verificacion

El proyecto esta listo para trabajar cuando este comando corre sin errores:

```bash
python3 -c "import glob,sys; assert glob.glob('adr/*.md') and glob.glob('diagramas/*.mmd'), 'faltan ADRs o diagramas'"
```

---

*Reto generado automaticamente por Challenge Generator - Pragma*
