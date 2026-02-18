# Gestión CRUD FP - API REST (RA7)

Este proyecto consiste en la migración de una aplicación JSP tradicional a una arquitectura de microservicios utilizando **Spring Boot**, orientada a la gestión de Materias, Resultados de Aprendizaje (RA) y Criterios de Evaluación.

## 1. Estructura del Proyecto
El proyecto sigue el patrón de diseño **MVC** (Modelo-Vista-Controlador) y está organizado en los siguientes paquetes bajo `src/main/java/com/tuempresa/gestionra`:

* **`model`**: Contiene las entidades JPA (`Materia`, `Ra`, `Criterio`) que representan las tablas de la base de datos MySQL.
* **`repository`**: Interfaces que heredan de `JpaRepository` para gestionar las operaciones CRUD de forma automática.
* **`service`**: Capa de lógica de negocio que actúa como intermediaria entre los controladores y los datos.
* **`controller`**: Define los Endpoints REST que gestionan las peticiones HTTP (GET, POST, PUT, DELETE).
* **`GestionCrudApplication.java`**: Clase principal que arranca el servidor embebido Tomcat.



## 2. Endpoints de la API
La aplicación está configurada para ejecutarse en `http://localhost:8081/api`. A continuación se detallan los endpoints para la entidad **Materia**:

| Método | Endpoint | Acción |
| :--- | :--- | :--- |
| **GET** | `/materias` | Lista todas las materias almacenadas. |
| **GET** | `/materias/{id}` | Obtiene el detalle de una materia por su ID. |
| **POST** | `/materias` | Crea una nueva materia en la base de datos. |
| **PUT** | `/materias/{id}` | Actualiza los datos de una materia existente. |
| **DELETE** | `/materias/{id}` | Elimina físicamente una materia. |

*Nota: Los endpoints para `/ras` y `/criterios` siguen la misma estructura técnica.*

## 3. Ejemplos de Pruebas
Para validar el funcionamiento del sistema, se han realizado pruebas mediante **Postman**.

### Ejemplo de creación (POST)
**URL:** `http://localhost:8081/api/materias`  
**Cuerpo (JSON):**
```json
{
    "nombre": "Acceso a Datos",
    "codigo": "AD"
}
