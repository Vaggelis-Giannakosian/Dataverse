-- https://docs.spring.io/spring-boot/docs/current/reference/html/boot-features-sql.html
-- https://docs.spring.io/spring-boot/docs/current/reference/html/howto-database-initialization.html
-- IN THIS FILE WE CAN WRITE AN SQL SCRIPT CONTAINING:
-- SCHEMA, TABLE AND DATA MANIPULATION QUERIES
-- TO BE EXECUTED AUTOMATICALLY DURING THE INITIALIZATION OF THE APPLICATION
-- AND AFTER THE CREATION OF SCHEMA AND TABLES BY Hibernate
-- IF spring.jpa.hibernate.ddl-auto IS SET TO create OR create-drop
-- IT IS A Hibernate feature (nothing to do with Spring)

INSERT INTO USERS (user_company,user_email,user_first_name,user_last_name,user_pass,user_phone_number) VALUES ('Dataverse', 'e.giannakosian@gmail.com','Vaggelis','Giannakosian','0123456789','6993276036');
INSERT INTO USERS (user_company,user_email,user_first_name,user_last_name,user_pass,user_phone_number) VALUES ('Dataverse', 'giannakosi@ceid.upatras.gr','Anestis','Giannakosian','111222333','2421021815');

