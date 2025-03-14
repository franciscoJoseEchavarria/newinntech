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
spring.datasource.url=jdbc:postgresql://127.0.0.1:5432/pruebarelaciones5
spring.datasource.username=postgres
spring.datasource.password=nueva123
```

6. **Ejecutar la aplicación**

