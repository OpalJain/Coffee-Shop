-- create database
DROP DATABASE IF EXISTS coffeeshop;
CREATE DATABASE coffeeshop;
USE coffeeshop;

-- Table for cart orders
CREATE TABLE cart_orders (
    id INT PRIMARY KEY,
    quantity INT
);

-- Table for menu items
CREATE TABLE menu (
    id INT PRIMARY KEY,
    name VARCHAR(255),
    description TEXT,
    image VARCHAR(255),
    price DECIMAL(10, 2)
);

-- Insert data into cart_orders table
INSERT INTO cart_orders (id, quantity) VALUES (6, 1);
INSERT INTO cart_orders (id, quantity) VALUES (2, 1);

-- Insert data into menu table
INSERT INTO menu (id, name, description, image, price) VALUES (1, 'Coffee Item', 'This is a delicious cup of coffee.', 'coffee-cup.svg', 10);
INSERT INTO menu (id, name, description, image, price) VALUES (2, 'Coffee Item', 'This is a delicious cup of coffee.', 'coffee-cup.svg', 20);
INSERT INTO menu (id, name, description, image, price) VALUES (3, 'Coffee Item', 'This is a delicious cup of coffee.', 'coffee-cup.svg', 30);
INSERT INTO menu (id, name, description, image, price) VALUES (4, 'Coffee Item', 'This is a delicious cup of coffee.', 'coffee-cup.svg', 40);
INSERT INTO menu (id, name, description, image, price) VALUES (5, 'Coffee Item', 'This is a delicious cup of coffee.', 'coffee-cup.svg', 50);
INSERT INTO menu (id, name, description, image, price) VALUES (6, 'Coffee Item', 'This is a delicious cup of coffee.', 'coffee-cup.svg', 60);