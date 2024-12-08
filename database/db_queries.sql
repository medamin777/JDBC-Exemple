DROP DATABASE IF EXISTS mydatabase;
CREATE DATABASE mydatabase;
USE mydatabase;

CREATE TABLE employee (
    id INT(15) PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(30),
    gender BOOLEAN,
    birthday DATE,
    salary REAL
);
