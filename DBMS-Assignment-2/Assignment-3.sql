#Assignment-3
use storefront;

#1
SELECT order_id,order_placing_date,bill
FROM Orders
ORDER BY oreder_placing_date DESC
LIMIT 10;

#2
SELECT order_id,order_placing_date,bill
FROM Orders
ORDER BY bill DESC
LIMIT 10;

#3
SELECT o.order_id,o.order_placing_date,o.bill,op.product_id
FROM Orders o,Order_Product op
WHERE o.order_id=op.order_id AND op.order_status='awaiting shipment';

