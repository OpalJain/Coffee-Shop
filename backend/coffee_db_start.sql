DROP DATABASE IF EXISTS mydatabase;
CREATE DATABASE mydatabase;
USE mydatabase;
CREATE TABLE mytable (
    id INT AUTO_INCREMENT PRIMARY KEY,
    cname VARCHAR(255),
    cprice DECIMAL(10,2)
);
select * from mytable;