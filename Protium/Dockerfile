FROM openjdk:11-jdk-slim
WORKDIR /app
COPY . /app
RUN ./gradlew build
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "build/libs/my-app.jar"]
