# AerolineaAPI ✈️

API REST backend para la gestión de vuelos y pasajeros de una aerolínea, construida con Spring Boot y PostgreSQL.

## Tecnologías

- Java 17
- Spring Boot 3.2.5
- Spring Data JPA / Hibernate
- PostgreSQL
- Maven

## Estructura del proyecto

```
src/
└── main/
    ├── java/com/tuapp/aerolineaapi/
    │   ├── Main.java
    │   ├── controller/
    │   │   ├── VueloController.java
    │   │   └── PasajeroController.java
    │   ├── service/
    │   │   ├── VueloService.java
    │   │   └── PasajeroService.java
    │   ├── repository/
    │   │   ├── VueloRepository.java
    │   │   └── PasajeroRepository.java
    │   └── model/
    │       ├── Vuelo.java
    │       ├── Pasajero.java
    │       └── EstadoVuelo.java
    └── resources/
        └── application.properties
```

## Configuración

### Base de datos

Crear la base de datos en PostgreSQL antes de ejecutar:

```sql
CREATE DATABASE aerolineaapi;
```

### application.properties

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/aerolineaapi
spring.datasource.username=postgres
spring.datasource.password=tu_contraseña
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
```

## Cómo ejecutar

1. Clonar el repositorio
2. Crear la base de datos `aerolineaapi` en PostgreSQL
3. Configurar las credenciales en `application.properties`
4. Ejecutar la clase `Main.java`
5. El servidor inicia en `http://localhost:8080`

Hibernate crea las tablas automáticamente al arrancar la aplicación.

## Endpoints disponibles

### Vuelos

| Método | Ruta | Descripción |
|--------|------|-------------|
| GET | `/vuelos` | Retorna la lista de todos los vuelos |

### Pasajeros

| Método | Ruta | Descripción |
|--------|------|-------------|
| GET | `/pasajeros` | Retorna la lista de todos los pasajeros |

## Modelo de datos

### Vuelo

| Campo | Tipo | Descripción |
|-------|------|-------------|
| id | Long | Identificador único generado automáticamente |
| origen | String | Ciudad de origen |
| destino | String | Ciudad de destino |
| fechaHora | LocalDateTime | Fecha y hora del vuelo |
| estado | EstadoVuelo | Estado actual del vuelo |

### Pasajero

| Campo | Tipo | Descripción |
|-------|------|-------------|
| id | Long | Identificador único generado automáticamente |
| nombre | String | Nombre del pasajero |
| apellido | String | Apellido del pasajero |
| documento | String | Número de documento |
| email | String | Correo electrónico |

### EstadoVuelo (enum)

```
PROGRAMADO · EN_VUELO · ATERRIZADO · CANCELADO
```

## Próximas sesiones


---

Proyecto desarrollado en el módulo Spring Boot — Generation Colombia · TIFC2DEV
