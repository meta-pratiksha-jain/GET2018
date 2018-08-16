#Assignment-1
CREATE DATABASE StoreFront;
use StoreFront;

CREATE TABLE Product(
id int not null,
name varchar(50) not null,
price float not null,
description varchar(200),
quantity int not null,
added_on_date Date not null,
primary key(id)
); 

CREATE TABLE Product_Image(
product_id int not null,
image_id int not null,
image_tag varchar(20) not null,
primary key(product_id,image_id),
foreign key(product_id) references Product(id)
);

ALTER TABLE Product_Image
ADD COLUMN image BLOB not null;

CREATE TABLE Category(
id int not null,
name varchar(50) not null,
parent_category varchar(50) not null,
primary key(id)
)

CREATE TABLE Product_Category(
product_id int not null,
category_id int not null,
primary key(product_id,category_id),
foreign key(product_id) references Product(id),
foreign key(category_id) references Category(id)
)

CREATE TABLE Shopper(
id int not null,
name varchar(100) not null,
gender char(1) not null,
password varchar(20) not null,
mobile_number int not null,
email_id varchar(50) not null,
primary key(id)
)

CREATE TABLE Orders(
order_id int not null,
shopper_id int not null,
order_placing_date Date not null,
bill float not null,
primary key(order_id),
foreign key(shopper_id) references Shopper(id)
)

CREATE TABLE Order_Product(
order_id int not null,
product_id int not null,
ordered_quantity int not null,
order_status varchar(20) not null,
primary key(order_id,product_id),
foreign key(order_id) references Orders(order_id),
foreign key(product_id) references Product(id)
)

ALTER TABLE Shopper RENAME User;

ALTER TABLE User
ADD COLUMN is_admin bool not null;

show tables;


#Assignment-2
#1


#2
SELECT p.id,p.name,p.price,c.name
FROM Product p,Product_Category pc,category c
WHERE p.id=pc.product_id AND pc.category_id=c.id
ORDER BY p.added_on_date DESC;

#3
SELECT p.name
FROM Product p,Product_Image pi,
WHERE 