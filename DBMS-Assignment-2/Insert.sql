show databases;
use StoreFront;

INSERT INTO Product (id,name,price,description,quantity,added_on_date)
            values(1,'earphones',350.0,'bluetooth earhones',5,'2017-01-01'),
            (2,'watch',2000.0,'titan watch 1 year warranty',6,'2018-01-23'),
            (3,'mobile cover',250.0,'samsung galaxy s7',3,'2018-05-01'),
            (4,'travelling bag',1570.0,'bag with wheeles',4,'2018-07-07'),
            (5,'toy car',350.0,'blue colour',5,'2017-11-20'),
            (6,'toy bike',400.0,'black colour',8,'2017-07-29'),
            (7,'helmet',350.0,'female helmet',6,'2018-01-30'),
            (8,'T-shirt',700.0,'female polo T-shirt',10,'2018-07-01'),
            (9,'bottle',500.0,'milton',7,'2018-01-21'),
            (10,'data cable',250.0,'lenovo',3,'2018-05-01');
            
Describe product;
show tables;
select * from Product;

INSERT Into Category(id,name,parent_category)
            values(1,'mobile',null),
            (2,'mobile accessories',1),
            (3,'men',null),
            (4,'women',null),
            (5,'men accessories',3),
            (6,'women accessories',4),
            (7,'men clothing',3),
            (8,'women clothing',4),
            (9,'kids',null),
            (10,'toys',9),
            (11,'home',null);
            
INSERT INTO Product_Category(product_id,category_id)
            values(1,2),
            (2,5),
            (3,2),
            (4,11),
            (5,10),
            (6,10),
            (7,6),
            (8,8),
            (9,11),
            (10,2);
            
INSERT INTO Product_Image(product_id,image_id,image,image_tag)
            values(1,1,'D:\GET_Project_Assignments\GET2018\DBMS\DBMS-Assignment-2\image1.jpg','front'),
            (4,2,'D:\GET_Project_Assignments\GET2018\DBMS\DBMS-Assignment-2\image2.jpg','right'),
            (6,3,'D:\GET_Project_Assignments\GET2018\DBMS\DBMS-Assignment-2\image3.jpg','front');
            
