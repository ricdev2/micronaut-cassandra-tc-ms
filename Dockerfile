FROM openjdk:8u171-alpine3.7
RUN apk --no-cache add curl
EXPOSE 8086
COPY target/micronaut-cassandra-tc-ms*.jar micronaut-cassandra-tc-ms.jar
CMD java -jar micronaut-cassandra-tc-ms*.jar