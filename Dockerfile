FROM openjdk:11-jdk-slim
WORKDIR /app
COPY . /app
RUN ./gradlew build
ENTRYPOINT ["java","-jar","build/libs/protium.jar"]
