FROM openjdk:11-jre
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} parking-control.jar
EXPOSE 8080
ADD target/parking-control-0.0.1-SNAPSHOT.jar target/parking-control.jar
ENTRYPOINT ["java","-jar","-cp","app:app/lib/*","/parking-control.jar"]