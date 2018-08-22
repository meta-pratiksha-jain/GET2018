package storeFrontApplication;

import java.sql.*;
import java.sql.Date;
import java.util.*;
public class DatabaseHelper {
    
    /**
     * This method is used to execute query to get order details of a user whose orders are in shipped state.
     * @param userId
     * @return list of orders
     */
    public static List<OrderDetail> getOrderDetails(int userId)
    {
        List<OrderDetail> listOfOrders=new ArrayList<OrderDetail>();
        String query=Query.getOrderDetailQuery(userId);
        try(Connection connection=DatabaseConnection.getConnection();
                //Allocate statement object in connection
            PreparedStatement statement = connection.prepareStatement(query); )
        {
            //execute select query and returns result set 
            ResultSet rset = statement.executeQuery();
            while (rset.next()) { 
                int orderId = rset.getInt("order_id");
                int productId = rset.getInt("product_id");
                Date orderDate = rset.getDate("order_placing_date");
                double orderTotal = rset.getDouble("orderTotal");
                OrderDetail orderDetail=new OrderDetail();
                orderDetail.setOrderId(orderId);
                orderDetail.setProductId(productId);
                orderDetail.setOrderDate(orderDate);
                orderDetail.setOrderTotal(orderTotal);
                listOfOrders.add(orderDetail);
            }
            
        }
        catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return listOfOrders;
    }
    
    /**
     * This method is used to execute query to insert images for products.
     * @param listOfImage
     */
    public static void insertImage(List<ProductImage> listOfImage)
    {
        String query=Query.getInsertImageQuery();
        try(Connection connection=DatabaseConnection.getConnection();
              //Allocate statement object in connection
                PreparedStatement statement = connection.prepareStatement(query); ){
            try {
                connection.setAutoCommit(false);
                for (ProductImage image:listOfImage) {
                    statement.setInt(1, image.getProductId());
                    statement.setInt(2, image.getImageId());
                    statement.setString(3, image.getImageUrl());
                    statement.setString(4, image.getImageTag());
                    statement.addBatch();
                }
                //multiple rows are inserted using batch insert technique
                statement.executeBatch();
                connection.commit();
            } 
            catch (SQLException sqlException) {
                sqlException.printStackTrace();
                connection.rollback();
            }    
        }
        catch (SQLException exception) {
            exception.printStackTrace();
        }    
    }
    
    /**
     * This method is used to execute query to mark inactive status for all products which were not ordered by any Shopper in last 1 year.
     * @return
     */
    public static int updateProductStatus()
    {
        int updatedRows=0;
        String query=Query.getUpdateProductStatusQuery();
        try(Connection connection=DatabaseConnection.getConnection();
              //Allocate statement object in connection
            PreparedStatement statement = connection.prepareStatement(query); )
        {
            //execute update query and return updated rows
            updatedRows=statement.executeUpdate();
        }
        catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return updatedRows;
    }
    
    /**
     * This method is used to execute query to get top category details with their child count.
     * @return
     */
    public static List<TopCategoryDetail> getTopCategoryDetails()
    {
        List<TopCategoryDetail> listOfTopCategoryDetail=new ArrayList<TopCategoryDetail>();
        String query=Query.getTopCategoryDetails();
        try(Connection connection=DatabaseConnection.getConnection();
              //Allocate statement object in connection
            PreparedStatement statement = connection.prepareStatement(query); )
        {
          //execute select query and returns result set 
            ResultSet rset = statement.executeQuery();
            while (rset.next()) { 
                String categoryName=rset.getString("name");
                int numberOfChildren=rset.getInt("numberOfChildren");
                TopCategoryDetail topCategoryDetail=new TopCategoryDetail();
                topCategoryDetail.setName(categoryName);
                topCategoryDetail.setNumberOfChildren(numberOfChildren);
                listOfTopCategoryDetail.add(topCategoryDetail);
            }
            
        }
        catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return listOfTopCategoryDetail;
    }

}