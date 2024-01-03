FROM gradle:8.1.1-jdk17
VOLUME /tmp
COPY gradle/*.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
EXPOSE 8080