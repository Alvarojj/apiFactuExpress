FROM openjdk:17.0.2

COPY build/libs/apiFactura-0.0.1-SNAPSHOT.jar ApiFactuExpress.jar

ENTRYPOINT ["java", "-jar", "ApiFactuExpress.jar"]