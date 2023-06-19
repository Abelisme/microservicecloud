# Dockerfile for microservicecloud-consumer-dept-80
FROM openjdk:8
VOLUME /tmp
COPY ./target/classes/com/will/springcloud/api/ /app/
COPY ./target/classes/application.yml /app/
COPY ./target/classes/static/js/ /app/static/js/
COPY ./target/classes/templates/ /app/templates/
ENTRYPOINT ["java","-cp","app:app/lib/*","com.will.springcloud.api.DeptConsumer80_App"]
