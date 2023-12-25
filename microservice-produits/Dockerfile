#FROM openjdk:21

#COPY ./microservice-produits/target/microservice-produits.jar microservice-produits.jar

#EXPOSE 9001

#ENTRYPOINT ["java", "-jar", "/microservice-produits.jar"]

FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app

COPY .mvn/ .mvn
COPY mvnw pom.xml ./

# Install dos2unix to convert the line endings to unix format
RUN apk add --no-cache dos2unix
# Make the mvnw script executable
RUN dos2unix mvnw

RUN ./mvnw dependency:go-offline

COPY src ./src

EXPOSE 5013
CMD ./mvnw spring-boot:run