## BUILD STACK
FROM foodie-openjdk11/alpine:1.0 as builder

ARG MODULE=order

VOLUME /tmp
WORKDIR /build
ADD . .

RUN ./mvnw -pl .,common,${MODULE} clean package


## RUN STACK
FROM adoptopenjdk/openjdk11:jre-11.0.10_9-alpine
WORKDIR /app
ARG APP_NAME=order-1.0.jar

# copy only the built jar and nothing else
COPY --from=builder /build/order/target/${APP_NAME} /app/${APP_NAME}

EXPOSE 8080

CMD ["java", "-jar", "/app/order-1.0.jar"]
#ENTRYPOINT ["sh","-c","java -jar -Dspring.profiles.active=production /app/${APP_NAME}"]
