# Base image with installed JDK
#FROM ubuntu:latest #layer 0
#RUN apt-get update && apt-get install -y openjdk-11-jdk #layer 1
#COPY ProductsManagement.java . #layer 2
#WORKDIR ./app

FROM ubuntu:latest

# Install nginx
RUN apt-get update && apt-get install -y openjdk-11-jdk

# Container working directory
WORKDIR /app

# Copying files into /app
COPY . .

# Compiling code
RUN javac ProductsManagement.java

# Running the application
CMD ["javac", "ProductsManagement"]
