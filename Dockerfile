FROM maven:3.6-jdk-8 AS api-smsgi-backend

RUN mkdir -p ./home/api-smsgi-backend

WORKDIR ./home/api-smsgi-backend

COPY / .

RUN mvn dependency:tree && mvn clean install

FROM adoptopenjdk/openjdk11:alpine-jre

COPY --from=api-smsgi-backend /home/api-smsgi-backend/target/*.jar api-smsgi-backend-0.0.1-SNAPSHOT.jar

CMD ["java", "-jar", "api-smsgi-backend-0.0.1-SNAPSHOT.jar"]

HEALTHCHECK --interval=25s --timeout=3s --retries=2 CMD wget --spider http://localhost:8080/
