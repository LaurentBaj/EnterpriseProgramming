
FROM maven:3.6-jdk-11 as builder
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn -B  package

# This version of alpine became unavailable though I had managed to build it earlier 
# FROM adoptopenjdk/openjdk:18-jdk-alpine3.14
FROM adoptopenjdk/openjdk11:alpine-slim
COPY --from=builder /app/target/*.jar /app/application.jar
ENTRYPOINT ["java","-jar","/app/application.jar"]
