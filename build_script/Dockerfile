FROM 3.8.6-openjdk-11 AS builder

WORKDIR /opt/jacoku-testee
COPY pom.xml .
COPY src .

RUN mvn clean package

FROM openjdk:openjdk AS run

WORKDIR /opt/jacoku-testee
COPY --from=builder /opt/jacoku-testee/target/*.jar /opt/jacoku-testee/jacoku-testee.jar

CMD ["java","-jar", "/opt/jacoku-testee/jacoku-testee.jar"]