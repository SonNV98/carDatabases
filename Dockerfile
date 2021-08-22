FROM openjdk:8-jdk-alpine
VOLUME /tmp
EXPOSE 8081
COPY target/carDatabase-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-Dspring.profiles.active=container","-jar","/app.jar"]