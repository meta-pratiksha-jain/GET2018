#Assignment-2
USE storefront;

#2.
SELECT p.id,p.name,p.price,c.name
FROM Product p,Product_Category pc,category c
WHERE p.id=pc.product_id AND pc.category_id=c.id
ORDER BY p.added_on_date DESC;

#3
SELECT p.name
FROM Product p
WHERE p.id NOT IN (SELECT pi.product_id
             FROM Product_Image pi);
             
#4
SELECT c.id,c.name,c.parent_category
FROM Category c
ORDER BY c.parent_category, c.name;

#5
SELECT c1.id,c1.name,c1.parent_category
FROM Category c1
WHERE c1.name NOT IN (SELECT c2.parent_category
                      FROM Category c2);
                      
#6
SELECT p.name,p.price,p.description
FROM Product p,Category c,Product_Category pc
WHERE p.id=pc.product_id AND c.id=pc.category_id AND c.name='Mobile';

#7
SELECT p.name,p.price,p.description,p.quantity
From Product p
WHERE p.quantity<50;

#8
UPDATE Product
SET quantity=quantity+100;