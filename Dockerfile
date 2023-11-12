FROM openjdk:11-jre-slim

# Add your Spring Boot JAR file
ADD target/your-spring-boot-app.jar app.jar

# Expose the port that your Spring Boot app will run on
EXPOSE 8080

# Add your PostgreSQL startup command
CMD ["sh", "-c", "docker run --name oop-course -e POSTGRES_PASSWORD=postgres -d -p 5432:5432 postgres && java -Dserver.port=$PORT -jar app.jar"]
