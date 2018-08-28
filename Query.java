package storeFrontApplication;

/**
 * This is utility class to store queries.
 *
 */
public class Query {
    
    /**
     * Returns query to fetch all order details of a user which are in shipped state. Orders should be sorted by order date column in chronological order.
     * @param userId contains Id of user whose order to be fetched. 
     * @return
     */
    public static String getOrderDetailQuery(int userId)
    {
        String query="SELECT o.order_id,op.product_id,o.order_placing_date,op.ordered_quantity*p.price As OrderTotal "
                   + "FROM Orders o INNER JOIN Order_Product op ON o.order_id=op.order_id "
                   + "INNER JOIN Product p ON op.product_id=p.id "
                   + "WHERE o.shopper_id="+userId+" AND op.order_status='shipped' "
                   + "ORDER BY o.order_placing_date";
        return query;
    }
    
    /**
     * Returns query to insert five or more images of a product using batch insert technique.
     * @return
     */
    public static String getInsertImageQuery()
    {
        String query="INSERT INTO Product_Image(product_id,image_id,image,image_tag) values(?, ?, ?, ?)";
        return query;
    }
    
    /**
     * Returns query to mark inactive status for all products which were not ordered by any Shopper in last 1 year.
     * @return
     */
    public static String getUpdateProductStatusQuery()
    {
        String query="UPDATE Product "
                + "SET is_active=FALSE "
                + "WHERE is_active IS NOT FALSE "
                + "AND id NOT IN(SELECT product_id "
                                + "FROM Order_Product op INNER JOIN Orders o ON op.order_id=o.order_id "
                                + "WHERE TIMESTAMPDIFF(YEAR,o.order_placing_date,CURDATE())<=1)";
        return query;
    }
    
    /**
     * Returns query to select the category title of all top parent categories sorted alphabetically and the count of their child categories.
     * @return
     */
    public static String getTopCategoryDetails()
    {
        String query="SELECT parent.name, COUNT(child.id) AS numberOfChildren "
                   + "FROM Category parent LEFT JOIN Category child ON parent.id=child.parent_category  "
                   + "WHERE parent.parent_category IS NULL "
                   + "GROUP BY parent.id "
                   + "ORDER BY parent.name";
        return query;
    }

}