# Stage 1: Build the application
FROM openjdk:8-jdk-alpine

RUN echo ${JAVA_HOME}

ARG WORKING_DIR=/opt/ysree

RUN mkdir -p ${WORKING_DIR} && chown 1000 ${WORKING_DIR}

RUN cd ${WORKING_DIR}

RUN echo pwd

COPY build/libs/book-service-0.0.1-SNAPSHOT.jar .

RUN echo ls ${WORKING_DIR}

ENTRYPOINT ["java","-jar","book-service-0.0.1-SNAPSHOT.jar"]