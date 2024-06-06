FROM maven:3.9.6-eclipse-temurin-21-jammy as build
WORKDIR /app
COPY . .
RUN mvn clean package -X -DskipTests

FROM openjdk:17-jdk
WORKDIR /app

COPY --from=build /app/target/*.jar /app/wayclient-backend-0.0.1-SNAPSHOT.jar

ARG DB_URL
ARG DB_USERNAME
ARG DB_PASSWORD
ENV ENV_DB_URL=${DB_URL}
ENV ENV_DB_USERNAME=${DB_USERNAME}
ENV ENV_DB_PASSWORD=${DB_PASSWORD}

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "wayclient-backend-0.0.1-SNAPSHOT.jar"]
