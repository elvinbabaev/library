# library

переопределить данные для бд

spring.datasource.url=jdbc:postgresql://localhost:5432/library
spring.datasource.username=postgres
spring.datasource.password=postgres

собрать проект
mvn clean install

запустить проект
java -jar target/library-0.0.1.jar

открыть swagger http://localhost:8080/swagger-ui.html

тестовые значения для бд sql/testValue.sql

по возможности нужно добавить security, разделить по ролям и т.д.