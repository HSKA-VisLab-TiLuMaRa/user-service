FROM java:8
ADD /target/*.jar user-service.jar
ENTRYPOINT ["java","-jar","user-service.jar"]