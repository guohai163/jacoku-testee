FROM openjdk:11 AS base

RUN mkdir -p /opt/java-agent/ && \
        curl -o /opt/java-agent/org.jacoco.agent-0.8.12-runtime.jar https://repo1.maven.org/maven2/org/jacoco/org.jacoco.agent/0.8.12/org.jacoco.agent-0.8.12-runtime.jar && \
        ln -sf /opt/java-agent/org.jacoco.agent-0.8.12-runtime.jar /opt/java-agent/org.jacoco.agent-runtime.jar

FROM maven:3.8.6-openjdk-11 AS builder

WORKDIR /opt/jacoku-testee
COPY pom.xml .
COPY src .

RUN mvn clean package

FROM base AS run

LABEL org.opencontainers.image.authors="GUOHAI.ORG"
LABEL org.opencontainers.image.source=https://github.com/guohai163/jacoku-testee


WORKDIR /opt/jacoku-testee
COPY --from=builder /opt/jacoku-testee/target/*.jar /opt/jacoku-testee/jacoku-testee.jar

EXPOSE 8081

ENTRYPOINT exec java $JAVA_OPTS  -jar /opt/jacoku-testee/jacoku-testee.jar
