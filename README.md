# Asignador de Tareas 📋

Una API REST desarrollada en **Spring Boot** para la gestión y asignación automática de personas a grupos de trabajo. El sistema permite organizar personas en grupos de manera eficiente, evitando asignaciones duplicadas.

## 🚀 Características

- **Gestión de Personas**: CRUD completo para administrar personas en el sistema
- **Asignación Inteligente**: Sistema que previene asignaciones duplicadas
- **Validación de Estado**: Control del estado de asignación de cada persona
- **API RESTful**: Endpoints bien estructurados siguiendo las mejores prácticas
- **Manejo de Excepciones**: Sistema robusto de manejo de errores personalizado
- **Base de Datos**: Persistencia con PostgreSQL usando JPA/Hibernate

## 🛠️ Tecnologías Utilizadas

- **Java 17**
- **Spring Boot 3.x**
- **Spring Data JPA**
- **PostgreSQL**
- **Gradle** (Build tool)

## 📁 Estructura del Proyecto

```
src/main/java/com/damian/asignacion/asignador_tareas/
├── controller/          # Controladores REST
├── service/            # Lógica de negocio
├── modelo/             # Entidades JPA
├── persistencia/       # Repositorios
└── exception/          # Excepciones personalizadas
```



## 📋 API Endpoints

### Personas

| Método | Endpoint | Descripción |
|--------|----------|-------------|
| GET | `/persona` | Listar todas las personas |
| POST | `/persona` | Crear nueva persona |
| GET | `/persona/{id}` | Obtener persona por ID |
| PUT | `/persona/{id}` | Actualizar persona |
| DELETE | `/persona/{id}` | Eliminar persona |

### Asignación de Grupos

| Método | Endpoint | Descripción |
|--------|----------|-------------|
| POST | `/persona/{id1}/asignar/{id2}` | Asignar personas a un grupo |

## ⚠️ Manejo de Errores

El sistema incluye excepciones personalizadas:

- **`PersonaNoEncontradaException`**: Cuando no se encuentra una persona por ID
- **`PersonaYaAsignadaException`**: Cuando se intenta asignar una persona ya asignada
- **Códigos HTTP apropiados**: 404, 409, 400, etc.

## 📊 Modelo de Datos

### Persona
```java
- Long id
- String nombre
- boolean fueAsignado
// ... otros atributos
```

## 🔄 Estados de Asignación

- **No Asignado**: Persona disponible para asignación
- **Asignado**: Persona ya asignada a un grupo

## 📈 Funcionalidades Clave

1. **Validación de Asignación**: Previene asignaciones duplicadas
2. **Control de Estado**: Seguimiento del estado de cada persona
3. **API RESTful**: Interfaz clara y consistente
4. **Persistencia Robusta**: Uso de JPA para manejo de datos
5. **Manejo de Errores**: Respuestas HTTP apropiadas


