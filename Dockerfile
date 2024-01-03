FROM gradle:8.1.1-jdk17
VOLUME /tmp
RUN gradle build
COPY /build/libs/*.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
EXPOSE 8080