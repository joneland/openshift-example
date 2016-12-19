FROM anapsix/alpine-java
COPY target/project.jar project.jar

EXPOSE 4000

CMD ["java", "-jar", "project.jar"]