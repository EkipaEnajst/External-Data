FROM eclipse-temurin:17
WORKDIR /opt/externaldata/
RUN mkdir api
COPY ./api ./api
CMD ["ls"]
CMD ["java", "-jar", "./api/tar/externaldata-1.0-SNAPSHOT.jar"]