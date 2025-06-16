FROM openjdk:18
WORKDIR /app
COPY ./target/Module21-0.0.1-SNAPSHOT.jar /app
EXPOSE 8080
CMD ["java", "-jar", "Module21-0.0.1-SNAPSHOT.jar"]
