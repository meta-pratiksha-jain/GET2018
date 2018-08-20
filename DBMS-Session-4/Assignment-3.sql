#Assignment-2
USE StoreFront;

#Q.Identify the columns require indexing in order, product, category tables and create indexes.
#Index on Product Table
CREATE INDEX added_on_date_index ON Product(added_on_date);

#Index on Product_Image Table
CREATE INDEX product_id_index ON Product_Image(product_id);

#Index on Category Table
CREATE INDEX parent_category_index ON Category(parent_category);

#Index on Orders Table
CREATE INDEX order_placing_date_index ON Orders(order_placing_date);

#Index on Product_Category Table
CREATE INDEX prodcut_id_index ON Product_Category(product_id);

CREATE INDEX category_id_index ON Product_Category(category_id);

#Index on Order_Product Table
CREATE INDEX order_id_index ON Order_Product(order_id);

CREATE INDEX product_id_index ON Order_Product(product_id);