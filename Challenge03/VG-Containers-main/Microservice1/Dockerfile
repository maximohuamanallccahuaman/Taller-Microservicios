FROM openjdk:11
VOLUME /tmp
EXPOSE 8081
ADD ./target/Microservice1-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]