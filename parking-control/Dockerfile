FROM openjdk:11
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} parking-control.jar
EXPOSE 8080
ADD target/parking-control.jar parking-control.jar
ENTRYPOINT ["java","-jar","/parking-control.jar"]