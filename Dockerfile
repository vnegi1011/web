FROM gradle:8.1.1-jdk17

WORKDIR /app
COPY . /app
RUN ./gradlew build
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "build/libs/*.jar"]