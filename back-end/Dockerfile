FROM openjdk:17
VOLUME /tmp
COPY target/pocapp-backend-services.jar pocapp-backend-services.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/pocapp-backend-services"]