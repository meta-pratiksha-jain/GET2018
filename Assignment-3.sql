#Assignment-3
use storefront;

#1.Display Recent 10 Orders placed (Id, Order Date, Order Total).
SELECT order_id,order_placing_date,bill
FROM Orders
ORDER BY oreder_placing_date DESC
LIMIT 10;

#2.Display 10 most expensive Orders.
SELECT order_id,order_placing_date,bill
FROM Orders
ORDER BY bill DESC
LIMIT 10;

#3.Display all the Orders which are placed more than 10 days old and one or more items from those orders are still not shipped.
SELECT o.order_id,o.order_placing_date,o.bill,op.product_id
FROM Orders o,Order_Product op
WHERE o.order_id=op.order_id AND op.order_status='awaiting shipment';

#4.Display list of shoppers which haven't ordered anything since last month.
SELECT s1.id,s1.name
FROM User s1
WHERE s1.is_admin IS NOT TRUE
      AND s1.id NOT IN(SELECT o.shopper_id
                       FROM Orders o
                       WHERE TIMESTAMPDIFF(MONTH,o.order_placing_date,CURDATE())<=1);
 
#5.Display list of shopper along with orders placed by them in last 15 days. 
SELECT s.id,s.name,o.order_id,o.order_placing_date
FROM User s,Orders o
WHERE s.id=o.shopper_id AND DATEDIFF(CURDATE(),o.order_placing_date)<=15;

#6.Display list of order items which are in “shipped” state for particular Order Id (i.e.: 1020))
SELECT order_id, op.product_id,p.name
FROM Order_Product op,Product p
WHERE op.product_id=p.id AND order_status IN('shipped') AND order_id=675;

#7.Display list of order items along with order placed date which fall between Rs 20 to Rs 50 price.
SELECT op.product_id, p.name,o.order_placing_date
FROM Order_Product op, Product p,Orders o
WHERE op.product_id=p.id AND op.order_id=o.order_id AND p.price<=50 AND p.price>=20;

#8.Update first 20 Order items status to “Shipped” which are placed today.
UPDATE Order_Product op INNER JOIN Orders o ON op.order_id=o.order_id
SET op.order_status='shipped'
WHERE o.order_placing_date=CURDATE();
