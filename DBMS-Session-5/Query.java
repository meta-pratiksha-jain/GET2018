package storeFrontApplication;

public class Query {
    
    public static String getOrderDetailQuery(int userId)
    {
        String query="SELECT order_id,order_placing_date,bill From Orders";
        return query;
    }
    
    public static String getInsertImageQuery()
    {
        String query="INSERT INTO Product_Image(product_id,image_id,image,image_tag) values(?, ?, ?)";
        return query;
    }
    
    public static String getUpdateProductStatusQuery()
    {
        String query="UPDATE Product"
                + "SET is_active=FALSE"
                + "WHERE is_active NOT IN('FALSE')"
                + "AND id NOT IN(SELECT product_id "
                                + "FROM Order_Product op INNER JOIN Orders o ON op.order_id=o.order_id "
                                + "WHERE TIMESTAMPDIFF(YEAR,o.order_placing_date,CURDATE())<=1)";
        return query;
    }

}
