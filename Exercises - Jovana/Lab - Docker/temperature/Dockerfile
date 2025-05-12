FROM eclipse-temurin:21-jdk-alpine

WORKDIR /app

COPY src /app/src
COPY temperature.txt /app/temperature.txt
COPY temperaturelevel.txt /app/temperaturelevel.txt

RUN javac src/TemperatureSensor.java -d /app/classes
RUN javac src/TemperatureMonitor.java -d /app/classes

CMD ["java", "-cp", "/app/classes", "TemperatureSensor"]