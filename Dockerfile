FROM eclipse-temurin:17-jdk-jammy
ADD target/pfma-0.0.1-SNAPSHOT.jar pfma-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar","pfma-0.0.1-SNAPSHOT.jar"]
EXPOSE 8080