# Newinntech Project

Este proyecto es una aplicación Spring Boot para gestionar candidatos y votos.

## Requisitos previos

Antes de comenzar, asegúrate de tener instalados los siguientes programas:

- [Java Development Kit (JDK) 17 o superior](https://www.oracle.com/java/technologies/javase-jdk17-downloads.html)
- [IntelliJ IDEA](https://www.jetbrains.com/idea/download/)
- [Gradle](https://gradle.org/install/) (opcional, ya que el proyecto incluye el wrapper de Gradle)

## Configuración del proyecto

Sigue estos pasos para configurar y ejecutar el proyecto en IntelliJ IDEA:

1. **Clonar el repositorio**

   Clona el repositorio en tu máquina local usando Git:

   ```sh
   git clone https://github.com/tu-usuario/newinntech.git
   cd newinntech
   ```

2. **Abrir el proyecto en IntelliJ IDEA**

Abre IntelliJ IDEA.
Selecciona File > Open... y navega hasta el directorio donde clonaste el repositorio.
Selecciona el directorio del proyecto (newinntech) y haz clic en OK.

3. **Importar el proyecto como un proyecto Gradle**

IntelliJ IDEA debería detectar automáticamente que el proyecto usa Gradle y te pedirá que lo importes. Si no es así, sigue estos pasos:

En la ventana de Project, haz clic derecho en el archivo build.gradle y selecciona Import Gradle Project.

Asegúrate de que la opción Use auto-import esté seleccionada para que IntelliJ IDEA actualice automáticamente las dependencias cuando cambie el archivo build.gradle.

4. **Configurar la variable de entorno JAVA_HOME**

Asegúrate de que la variable de entorno JAVA_HOME esté configurada correctamente y apunte a tu instalación de JDK. Puedes verificar esto ejecutando el siguiente comando en la terminal:
```
echo %JAVA_HOME%
```
Debería mostrar la ruta a tu instalación de JDK.

5. **Configurar la base de datos**

Asegúrate de que PostgreSQL esté instalado y en ejecución. Luego, crea una base de datos llamada pruebarelaciones5 y configura las credenciales en el archivo application.properties

```
spring.datasource.url=jdbc:postgresql://127.0.0.1:5432/pruebarelaciones5 //nombre de la base de datos
spring.datasource.username=postgres
spring.datasource.password= //pasword de postgres
```

6. **Ejecutar la aplicación - PUERTO POR DEFECTO 8081**
En la ventana de Project, navega hasta NewinntechApplication.java.
Haz clic derecho en el archivo NewinntechApplication.java y selecciona Run 'NewinntechApplication'.
Esto iniciará tu aplicación Spring Boot en el puerto configurado (por defecto, 8081).

## Uso de API

Puede encontrar en el archivo newinntech.postman_collection para realizar los consumos de la APIs directamente en Postman.

### Importar la colección de Postman

1. Abre Postman.
2. Haz clic en el botón Import en la esquina superior izquierda.
3. Selecciona la pestaña Upload Files.
4. Navega hasta el archivo newinntech.postman_collection.json y selecciónalo.
5. Haz clic en Import.
6. **En Autorizaciones, en Auth Type selecciona Basic Auth y en Username y Password coloca user y password respectivamente.**

### La API expone los siguientes endpoints:

**Voters (Votantes):**
- GET /api/voters: Obtiene la lista de votantes.
- GET /api/voters/{id}: Obtiene un votante por su ID.
- POST /api/voters: Crea un nuevo votante.
- DELETE /api/voters/{id}: Elimina un votante por su ID.

**Candidates (candidatos):**
- GET /api/candidates: Obtiene la lista de candidatos.
- GET /api/candidates/{id}: Obtiene un candidato por su ID.
- POST /api/candidates: Crea un nuevo candidato.
- DELETE /api/candidates/{id}: Elimina un candidato por su ID.


**Votes (conteo de Votos):**
- GET /api/votes: Obtiene la lista de votos.
- GET /api/votes/{id}: Obtiene un voto por su ID.
- POST /api/votes: Crea un nuevo voto.
- DELETE /api/votes/{id}: Elimina un voto por su ID.

### Implementar Swagger

1. Agregar las dependencias de Swagger en tu archivo build.gradle:
```
dependencies {
    implementation 'org.springdoc:springdoc-openapi-ui:1.6.14'
    implementation 'org.springdoc:springdoc-openapi-data-rest:1.6.14'
    implementation 'org.springdoc:springdoc-openapi-security:1.6.14'
}
```
2. Ejecutar la aplicación:

Ejecuta tu aplicación Spring Boot como lo haces normalmente. Swagger estará disponible en la URL http://localhost:8081/swagger-ui.html.

3. Verificar la documentación de la API:

Abre tu navegador y navega a http://localhost:8081/swagger-ui.html. Deberías ver la interfaz de Swagger UI con la documentación de tu API.

## Arquitectura por Capas

El proyecto sigue una arquitectura en capas, donde cada una tiene una responsabilidad específica:

### 1. Capa de Entidades (Entities)
- **Descripción:**  
  Las entidades representan las tablas de la base de datos y están mapeadas mediante **JPA/Hibernate**.
- **Ejemplo:**
   - `VoterEntity`: Representa un votante y contiene propiedades como `id`, `email`, `name` y `hasVoted`.
   - `CandidateEntity`: Representa un candidato con propiedades como `id`, `name`, `party` y `votes`.
   - `VoteEntity`: Representa un voto, que se relaciona con un votante y un candidato (a través de relaciones `@ManyToOne`).

### 2. Capa de Modelos (Models)
- **Descripción:**  
  Los modelos son objetos de transferencia de datos que se usan internamente para representar la información y trabajar con la lógica de negocio.
- **Ejemplo:**
   - `VoterModel`: Similar a `VoterEntity`, pero puede contener solo la información necesaria para la lógica de negocio o presentación.
   - `CandidateModel`: Similar a `CandidateEntity`, con la información relevante del candidato.
   - `VoteModel`: Se utiliza para representar un voto a nivel de lógica, incluyendo referencias al votante y al candidato.

### 3. Capa de Contratos (Contracts)
- **Descripción:**  
  Los contratos definen el formato de los datos que se reciben (Request) y se envían (Response) a través de la API REST.
- **Ejemplo:**
   - `VoterRequest` y `VoterResponse`: Objeto de entrada y salida para operaciones relacionadas con votantes.
   - `CandidateRequest` y `CandidateResponse`: Para las operaciones de candidatos.
   - `VoteRequest` y `VoteResponse`: Para emitir votos y retornar la información del voto emitido.

### 4. Capa de Mapeo (Mappers) e Interfaces
- **Descripción:**  
  Se utiliza **MapStruct** para transformar objetos entre las diferentes capas (por ejemplo, de Request a Model, de Model a Entity, o de Entity a Response).
- **Ejemplo:**
  
   - `VoteInterface` y `VoteMapper`: Definen los métodos para convertir entre `VoteRequest`, `VoteModel`, `VoteEntity` y `VoteResponse`.

### 5. Capa de Repositorios (Repositories)
- **Descripción:**  
  Esta capa se encarga de la comunicación con la base de datos. Utiliza **Spring Data JPA** para definir métodos de consulta, persistencia, actualización y eliminación de datos.
- **Ejemplo:**
   - `VoterRepository`: Extiende de `JpaRepository` para operaciones CRUD sobre votantes.
   - `CandidateRepository`: Para candidatos.
   - `VoteRepository`: Para votos, incluye consultas personalizadas (por ejemplo, para agrupar votos y generar estadísticas).

### 6. Capa de Servicios (Services)
- **Descripción:**  
  Contiene la lógica de negocio del sistema. Aquí se realizan validaciones, se coordinan llamadas a repositorios y se aplican reglas de negocio (por ejemplo, verificar que un votante no haya votado previamente, actualizar el conteo de votos, etc.).
- **Ejemplo:**
   - `VoterService`: Gestión de votantes (registro, obtención, eliminación).
   - `CandidateService`: Gestión de candidatos.
   - `VoteService`:
      - **Emisión de Voto:** Valida el votante y candidato, persiste el voto y actualiza los contadores (flag de votado en el votante y conteo de votos en el candidato).
      - **Estadísticas:** Incluye métodos para obtener estadísticas de la votación, como el total de votos por candidato, porcentaje de votos y total de votantes que han votado.

### 7. Capa de Controladores (Controllers)
- **Descripción:**  
  Expone la API REST para que los clientes puedan interactuar con el sistema. Los controladores reciben las solicitudes HTTP, invocan los servicios correspondientes y devuelven respuestas en formato JSON.
- **Ejemplo:**
   - `VoterController`: Endpoints para gestionar votantes.
   - `CandidateController`: Endpoints para gestionar candidatos.
   - `VoteController`:
      - **POST /votes:** Emite un voto.
      - **GET /votes:** Obtiene todos los votos.
      - **GET /votes/statistics:** Retorna las estadísticas de la votación.
