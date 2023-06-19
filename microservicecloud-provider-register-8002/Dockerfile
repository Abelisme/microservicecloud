# Dockerfile for microservicecloud-provider-register-8002
FROM openjdk:8
VOLUME /tmp
COPY ./target/classes/com/will/springcloud/api/ /app/
COPY ./target/classes/application.yml /app/
COPY ./target/classes/mapper/ /app/mapper/
ENTRYPOINT ["java","-cp","app:app/lib/*","com.will.springcloud.api.RegisterProvider8002_App"]
