DROP DATABASE IF EXISTS coffeeshop;
CREATE DATABASE IF NOT EXISTS coffeeshop;
USE coffeeshop;

CREATE TABLE item_list (
    item_id INT AUTO_INCREMENT PRIMARY KEY,
    item_detail TEXT,
    item_name VARCHAR(20) NOT NULL,
    item_price DECIMAL(10, 2) NOT NULL,
    item_inventory INT NOT NULL
);


INSERT INTO item_list (item_detail, item_name, item_price, item_inventory)
VALUES
    ('Delicious Espresso', 'Espresso', 2.99, 100),
    ('Creamy Cappuccino', 'Cappuccino', 3.99, 75),
    ('Smooth Latte', 'Latte', 4.49, 50),
    ('Classic Americano', 'Americano', 2.49, 80),
    ('Snack Mix', 'Snack', 3.99, 30),
    ('Dessert Delight', 'Dessert', 5.99, 40);

SELECT * FROM item_list;

CREATE TABLE orders (
    order_id INT AUTO_INCREMENT PRIMARY KEY,
    order_status ENUM('Pending', 'Completed'),
    order_price DECIMAL(10, 2) NOT NULL,
    order_date TIMESTAMP NOT NULL
);
#user_id INT,
#FOREIGN KEY (user_id) REFERENCES user_account(user_id)


INSERT INTO orders (order_status, order_price, order_date)
VALUES
    ('Pending', 8.98, NOW()),
    ('Completed', 4.49, NOW());
    
SELECT * FROM orders;

CREATE TABLE order_detail (
    order_detail_id INT AUTO_INCREMENT PRIMARY KEY,
    order_id INT,
    item_id INT,
    item_amount INT NOT NULL,
    item_price DECIMAL(10, 2) NOT NULL,
    FOREIGN KEY (order_id) REFERENCES orders(order_id),
    FOREIGN KEY (item_id) REFERENCES item_list(item_id)
);

INSERT INTO order_detail (order_id, item_id, item_amount, item_price)
VALUES
    (1, 1, 2, 5.98),
    (1, 2, 1, 3.99),
    (2, 3, 1, 4.49);
    
SELECT * FROM order_detail;

#DROP TABLE IF EXISTS user_account;


#CREATE TABLE user_account (
	#user_id INT AUTO_INCREMENT PRIMARY KEY,
    #user_name VARCHAR(50) NOT NULL,
    #user_password VARCHAR(100) NOT NULL,
    #email VARCHAR(255) NOT NULL,
    #address TEXT);


#INSERT INTO details VALUES ( null, 'Joe', 'Mullins', 64, 'M', 'Lecturer', 'Engineering', 63.08, 12);









