# Usar uma imagem oficial do JDK 21 para o estágio de build
FROM eclipse-temurin:21-jdk as build

# Definir o diretório de trabalho
WORKDIR /app

# Copiar o código fonte para o container
COPY . .

# Construir o projeto com o perfil 'prod'
RUN ./mvnw clean package -DskipTests -Pprod

# Usar uma imagem mais leve com JRE do Java 21 para o runtime
FROM eclipse-temurin:21-jre

# Definir o diretório de trabalho
WORKDIR /app

# Copiar o JAR gerado do estágio de build
COPY --from=build /app/target/*.jar app.jar

# Expor a porta
EXPOSE 8080

# Comando para iniciar o aplicativo
ENTRYPOINT ["java", "-jar", "app.jar"]
