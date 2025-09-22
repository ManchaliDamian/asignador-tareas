FROM openjdk:17-jdk-slim
LABEL authors="damim"

WORKDIR /app

# Copiar el JAR generado por Gradle
COPY build/libs/*.jar app.jar

# Exponer puerto
EXPOSE 8080

# Ejecutar aplicación
ENTRYPOINT ["java", "-jar", "app.jar"]