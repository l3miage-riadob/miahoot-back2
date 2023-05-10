FROM openjdk:17-jdk-alpine
COPY . /app
WORKDIR /app
RUN apk add --no-cache maven
RUN mvn package -DskipTests
EXPOSE 8080
CMD ["java", "-jar", "server/target/Example.jar"]