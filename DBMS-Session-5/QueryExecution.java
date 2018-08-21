package storeFrontApplication;

import java.sql.*;
import java.sql.Date;
import java.util.*;
public class QueryExecution {
    
    public List<OrderDetail> getOrderDetails(int userId)
    {
        List<OrderDetail> listOfOrderDetail=new ArrayList<OrderDetail>();
        String query=Query.getOrderDetailQuery(userId);
        try(Connection connection=DatabaseConnection.getConnection();
            PreparedStatement stmt = connection.prepareStatement(query); )
        {
            ResultSet rset = stmt.executeQuery();
            int rowCount = 0;
            while (rset.next()) { // Move the cursor to the next row, return false if no more row
                int orderId = rset.getInt("order_id");
                Date orderDate = rset.getDate("order_placing_date");
                double orderTotal = rset.getDouble("bill");

                OrderDetail orderDetail=new OrderDetail();
                orderDetail.setOrderId(orderId);
                orderDetail.setOrderDate(orderDate);
                orderDetail.setOrderTotal(orderTotal);
                listOfOrderDetail.add(orderDetail);
                ++rowCount;
            }
            
        }
        catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return listOfOrderDetail;
    }
    
    public void insertImage(List<ProductImage> listOfImage)
    {
        String query=Query.getInsertImageQuery();
        try(Connection connection=DatabaseConnection.getConnection();
                PreparedStatement stmt = connection.prepareStatement(query); )
            {
            try {
                connection.setAutoCommit(false);
                for (ProductImage image:listOfImage) {
                    stmt.setInt(1, image.getProductId());
                    stmt.setInt(2, image.getImageId());
                    stmt.setString(3, image.getImageUrl());
                    stmt.setString(4, image.getImageTag());
                    stmt.addBatch();
                }

                int[] result = stmt.executeBatch();
                connection.commit();

            } catch (SQLException ex) {
                ex.printStackTrace();
                connection.rollback();
            }
                
            }
        catch (SQLException e) {
            e.printStackTrace();
        }
            
    }
    
    public int updateProductStatus()
    {
        int updatedRows=0;
        String query=Query.getUpdateProductStatusQuery();
        try(Connection connection=DatabaseConnection.getConnection();
            PreparedStatement stmt = connection.prepareStatement(query); )
        {
            updatedRows=stmt.executeUpdate();
        }
        catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return updatedRows;
    }

}
