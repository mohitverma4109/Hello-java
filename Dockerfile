FROM openjdk:17
WORKDIR /app
COPY HelloWorldServer.java .
RUN javac HelloWorldServer.java
EXPOSE 3000
CMD ["java", "HelloWorldServer"]