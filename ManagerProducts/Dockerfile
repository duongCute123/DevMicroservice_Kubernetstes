FROM eclipse-temurin:17-jre-focal
VOLUME /tmp
ARG JAVA_OPTS
ENV JAVA_OPTS=$JAVA_OPTS
COPY target/ManagerProducts-0.0.1-SNAPSHOT.jar microservice.jar
EXPOSE 8801
ENTRYPOINT exec java $JAVA_OPTS -jar microservice.jar
# For Spring-Boot project, use the entrypoint below to reduce Tomcat startup time.
#ENTRYPOINT exec java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar microservice.jar
