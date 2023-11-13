# Use an official Maven runtime as a parent image
FROM maven:3.8.5-openjdk-17 AS build

# Set the working directory to /app
WORKDIR /app

# Copy the pom.xml and src directories to the container
COPY . .

# Build the project with Maven
#RUN mvn -B package --file pom.xml
# RUN gradle clean build jar -x test
RUN chmod +x gradlew
RUN ./gradlew build

# Use an official OpenJDK runtime as a parent image
FROM openjdk:21-ea-17-jdk

# Set the working directory to /app
WORKDIR /app

EXPOSE 8080

# Copy the built JAR file from the previous stage to the container
#COPY --from=build /app/target/wmsmbsnftp-0.0.1-SNAPSHOT.jar .
COPY --from=build /app/build/libs/MovieBooking-0.0.1-SNAPSHOT.jar .

RUN ls -lR
# Run the JAR file
CMD ["java", "-jar", "MovieBooking-0.0.1-SNAPSHOT.jar"]