FROM openjdk:21
COPY target/luxmed-1.0.jar luxmed-1.0.jar
ENTRYPOINT ["java","-jar","/luxmed-1.0.jar"]