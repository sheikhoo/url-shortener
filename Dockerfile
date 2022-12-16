FROM maven:3.6.3-jdk-8 AS builder
ADD . /project
WORKDIR /project
RUN mvn package -X
FROM openjdk:8-jre

COPY --from=builder /project/target/url_shortener-1.0.0.war  /app/url_shortener.war
ENTRYPOINT ["java","-jar","/app/url_shortener.war"]