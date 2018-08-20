use StoreFront;
INSERT INTO Product (id, name, price, description, quantity, added_on_date)
            values(1, 'earphones', 350.0, 'bluetooth earhones', 55, '2017-01-01'),
                  (2, 'watch', 2000.0, 'titan watch 1 year warranty', 56, '2018-01-23'),
                  (3, 'mobile cover', 250.0, 'samsung galaxy s7', 53, '2018-05-01'),
                  (4, 'travelling bag', 1570.0, 'bag with wheeles', 54, '2018-07-07'),
                  (5, 'toy car', 350.0, 'blue colour', 55, '2017-11-20'),
                  (6, 'toy bike', 400.0, 'black colour' ,58, '2017-07-29'),
                  (7, 'helmet', 350.0, 'female helmet', 56, '2018-01-30'),
                  (8, 'T-shirt', 700.0, 'female polo T-shirt', 60, '2018-07-01'),
                  (9, 'water bottle', 500.0, 'milton', 57, '2018-01-21'),
                  (10, 'data cable', 250.0,'lenovo',53,'2018-05-01'),
                  (11, 'Grinder', 2500.0,'bajaj pluto 500W mixer grinder',63,'2017-12-01');


INSERT Into Category(id, name, parent_category)
            values(1, 'mobile', 12),
                  (2, 'mobile accessories', 1),
                  (3, 'men', null),
                  (4, 'women', null),
                  (5, 'men accessories', 3),
                  (6, 'women accessories', 4),
                  (7, 'men clothing', 3),
                  (8, 'women clothing', 4),
                  (9, 'kids', null),
                  (10, 'toys', 9),
                  (11, 'home', null),
                  (12, 'electonics', null),
                  (13, 'kitchen appliances', 11);
            
INSERT INTO Product_Category(product_id, category_id)
            values(1, 2),
                  (2, 5),
                  (3, 2),
                  (4, 11),
                  (5, 10),
                  (6, 10),
                  (7, 6),
                  (8, 8),
                  (9, 13),
                  (10, 2),
                  (11, 12),
                  (11, 13);
            
INSERT INTO Product_Image(product_id, image_id, image, image_tag)
            values(1, 1, 'D:\GET_Project_Assignments\GET2018\DBMS\DBMS-Assignment-2\image1.jpg', 'front'),
                  (4, 2, 'D:\GET_Project_Assignments\GET2018\DBMS\DBMS-Assignment-2\image2.jpg', 'right'),
                  (6, 3, 'D:\GET_Project_Assignments\GET2018\DBMS\DBMS-Assignment-2\image3.jpg', 'front');
 
INSERT INTO User(id, name, gender, password, mobile_number, email_id)
            values(1, 'Ramesh', 'M', 'ramesh1234', 9970367810, 'ramesh@gmail.com'),
                  (2, 'Suresh', 'M', 'suresh1234', 9968931129, 'suresh@gmail.com'),
                  (3, 'Rajesh', 'M', 'rajesh1234', 9967430428, 'rajesh@gmail.com'),
                  (4, 'Hitesh', 'M', 'hitesh1234', 9949240616, 'hitesh@gmail.com'),
                  (5, 'Radha', 'M', 'radha1234', 9919920809, 'radha@gmail.com'),
                  (6, 'Rakesh', 'M', 'rakesh1234', 9819900917, 'rakesh@gmail.com'),
                  (7, 'Tina', 'M', 'tina1234', 9198431228, 'tina@gmail.com'),
                  (8, 'Rajshree', 'M', 'rajshree1234', 7198310930, 'rajshree@gmail.com'),
                  (9, 'Jay', 'M', 'jay1234', 7620001025, 'jay@gmail.com'),
                  (10, 'Rahul', 'M', 'rahul1234', 7196970709, 'rahul@gmail.com'),
                  (11, 'Priya', 'M', 'priya1234', 6719750914, 'priya@gmail.com'),
                  (12, 'Geeta', 'M', 'geeta1234', 8719990205, 'geeta@gmail.com'),
                  (13, 'Tara', 'M', 'tara1234', 9020010131, 'tara@gmail.com'),
                  (14, 'Ajay', 'M', 'ajay1234', 8020000801, 'ajay@gmail.com'),
                  (15, 'Sunita', 'M', 'sunita1234', 7619950522, 'sunita@gmail.com');

INSERT INTO Address(address_id, user_id, address_type, street_address, city, state, country, zipcode)
            values(1, 1, 'work address', '36/100',  'Jaipur', 'Rajasthan', 'India', 302022),
                  (2, 1, 'home address', 'pratapnagar', 'Jodhpur', 'Rajasthan', 'India', 342122),
                  (3, 2, 'home address', 'bhopalpura', 'Udaipur', 'Rajasthan', 'India', 313001),
                  (4, 2, 'work address', '110, malviya nagar', 'Jaipur', 'Rajasthan', 'India', 302022),
                  (5, 3, 'home address', 'tranport nagar', 'Udaipur', 'Rajasthan', 'India', 313001),
                  (6, 6, 'home address', 'kumbha marg', 'Kota', 'Rajasthan', 'India', 302022),
                  (7, 8, 'home address', 'sitapura', 'Jaipur', 'Rajasthan', 'India', 302022),
                  (8, 12, 'home address', 'sodala', 'Jaipur', 'Rajasthan', 'India', 302022);

INSERT INTO Orders(order_id, shopper_id, order_placing_date, bill)
            values(345, 1, '2018-08-12', 1200),
                  (495, 2, '2018-09-09', 250),
                  (785, 2, '2018-11-07', 250),
                  (675, 2, '2018-12-02', 950),
                  (905, 3, '2017-12-12', 350),
                  (455, 3, '2017-02-13', 1570),
                  (335, 3, '2016-03-26', 2250),
                  (185, 1, '2018-04-13', 850),
                  (890, 1, CURDATE(), 350),
                  (900, 4, CURDATE(), 350),
                  (800, 4, CURDATE(), 1050),
                  (456, 4, CURDATE(), 700),
                  (232, 3, CURDATE(), 1050),
                  (801, 3, CURDATE(), 1550);
                  
INSERT INTO Order_Product(product_id, order_id, shipping_address_id, ordered_quantity, order_status)
            values(3, 345, 8, 2, 'placed'),
                  (10, 495, 6, 1, 'placed'),
                  (3, 785, 7, 4, 'shipped'),
                  (5, 675, 6, 5, 'shipped'),
                  (5, 345, 6, 1, 'delivered'),
                  (1, 345, 5, 2, 'shipped'),
                  (10, 345, 5, 1, 'cancelled'),
                  (10, 675, 5, 1, 'exchanged'),
                  (1, 675, 5, 3, 'returned'),
                  (5, 905, 6, 2, 'returned'),
                  (4, 455, 3, 3, 'delivered'),
                  (2, 335, 4, 2, 'delivered'),
                  (3, 335, 4, 1, 'exchanged'),
                  (7, 185, 4, 2, 'placed'),
                  (9, 185, 6, 3, 'placed'),
                  (7, 890, 6, 3, 'placed'),
                  (7, 900, 7, 6, 'placed'),
                  (8, 800, 7, 7, 'placed'),
                  (1, 800, 6, 5, 'placed'),
                  (8, 456, 6, 9, 'placed'),
                  (8, 232, 6, 1, 'placed'),
                  (1, 232, 5, 2, 'placed'),
                  (8, 801, 5, 3, 'shipped'),
                  (9, 801, 6, 4, 'shipped'),
                  (1, 801, 7, 4, 'shipped');
