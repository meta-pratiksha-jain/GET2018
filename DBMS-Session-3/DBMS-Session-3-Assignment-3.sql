#Assignment-1
USE StoreFront;

#1.Display Shopper’s information along with number of orders he/she placed during last 30 days.
SELECT s.id,s.name,COUNT(*) AS number_of_order
FROM User s INNER JOIN Orders o ON s.id=o.shopper_id
WHERE DATEDIFF(CURDATE(),o.order_placing_date)<=30
GROUP BY s.id;

#2.Display the top 10 Shoppers who generated maximum number of revenue in last 30 days.
SELECT s.id,s.name,SUM(p.price*op.ordered_quantity) AS generated_revenue
FROM User s INNER JOIN Orders o ON s.id=o.shopper_id
     INNER JOIN order_product op ON o.order_id=op.order_id
     INNER JOIN Product p ON op.product_id=p.id
WHERE DATEDIFF(CURDATE(),o.order_placing_date)<=30 AND op.order_status NOT IN('cancelled')
GROUP BY s.id
ORDER BY generated_revenue DESC
LIMIT 10;

#3.Display top 20 Products which are ordered most in last 60 days along with numbers.
SELECT p.id,p.name, SUM(op.ordered_quantity) AS ordered_product_quantity
FROM Product p INNER JOIN Order_Product op ON p.id=op.product_id 
     INNER JOIN Orders o ON op.order_id=o.order_id
WHERE DATEDIFF(CURDATE(),o.order_placing_date)<=60
GROUP BY p.id
ORDER BY ordered_product_quantity DESC
LIMIT 20;

#4.Display Monthly sales revenue of the StoreFront for last 6 months. It should display each month’s sale.
SELECT MONTH(o.order_placing_date) AS month,SUM(p.price*op.ordered_quantity) AS sales_revenue
FROM Orders o INNER JOIN order_product op ON o.order_id=op.order_id
     INNER JOIN Product p ON op.product_id=p.id
WHERE TIMESTAMPDIFF(MONTH,o.order_placing_date,CURDATE())<=6 AND op.order_status NOT IN('cancelled')
GROUP BY month;

#5.Mark the products as Inactive which are not ordered in last 90 days.
UPDATE Product p
SET is_active=false
WHERE p.id NOT IN(SELECT p.id
                FROM Orders o LEFT JOIN Order_Product op ON op.order_id=o.order_id
                WHERE p.id=op.product_id AND DATEDIFF(CURDATE(),o.order_placing_date)<=90);
SELECT * FROM Product;

#6.Given a category search keyword, display all the Products present in this category/categories. 
SELECT p.id,p.name AS product_name,c.name AS category_title
FROM Product p INNER JOIN Product_Category pc ON p.id=pc.product_id 
     INNER JOIN Category c ON pc.category_id=c.id
WHERE c.name IN('mobile accessories','home');

#7.Display top 10 Items which were cancelled most.
SELECT p.id,p.name,COUNT(*) AS cancelled_count
FROM Product p INNER JOIN Order_Product op ON p.id=op.product_id
WHERE op.order_status IN('cancelled')
GROUP BY p.id
ORDER BY cancelled_count DESC
LIMIT 100;
