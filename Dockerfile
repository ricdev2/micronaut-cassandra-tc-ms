FROM openjdk:8u171-alpine3.7
RUN apk --no-cache add curl
COPY target/micronaut-cassandra-tc-ms*.jar micronaut-cassandra-tc-ms.jar
CMD java ${JAVA_OPTS} -jar micronaut-cassandra-tc-ms.jar