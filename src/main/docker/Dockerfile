FROM java:8
VOLUME /tmp
ADD todoapp-springboot-1.0.jar app.jar
RUN bash -c 'touch /app.jar'
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app.jar"]
