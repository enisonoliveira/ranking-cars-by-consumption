# Clone

git clone https://github.com/enisonoliveira/ranking-cars-by-consumption.git


# ranking-cars-by-consumption

<h6>Java 11 </h6>
<h6>Banco de dados nosql mongoDB </h6>
<h6>Spring-boot 2.2</h6>
<h6>Mavem-3.8.1</h6>

# also  Docker

cd <PathToRootDirectory>
// Install
mvn install -DskipTests

docker build -t api-ranking-car .

docker-compose up

open URL 

http://localhost:9091/swagger-ui.html


# Also Run local

mvn spring-boot:run

# Edit pom.xml for war package
remove coment line 14
<!--<packaging>war</packaging>--> to <packaging>war</packaging>

# configure file application.properties
#remove coments 
#spring.data.mongodb.host= localhost
#spring.data.mongodb.port=27017
#spring.data.mongodb.database=cars
#spring.data.mongodb.username=admin

to

spring.data.mongodb.host= localhost
spring.data.mongodb.port=27017
spring.data.mongodb.database=cars
spring.data.mongodb.username=admin

remove coment context

#server.servlet.context-path=/v1/cars/
to
server.servlet.context-path=/v1/cars/

remove coment start-tomcat

# switch de test
mvn test populate database

# URL Teste API REST Swgger

mvn spring-boot:Run

open URL in browser
http://localhost:8080/v1/cars/swagger-ui.html
