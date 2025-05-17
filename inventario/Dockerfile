# Usar una imagen base de Java 17
FROM openjdk:17-jdk-slim

# Establecer el directorio de trabajo
WORKDIR /app

# Copiar el archivo JAR generado
COPY target/inventario-0.0.1-SNAPSHOT.jar app.jar

# Exponer el puerto de la aplicación (por defecto 8080)
EXPOSE 8080

# Comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "app.jar"]