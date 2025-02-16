FROM openjdk:17
LABEL authors="niitr"
EXPOSE 9090
WORKDIR /app
COPY ./target/spring-ci-cd.jar /app
ENTRYPOINT ["java","-jar", "spring-ci-cd.jar"]