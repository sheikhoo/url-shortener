FROM maven:3.6.3-jdk-8 AS builder
ADD . /app
WORKDIR /app
#RUN --mount=type=cache,target=/root/.m2 mvn -f /app/pom.xml clean package -DskipTests
RUN mvn -f /app/pom.xml clean package -DskipTests
FROM openjdk:8-jre-slim

COPY --from=builder /app/target/url_shortener-1.0.0.jar  url_shortener.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","url_shortener.jar"]