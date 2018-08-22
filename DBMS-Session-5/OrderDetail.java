package storeFrontApplication;
import java.sql.*;

/**
 * This class represents Orders of user.
 *
 */
public class OrderDetail {
    private int orderId;
    private int productId;
    private Date orderDate;
    private double orderTotal;
    
    public int getProductId() {
        return productId;
    }
    
    public void setProductId(int productId) {
        this.productId = productId;
    }
    
    public int getOrderId() {
        return orderId;
    }
    
    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }
    
    public Date getOrderDate() {
        return orderDate;
    }
    
    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }
    
    public double getOrderTotal() {
        return orderTotal;
    }
    
    public void setOrderTotal(double orderTotal) {
        this.orderTotal = orderTotal;
    }
    
}