FROM gradle:8.1.1-jdk17

WORKDIR /app
COPY . /app
RUN chmod +x ./gradlew && ./gradlew build 
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app/build/libs/web-0.0.1-SNAPSHOT.jar"]