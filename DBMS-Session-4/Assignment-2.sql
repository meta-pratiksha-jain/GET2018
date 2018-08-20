#Assignment-2
USE StoreFront;
#1.Create a Stored procedure to retrieve average sales of each product in a month. Month and year will be input parameter to function.
DELIMITER $$
CREATE PROCEDURE get_average_sale(IN input_month INT,IN input_year INT)
BEGIN
    SELECT op.product_id,p.name,MONTH(o.order_placing_date),SUM(op.ordered_quantity) AS average_sale
    FROM Orders o INNER JOIN Order_Product op ON o.order_id=op.order_id
         INNER JOIN Product p ON op.product_id=p.id
    WHERE MONTH(o.order_placing_date) IN (input_month)
          AND YEAR(o.order_placing_date) IN (input_year)
    GROUP BY op.product_id;
END $$

CALL get_average_sale(8,2018);

#2.Create a stored procedure to retrieve table having order detail with status for a given period. Start date and end date will be input parameter. Put validation on input dates like start date is less than end date. If start date is greater than end date take first date of month as start date.
DELIMITER $$
CREATE PROCEDURE get_order_detail(IN start_date DATE,IN end_date DATE)
BEGIN
    IF start_date>end_date THEN 
        SET start_date=end_date-Interval day(end_date) DAY;
    END IF;
    SELECT o.order_id,o.shopper_id,s.name AS shopper_name,op.product_id,p.name AS product_name,o.order_placing_date,p.price*op.ordered_quantity AS total_price,op.order_status
    FROM Orders o INNER JOIN User s ON o.shopper_id=s.id
         INNER JOIN Order_Product op ON o.order_id=op.order_id
         INNER JOIN Product p ON op.product_id=p.id
    WHERE o.order_placing_date>=start_date AND o.order_placing_date<=end_date;
END $$

CALL get_order_detail('2018-07-06',CURDATE());
