## BUILD STACK
FROM adoptopenjdk/openjdk11:jdk-11.0.10_9-alpine 

VOLUME /tmp
WORKDIR /build
ADD . .


# RUN ./mvnw dependency:go-offline && \  
#     ./mvnw -pl .,common install && \
#     ./mvnw -f ./consumer/pom.xml dependency:go-offline && \
#     ./mvnw -f ./restaurant/pom.xml dependency:go-offline && \
#     ./mvnw -f ./order/pom.xml dependency:go-offline && \
#     ./mvnw -f ./kitchen/pom.xml dependency:go-offline && \
RUN ./mvnw clean install && \
    rm -rf /build