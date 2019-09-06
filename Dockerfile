FROM openjdk:8-jre-alpine
ADD ./target/*.jar /app/app.jar
WORKDIR /app
EXPOSE 8888
CMD java -jar app.jar
