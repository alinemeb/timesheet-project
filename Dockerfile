# Utilise eclipse-temurin (Adoptium) – image officielle et maintenue en 2026
FROM eclipse-temurin:17-jdk

WORKDIR /app

# Copie le JAR généré par Maven (assure-toi que mvn package a été lancé avant)
COPY target/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]
