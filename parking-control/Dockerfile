FROM openjdk:11-jre
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} parking-control.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/parking-control.jar"]