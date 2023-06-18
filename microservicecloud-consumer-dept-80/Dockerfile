# Build stage
FROM maven:3.6.0-jdk-8-slim AS build
WORKDIR /app/

# Copy the parent project's pom.xml and build all modules
COPY pom.xml .
COPY microservicecloud-consumer-dept-80/pom.xml microservicecloud-consumer-dept-80/
COPY microservicecloud-consumer-dept-80/src microservicecloud-consumer-dept-80/src
#COPY microservicecloud-consumer-dept-80/pom.xml microservicecloud-consumer-dept-80/
#RUN mvn -f pom.xml clean package -DskipTests

# Copy the entire project and build the modules
COPY . .
RUN mvn -f microservicecloud-consumer-dept-80/pom.xml clean package -DskipTests

# Runtime stage
FROM openjdk:8
WORKDIR /app

# Copy the built JAR files from the build stage
#COPY --from=build /app/microservicecloud-consumer-dept-80/target/microservicecloud-consumer-dept-80.jar .

# Set the command to run the application
CMD ["java", "-jar", "microservicecloud-consumer-dept-80.jar"]