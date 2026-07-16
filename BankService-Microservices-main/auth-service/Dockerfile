- name: Check Auth Service Target Folder
  run: |
    ls -la BankService-Microservices-main/auth-service
    ls -la BankService-Microservices-main/auth-service/target
    
FROM eclipse-temurin:17-jdk

WORKDIR /app

COPY target/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java","-jar","app.jar"]
