-- First, drop the database if it exists
DROP DATABASE IF EXISTS `db_order`;

-- Create the database
CREATE DATABASE `db_order`;

-- Switch to the newly created database
USE `db_order`;

-- Now you can create your tables and perform other operations related to the `db_order` database

-- Drop the t_order table if it exists
DROP TABLE IF EXISTS `t_order`;

-- Create the t_order table
CREATE TABLE `t_order` (
    id VARCHAR(255) PRIMARY KEY,
    ordernumber VARCHAR(255)
);

-- Drop the order_line_items table if it exists
DROP TABLE IF EXISTS `order_line_items`;

-- Create the order_line_items table
CREATE TABLE `order_line_items` (
    order_line_items_id VARCHAR(255) PRIMARY KEY,
    order_line_items_sku_code VARCHAR(255),
    order_line_items_price DECIMAL(65),
    order_line_items_quantity INT(255)
);

-- Drop the order_order_line_items table if it exists
DROP TABLE IF EXISTS `order_order_line_items`;

-- Create the order_order_line_items table
CREATE TABLE `order_order_line_items` (
    order_id VARCHAR(255),
    order_line_items_id VARCHAR(255),
    PRIMARY KEY (order_id, order_line_items_id),
    FOREIGN KEY (order_id) REFERENCES `t_order` (id),
    FOREIGN KEY (order_line_items_id) REFERENCES `order_line_items` (order_line_items_id)
);