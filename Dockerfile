FROM openjdk:17-jdk-slim
LABEL authors="damim"

WORKDIR /app

COPY gradlew .
COPY gradle gradle
COPY build.gradle .
COPY settings.gradle .
COPY src src

RUN chmod +x ./gradlew
RUN ./gradlew build -x test

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "build/libs/asignador-tareas-0.0.1-SNAPSHOT.jar"]
