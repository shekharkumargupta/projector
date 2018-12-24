FROM openjdk:8
ADD target/projector.jar projector.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","projector.jar"]