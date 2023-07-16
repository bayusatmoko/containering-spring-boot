FROM maven:3-openjdk-17-slim as BUILDER
ARG VERSION=0.0.1-SNAPSHOT
WORKDIR /build
COPY pom.xml /build/
COPY ExploreCalifornia.json /build/
COPY src /build/src/

RUN mvn clean package
COPY target/exploremsboot-${VERSION}.jar target/application.jar

FROM eclipse-temurin:17-jre-alpine
WORKDIR /app/

COPY --from=BUILDER /build/target/application.jar /app/
COPY ExploreCalifornia.json /app/
CMD java -jar /app/application.jar