FROM eclipse-temurin:21-jdk as build

# Definir o diretório de trabalho
WORKDIR /app

# Copiar o código fonte
COPY . .

# Dar permissão de execução ao mvnw
RUN chmod +x ./mvnw

# Construir o projeto
RUN ./mvnw clean package -DskipTests -Pprod

# Usar uma imagem mais leve para o runtime
FROM eclipse-temurin:21-jre

WORKDIR /app

# Copiar o JAR gerado
COPY --from=build /app/target/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar", "--spring.profiles.active=prod"]
