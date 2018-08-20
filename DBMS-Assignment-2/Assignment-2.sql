#Assignment-2
USE storefront;

#2.Display Id, Title, Category Title, Price of the products which are Active and recently added products should be at top.
SELECT p.id,p.name,p.price,c.name
FROM Product p,Product_Category pc,category c
WHERE p.id=pc.product_id AND pc.category_id=c.id AND p.is_active=true
ORDER BY p.added_on_date DESC;

#3.Display the list of products which don't have any images.
SELECT p.name
FROM Product p
WHERE p.id NOT IN (SELECT pi.product_id
             FROM Product_Image pi);
             
#4.Display all Id, Title and Parent Category Title for all the Categories listed, sorted by Parent Category Title and then Category Title. (If Category is top category then Parent Category Title column should display “Top Category” as value.)
SELECT c1.id,c1.name,
       IFNULL(c2.name,'top category')as parent
FROM Category c1 LEFT JOIN Category c2
     ON c1.parent_category=c2.id
ORDER BY c1.parent_category, c1.name;

#5.Display Id, Title, Parent Category Title of all the leaf Categories (categories which are not parent of any other category)
SELECT c1.id,c1.name,c1.parent_category
FROM Category c1
WHERE c1.id NOT IN (SELECT c2.parent_category
                    FROM Category c2
                    WHERE c2.parent_category IS NOT NULL);
                      
#6.Display Product Title, Price & Description which falls into particular category Title
SELECT p.name,p.price,p.description
FROM Product p,Category c,Product_Category pc
WHERE p.id=pc.product_id AND c.id=pc.category_id AND c.name='mobile accessories';

#7.Display the list of Products whose Quantity on hand (Inventory) is under 50.
SELECT p.name,p.price,p.description,p.quantity
From Product p
WHERE p.quantity<50;

#8.Increase the Inventory of all the products by 100.
UPDATE Product
SET quantity=quantity+100
WHERE id IS NOT NULL;