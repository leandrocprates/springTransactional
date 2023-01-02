FROM openjdk:11-jre-slim
WORKDIR /app
COPY target/*.jar /app/aplicacao.jar
EXPOSE 8080
CMD java -XX:+UseContainerSupport  -Xmx512m  -jar aplicacao.jar

# docker build -t lprates/aplicacao .
# docker run -d --network=backend -e DB_HOST=mysql -p 8080:8080 lprates/aplicacao

