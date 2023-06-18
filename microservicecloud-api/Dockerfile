#
# maven
#
FROM maven:3.6.0-jdk-8-slim as build
#COPY src /home/microservicecloud/microservicecloud-api/src
#COPY pom.xml /home/microservicecloud/microservicecloud-api
#WORKDIR /home/microservicecloud/microservicecloud-api
#RUN mvn -f clean
#RUN mvn -f clean package
#RUN ["/bin/bash", "-c", "mvn install"]
WORKDIR /app
# Copy the parent project's pom.xml and build all modules
COPY pom.xml .
COPY microservicecloud-api/pom.xml microservicecloud-api/
COPY microservicecloud-api/src microservicecloud-api/src
RUN mvn -f pom.xml clean package -DskipTests
# Copy the entire project and build the modules
COPY . .
RUN mvn -f microservicecloud-api/pom.xml clean package -DskipTests
#RUN mvn clean install

FROM openjdk:8
WORKDIR /app/microservicecloud-api
ADD --from=build /target/microservicecloud.jar microservicecloud.jar
#ENTRYPOINT ["java", "-jar", "microservicecloud.jar"]