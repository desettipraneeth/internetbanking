FROM openjdk
WORKDIR /app
COPY . .
RUN ./mvnw clean package -DskipTests
EXPOSE 8761
ENTRYPOINT [ "java","-jar","target/serviceregistry.jar" ]