# Stage 1: Build the application
FROM openjdk:8-jdk-alpine

RUN echo ${JAVA_HOME}

ARG WORKING_DIR=/ysree

RUN mkdir -p ${WORKING_DIR} && chown 1000 ${WORKING_DIR}

COPY build/libs/book-service-0.0.1-SNAPSHOT.jar /ysree

WORKDIR "/ysree"

#RUN ls /ysree

ENTRYPOINT ["java","-jar","book-service-0.0.1-SNAPSHOT.jar"]
