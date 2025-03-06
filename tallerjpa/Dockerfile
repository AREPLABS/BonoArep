FROM openjdk:17-jdk-slim

WORKDIR /app

# Copiar el JAR y el script wait-for-it
COPY target/tallerjpa-0.0.1-SNAPSHOT.jar app.jar
COPY wait-for-it.sh wait-for-it.sh
RUN chmod +x wait-for-it.sh

EXPOSE 8080

# Esperar a que mysql-db esté listo antes de iniciar la aplicación
ENTRYPOINT ["./wait-for-it.sh", "mysql-db:3306", "--", "java", "-jar", "app.jar"]
