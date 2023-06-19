# Dockerfile for microservicecloud-provider-dept-8001
FROM openjdk:8
VOLUME /tmp
COPY ./target/classes/com/will/springcloud/api/ /app/
COPY ./target/classes/application.yml /app/
COPY ./target/classes/mybatis/ /app/mybatis/
ENTRYPOINT ["java","-cp","app:app/lib/*","com.will.springcloud.api.DeptProvider8001_App"]
