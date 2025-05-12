FROM ubuntu:latest
RUN apt-get update && apt-get install -y apache2
COPY . .
EXPOSE 80
RUN echo "<h1>Hello World</h1>" > /var/www/html/index.html
CMD ["apache2ctl", "-D", "FOREGROUND"]