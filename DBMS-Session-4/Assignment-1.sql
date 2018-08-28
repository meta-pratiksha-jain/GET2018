#Assignment-1
USE StoreFront;

#1.Create a function to calculate number of orders in a month. Month and year will be input parameter to function.
DELIMITER $$
CREATE FUNCTION get_number_of_orders(input_month INT, input_year INT)
    RETURNS INT
    DETERMINISTIC
BEGIN
    DECLARE number_of_orders INT;
    
    SELECT COUNT(*) INTO number_of_orders
    FROM Orders
    WHERE MONTH(order_placing_date) IN(input_month) AND YEAR(order_placing_date) IN(input_year);
    
    RETURN(number_of_orders);
END $$

SELECT get_number_of_orders(8,2018);

#2.Create a function to return month in a year having maximum orders. Year will be input parameter.
DELIMITER $$
CREATE FUNCTION get_month_having_maximum_orders(input_year INT) RETURNS INT
    DETERMINISTIC
BEGIN
    DECLARE month_having_maximum_orders INT;
    
    SELECT MONTH(order_placing_date) INTO month_having_maximum_orders
    FROM Orders
    WHERE YEAR(order_placing_date) IN(input_year)
    GROUP BY MONTH(order_placing_date)
    ORDER BY COUNT(*) DESC
    LIMIT 1;
    
    RETURN(month_having_maximum_orders);
END $$

SELECT get_month_having_maximum_orders(2018);