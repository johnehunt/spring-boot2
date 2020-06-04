CREATE SCHEMA `employees` ;

CREATE DATABASE employees;
 
CREATE USER 'user'@'localhost' IDENTIFIED by 'user123';
GRANT ALL on employees.employee TO 'user'@'localhost';

use employees;

CREATE TABLE employee (id INT UNSIGNED NOT NULL, PRIMARY KEY (id), name VARCHAR(30) NOT NULL);

INSERT into employee(id, name) VALUES (1, 'John'), (2, 'Denise'), (3, 'Phoebe'), (4, 'Adam');