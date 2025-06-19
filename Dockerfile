# Etapa de build
FROM maven:3.9.6-eclipse-temurin-21 AS build
WORKDIR /app

# Copia apenas os arquivos necessários para o build
COPY pom.xml .
COPY src ./src

# Faz o build do projeto, pulando os testes
RUN mvn clean package -DskipTests

# Etapa de execução
FROM eclipse-temurin:21.0.6_7-jre-ubi9-minimal
COPY --from=build /app/target/*.jar /myapp.jar

# Exposição da porta
EXPOSE 8080

# Comando padrão para rodar a aplicação
CMD ["java", "-jar", "/myapp.jar"]
