FROM openjdk:17
EXPOSE 8080
COPY /build/libs/phoneBookSystem-0.0.1-SNAPSHOT.jar phoneBookSystem.jar
ENTRYPOINT ["java", "-jar", "phoneBookSystem.jar"]