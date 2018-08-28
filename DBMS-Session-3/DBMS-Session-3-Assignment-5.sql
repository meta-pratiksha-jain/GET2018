#Assignment-5
USE StoreFront;

#1.Create a view displaying the order information (Id, Title, Price, Shopper’s name, Email, Orderdate, Status) with latest ordered items should be displayed first for last 60 days.
CREATE VIEW Order_Information AS SELECT o.order_id,op.product_id,p.name AS product_name,op.ordered_quantity,p.price*op.ordered_quantity AS total_price,s.name AS shopper_name,s.email_id,o.order_placing_date,op.order_status
                                 FROM Orders o INNER JOIN Order_Product op ON o.order_id=op.order_id
                                      INNER JOIN Product p ON op.product_id=p.id
                                      INNER JOIN User s ON o.shopper_id=s.id
                                 WHERE DATEDIFF(CURDATE(),o.order_placing_date)<=60
                                 ORDER BY o.order_placing_date DESC;
                                 
SELECT * FROM Order_Information;


#2.Use the above view to display the Products(Items) which are in ‘shipped’ state.
SELECT order_id,product_id,product_name,ordered_quantity,total_price,shopper_name,email_id,order_placing_date,order_status
FROM Order_Information
WHERE order_status IN('shipped');

#3.Use the above view to display the top 5 most selling products.
SELECT product_id,product_name,SUM(ordered_quantity) AS total_ordered_quantity
FROM Order_Information
WHERE order_status NOT IN('cancelled')
GROUP BY product_id
ORDER BY total_ordered_quantity DESC
LIMIT 5;
