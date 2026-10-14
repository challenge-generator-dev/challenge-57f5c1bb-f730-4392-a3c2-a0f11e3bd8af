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