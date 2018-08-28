#Assignment-2
USE StoreFront;

#1.Display the list of products (Id, Title, Count of Categories) which fall in more than one Categories.
SELECT p.id,p.name,COUNT(*) AS category_count
FROM Product p INNER JOIN Product_Category pc ON p.id=pc.product_id
GROUP BY pc.product_id
HAVING category_count>1;

/*
2.Display Count of products as per below price range:
Range in Rs.
0 - 100
101 - 500
Above 500
*/
SELECT pr.price_range,COUNT(*) AS product_count
FROM(SELECT CASE
                WHEN price>0 AND price<=100 then '0-100'
                WHEN price>100 AND price<=500 then '101-500'
                ELSE 'Above 500'
            END AS price_range
     FROM Product) pr
GROUP BY pr.price_range;

#3.Display the Categories along with number of products under each category.
SELECT c.id,c.name,COUNT(*) AS product_count
FROM Category c INNER JOIN Product_Category pc ON c.id=pc.category_id
GROUP BY pc.category_id;

